import java.util.List;

public class Room {
    private int roomNumber;
    private List<Seat> seats;

    public Room(int roomNumber, List<Seat> seats) {
        this.roomNumber = roomNumber;
        this.seats = seats;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public void setSeats(List<Seat> seats) {
        this.seats = seats;
    }

    private int findSeat(int row, int col){
        for(int i = 0; i<seats.size(); i++){
            if(seats.get(i).getRow() == row && seats.get(i).getColumn() == col) return i;
        }
        return -1;
    }

    public void bookSeat(int row, int col, TicketType type ){
        seats.get(findSeat(row,col)).setBooked(true);
        seats.get(findSeat(row,col)).setSeatType(type);
    }
    public void bookSeat(int row, int col){
        bookSeat(row,col, TicketType.ADULT);
    }
}
