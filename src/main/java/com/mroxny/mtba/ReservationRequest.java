package com.mroxny.mtba;

import org.springframework.boot.jackson.JsonObjectDeserializer;

import java.util.List;


public class ReservationRequest {
    private String name;
    private String surname;
    private int screeningId;
    private List<Seat> seats;

    public ReservationRequest(String name, String surname, int screeningId, List<Seat> seats) {
        this.name = name;
        this.surname = surname;
        this.screeningId = screeningId;
        this.seats = seats;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getScreeningId() {
        return screeningId;
    }

    public void setScreeningId(int screeningId) {
        this.screeningId = screeningId;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public void setSeats(List<Seat> seats) {
        this.seats = seats;
    }
}
