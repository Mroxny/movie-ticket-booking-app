package com.mroxny.mtba;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

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

    public int findSeat(Seat seat){
        return findSeat(seat.getRow(), seat.getColumn());
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

    public void bookSeats(Collection<Seat> seats){
        for(Seat s: seats){
            bookSeat(s.getRow(), s.getColumn(), s.getSeatType());
        }
    }

    public List<Seat> getRow(int row){
        return seats.stream().filter(s -> s.getRow() == row).collect(Collectors.toList());
    }

    public List<Seat> getAvailableSeats(){
        return seats.stream().filter(s -> !s.isBooked()).collect(Collectors.toList());
    }

    public boolean isSeatBooked(Seat seat){
        int i = findSeat(seat);

        try {
            return seats.get(i).isBooked();
        }
        catch (Exception e){
            return false;
        }

    }

}
