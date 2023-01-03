package com.mroxny.mtba;

import java.time.LocalDateTime;
import java.util.List;

public class Reservation {
    private String name;
    private String surname;
    private Screening screening;
    private List<Seat> seats;
    private LocalDateTime expirationTime;
    private double totalAmount;

    public Reservation(String name, String surname, Screening screening, List<Seat> seats, LocalDateTime expirationTime, double totalAmount) {
        this.name = name;
        this.surname = surname;
        this.screening = screening;
        this.seats = seats;
        this.expirationTime = expirationTime;
        this.totalAmount = totalAmount;
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

    public Screening getScreening() {
        return screening;
    }

    public void setScreening(Screening screening) {
        this.screening = screening;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public void setSeats(List<Seat> seats) {
        this.seats = seats;
    }

    public LocalDateTime getExpirationTime() {
        return expirationTime;
    }

    public void setExpirationTime(LocalDateTime expirationTime) {
        this.expirationTime = expirationTime;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    @Override
    public String toString() {
        return "app.Reservation{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", screeningId=" + screening.getScreeningId() +
                ", seats=" + seats +
                ", expirationTime=" + expirationTime +
                ", totalAmount=" + totalAmount +
                '}';
    }
}
