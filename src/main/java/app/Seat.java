package app;

public class Seat {
    private int row;
    private int column;
    private boolean isBooked;
    private TicketType seatType;

    public Seat(int row, int column, boolean isBooked, TicketType seatType) {
        this.row = row;
        this.column = column;
        this.isBooked = isBooked;
        this.seatType = seatType;
    }

    public Seat(int row, int column, TicketType seatType){
        this(row,column, false, seatType);
    }

    public Seat(int row, int column, boolean isBooked){
        this(row,column, isBooked, TicketType.ADULT);
    }

    public Seat(int row, int column){
        this(row,column, false);
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

    @Override
    public String toString() {
        return "app.Seat{" +
                "row=" + row +
                ", column=" + column +
                ", seatType=" + seatType +
                '}';
    }
}

