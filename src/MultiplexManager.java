import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.chrono.ChronoLocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class MultiplexManager {
    private List<Screening> screenings;
    private List<Room> rooms;
    private List<Reservation> reservations;

    public MultiplexManager(List<Screening> screenings, List<Room> rooms) {
        this.screenings = screenings;
        this.rooms = rooms;
        reservations = new ArrayList<>();
    }

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

        List<Seat> screeningSeats = room.getSeats();
        for (Seat seat : seats) {
            if (!screeningSeats.contains(seat)) {
                printReservationError("Can't find seats like that");
                return null;
            }
        }

        LocalDateTime expirationTime = now.plusMinutes(15);
        double totalAmount = seats.stream().mapToDouble(seat -> seat.getSeatType().getPrice()).sum();
        Reservation reservation = new Reservation(name, surname, screening, seats, expirationTime, totalAmount);
        reservations.add(reservation);
        return reservation;
    }

    protected static void printReservationError(String msg){
        System.out.println("[RESERVATION ERROR]: "+msg);
    }
}

