import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class MultiplexManager {
    private List<Movie> movies;
    private List<Screening> screenings;
    private List<Reservation> reservations;

    public MultiplexManager(List<Screening> screenings) {
        this.screenings = screenings;
        movies = new ArrayList<>();
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


    public Reservation makeReservation(String name, String surname, Screening screening, List<Seat> seats) {

        LocalDateTime now = LocalDateTime.now();

        LocalDateTime expirationTime = now.plusMinutes(15);
        double totalAmount = seats.stream().mapToDouble(seat -> seat.getSeatType().getPrice()).sum();
        Reservation reservation = new Reservation(name, surname, screening, seats, expirationTime, totalAmount);
        reservations.add(reservation);
        return reservation;
    }
}

