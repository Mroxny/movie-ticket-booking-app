public class Seat {
    private int row;
    private int column;
    private TicketType ticketType;

    public Seat(int row, int column, TicketType ticketType) {
        this.row = row;
        this.column = column;
        this.ticketType = ticketType;
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

    public TicketType getTicketType() {
        return ticketType;
    }

    public void setTicketType(TicketType ticketType) {
        this.ticketType = ticketType;
    }
}

