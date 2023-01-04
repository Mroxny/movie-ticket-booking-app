package com.mroxny.mtba;

import java.util.List;

public class ScreeningResponse {
    private int screeningRoom;
    private List<Seat> availableSeats;


    public ScreeningResponse(int screeningRoom, List<Seat> availableSeats) {
        this.screeningRoom = screeningRoom;
        this.availableSeats = availableSeats;
    }

    public int getScreeningRoom() {
        return screeningRoom;
    }

    public void setScreeningRoom(int screeningRoom) {
        this.screeningRoom = screeningRoom;
    }

    public List<Seat> getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(List<Seat> availableSeats) {
        this.availableSeats = availableSeats;
    }
}
