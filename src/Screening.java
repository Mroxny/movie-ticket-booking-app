import java.time.LocalTime;
import java.util.List;

public class Screening {
    private int screeningRoom;
    private LocalTime startTime;
    private LocalTime endTime;
    private List<Seat> seats;

    public Screening(int screeningRoom, LocalTime startTime, LocalTime endTime, List<Seat> seats) {
        this.screeningRoom = screeningRoom;
        this.startTime = startTime;
        this.endTime = endTime;
        this.seats = seats;
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
}
