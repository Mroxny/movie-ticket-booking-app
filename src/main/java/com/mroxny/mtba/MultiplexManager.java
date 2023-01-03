package com.mroxny.mtba;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@RestController
public class MultiplexManager {
    private List<Screening> screenings;
    private List<Room> rooms;
    private List<Reservation> reservations;

    public MultiplexManager(List<Screening> screenings, List<Room> rooms) {
        this.screenings = screenings;
        this.rooms = rooms;
        reservations = new ArrayList<>();
    }

    @GetMapping("/test")
    public String test(){
        return "Test 123";
    }

    @GetMapping("/listScreenings")
    public List<Screening> listScreenings(LocalDate day, LocalTime startTime, LocalTime endTime) {
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

    public boolean canBookSeats(List<Seat> reservedSeats){
        reservedSeats.sort(new Comparator<Seat>() {
            @Override
            public int compare(Seat o1, Seat o2) {
                return o1.getColumn() - o2.getColumn();
            }
        });

        int rowNum = reservedSeats.get(0).getRow();

        for(int i = 1; i < reservedSeats.size(); i++){
            if(reservedSeats.get(i).getRow() != rowNum){
                return false;
            }

            if(reservedSeats.get(i).getColumn()-1 != reservedSeats.get(i-1).getColumn()){
                return false;
            }
        }


        return true;
    }

    public Reservation makeReservation(String name, String surname, int screeningId, List<Seat> seats) {
        Screening screening = getScreening(screeningId);
        if (screening == null) {
            printReservationError("Can't find screening with that Id");
            return null;
        }

        Room room = getRoom(screening.getScreeningRoom());

        if(room == null){
            printReservationError("That screening has invalid room number");
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

        String nameRegex = "^[A-Z][a-zA-Z]{2,}$";
        String surnameRegex = "^[A-Z][a-zA-Z]*-[A-Z][a-zA-Z]*$";
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

        if(!canBookSeats(seats)){
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

