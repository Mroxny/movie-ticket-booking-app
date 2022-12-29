public class Seat {
    private int row;
    private int column;
    private boolean isBooked;
    private TicketType seatType;

    public Seat(int row, int column, boolean isBooked) {
        this.row = row;
        this.column = column;
        this.isBooked = isBooked;
        seatType = TicketType.ADULT;
    }

    public Seat(int row, int column){
        this(row,column, true);
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public boolean isBooked() {
        return isBooked;
    }

    public void setBooked(boolean booked) {
        isBooked = booked;
    }

    public TicketType getSeatType() {
        return seatType;
    }

    public void setSeatType(TicketType seatType) {
        this.seatType = seatType;
    }
}

