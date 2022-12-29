import java.time.LocalTime;
import java.util.List;

public class Screening {
    private static int sCount = 0;
    private int screeningId;
    private int screeningRoom;
    private LocalTime startTime;
    private LocalTime endTime;
    private List<Seat> seats;
    private Movie movie;

    public Screening(int screeningRoom, LocalTime startTime, List<Seat> seats, Movie movie) {
        screeningId = sCount++;
        this.screeningRoom = screeningRoom;
        this.startTime = startTime;

        // end screening after movie ends + ads
        setEndTime(startTime.plusMinutes(movie.getLength()+15));
        this.seats = seats;
        this.movie = movie;
    }

    public int getScreeningRoom() {
        return screeningRoom;
    }

    public void setScreeningRoom(int screeningRoom) {
        this.screeningRoom = screeningRoom;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public void setSeats(List<Seat> seats) {
        this.seats = seats;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public int getScreeningId() {
        return screeningId;
    }

    public void setScreeningId(int screeningId) {
        this.screeningId = screeningId;
    }
}
