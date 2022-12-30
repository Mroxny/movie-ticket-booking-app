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

    public int findSeat(int row, int col){
        for(int i = 0; i<seats.size(); i++){
            if(seats.get(i).getRow() == row && seats.get(i).getColumn() == col) return i;
        }
        return -1;
    }

    public void bookSeat(int row, int col, TicketType type ){
        int seatIndex = findSeat(row,col);

        if(seatIndex < 0){
            System.out.println("Cannot find seat like this: row = "+ row +", col = "+ col);
            return;
        }

        seats.get(seatIndex).setBooked(true);
        seats.get(seatIndex).setSeatType(type);
    }

    public void bookSeat(int row, int col){
        bookSeat(row,col, TicketType.ADULT);
    }

    public void bookSeat(Seat seat){
        bookSeat(seat.getRow(),seat.getColumn(), seat.getSeatType());
    }
}
