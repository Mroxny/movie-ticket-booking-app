import java.time.LocalTime;
import java.util.List;

public class Screening {
    private int screeningRoom;
    private LocalTime startTime;
    private LocalTime endTime;
    private List<Seat> seats;
    private Movie movie;

    public Screening(int screeningRoom, LocalTime startTime, LocalTime endTime, List<Seat> seats, Movie movie) {
        this.screeningRoom = screeningRoom;
        this.startTime = startTime;
        this.endTime = endTime;
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
}
