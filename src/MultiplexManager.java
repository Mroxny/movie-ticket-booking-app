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
    private List<Reservation> reservations;

    public MultiplexManager(List<Screening> screenings) {
        this.screenings = screenings;
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

    public Reservation makeReservation(String name, String surname, int screeningId, List<Seat> seats) {
        Screening screening = getScreening(screeningId);

        if (screening == null) {
            System.out.println("[RESERVATION ERROR]: Can't find screening with that Id");
            return null;
        }

        LocalDateTime now = LocalDateTime.now();
        LocalDateTime startDateTime = LocalDateTime.of(screening.getDay(), screening.getStartTime());
        if (now.isAfter(startDateTime) || now.plusMinutes(15).isAfter(startDateTime)) {
            System.out.println("[RESERVATION ERROR]: Can't make reservation at that time");
            return null;
        }

        if (seats.size() < 1 || seats.size() > 10) {
            System.out.println("[RESERVATION ERROR]: Wrong number of seats");
            return null;
        }

        List<Seat> screeningSeats = screening.getSeats();
        for (Seat seat : seats) {
            if (!screeningSeats.contains(seat)) {
                System.out.println("[RESERVATION ERROR]: Can't find seats like that");
                return null;
            }
        }

        LocalDateTime expirationTime = now.plusMinutes(15);
        double totalAmount = seats.stream().mapToDouble(seat -> seat.getSeatType().getPrice()).sum();
        Reservation reservation = new Reservation(name, surname, screening, seats, expirationTime, totalAmount);
        reservations.add(reservation);
        return reservation;
    }
}

