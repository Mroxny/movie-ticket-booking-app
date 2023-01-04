package com.mroxny.mtba;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;

public class Seat {
    private int row;
    private int column;
    private boolean isBooked = false;
    private TicketType seatType;

    public Seat(int row, int column, TicketType seatType) {
        this.row = row;
        this.column = column;
        this.seatType = seatType;
    }

    public int getRow() {
        return row;
    }

    @JsonProperty("row")
    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    @JsonProperty("column")
    public void setColumn(int column) {
        this.column = column;
    }

    public boolean isBooked() {
        return isBooked;
    }

    @JsonProperty("isBooked")
    public void setBooked(boolean booked) {
        isBooked = booked;
    }

    public TicketType getSeatType() {
        return seatType;
    }

    @JsonProperty("seatType")
    public void setSeatType(TicketType seatType) {
        this.seatType = seatType;
    }


}

