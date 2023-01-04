package com.mroxny.mtba;


import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Service
public class MultiplexManager {
    private static List<Screening> screenings;

    private static List<Room> rooms;
    private static List<Reservation> reservations;

    public MultiplexManager() {
        screenings = Main.getScreenings();
        rooms = Main.getRooms();
        reservations = new ArrayList<>();
    }

    public List<Screening> listScreenings( LocalDate day,  LocalTime startTime, LocalTime endTime) {
        return screenings.stream()
                .filter(screening -> screening.getDay().isEqual(day) &&
                        screening.getStartTime().isAfter(startTime) &&
                        screening.getStartTime().isBefore(endTime))
                .sorted(Comparator.comparing((Screening screening) -> screening.getMovie().getTitle())
                        .thenComparing(Screening::getStartTime))
                .collect(Collectors.toList());
    }

    public Screening getScreening(int screeningId) {

        for (Screening s : screenings) {
            if (s.getScreeningId() == screeningId) return s;
        }
        return null;
    }

    public Room getRoom(int roomNumber){
        for (Room r : rooms) {
            if (r.getRoomNumber() == roomNumber) return r;
        }
        return null;
    }

    public List<Screening> listAllScreenings(){
        return screenings;
    }
    public Reservation getReservation(int id){
        for(Reservation r : reservations)
            if(r.getReservationId() == id) return r;
        return null;
    }

    public List<Reservation> getReservations(){
        return reservations;
    }

    public boolean canBookSeats(Room room, List<Seat> reservedSeats){
        reservedSeats.sort(new Comparator<Seat>() {
            @Override
            public int compare(Seat o1, Seat o2) {
                return o1.getColumn() - o2.getColumn();
            }
        });

        int rowNum = reservedSeats.get(0).getRow();
        if(!isSeatValid(room,reservedSeats.get(0))) return false;

        for(int i = 1; i < reservedSeats.size(); i++){
            if(reservedSeats.get(i).getRow() != rowNum){
                return false;
            }

            if(reservedSeats.get(i).getColumn()-1 != reservedSeats.get(i-1).getColumn()){
                return false;
            }

            if(!isSeatValid(room,reservedSeats.get(0))) return false;

        }
        return true;
    }

    private boolean isSeatValid(Room room, Seat seat){
        if(room.findSeat(seat) < 0) return false;
        return !room.isSeatBooked(seat);
    }

    public Reservation makeReservation( ReservationRequest request) {
        String name = request.getName();
        String surname = request.getSurname();
        int screeningId = request.getScreeningId();
        List<Seat> seats = request.getSeats();



        Screening screening = getScreening(screeningId);
        if (screening == null) {
            printReservationError("Can't find screening with id "+screeningId);
            return null;
        }

        Room room = getRoom(screening.getScreeningRoom());

        if(room == null){
            printReservationError("That screening has invalid room number: "+ screening.getScreeningRoom());
            return null;
        }

        LocalDateTime now = LocalDateTime.now();
        LocalDateTime startDateTime = LocalDateTime.of(screening.getDay(), screening.getStartTime());
        if (now.isAfter(startDateTime) || now.plusMinutes(15).isAfter(startDateTime)) {
            printReservationError("Can't make reservation at that time");
            return null;
        }

        if (seats.size() < 1 || seats.size() > 10) {
            printReservationError("Wrong number of seats");
            return null;
        }

        for (Seat seat : seats) {
            if (room.findSeat(seat) < 0) {
                printReservationError("Can't find seats like that");
                return null;
            }
        }

        String nameRegex = "^[A-Ż][a-żA-ż]{2,}$";
        String surnameRegex = "^[A-Ż][a-żA-Ż]*-[A-Ż][a-żA-Ż]*$";
        Pattern surnamePattern = Pattern.compile(surnameRegex);
        Pattern namePattern = Pattern.compile(nameRegex);

        Matcher matcher1 = namePattern.matcher(name);
        if(!matcher1.matches()){
            printReservationError("Invalid name");
            return null;
        }
        matcher1 = namePattern.matcher(surname);
        Matcher matcher2 = surnamePattern.matcher(surname);
        if(!matcher1.matches() && !matcher2.matches()){
            printReservationError("Invalid surname");
            return null;
        }

        if(!canBookSeats(room, seats)){
            printReservationError("Invalid seats placement");
            return null;
        }


        LocalDateTime expirationTime = LocalDateTime.of(screening.getDay(), screening.getStartTime()).minusMinutes(15);
        room.bookSeats(seats);
        double totalAmount = seats.stream().mapToDouble(seat -> seat.getSeatType().getPrice()).sum();
        Reservation reservation = new Reservation(name, surname, screening, seats, expirationTime, totalAmount);
        reservations.add(reservation);
        return reservation;
    }

    protected static void printReservationError(String msg){
        System.out.println("[RESERVATION ERROR]: "+msg);
    }
}

