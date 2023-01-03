package com.mroxny.mtba;

import java.time.LocalDate;
import java.time.LocalTime;

public class Screening {
    private static int sCount = 0;
    private int screeningId;
    private int screeningRoom;
    private LocalDate day;
    private LocalTime startTime;
    private LocalTime endTime;
    private Movie movie;

    public Screening(int screeningRoom, LocalDate day, LocalTime startTime, Movie movie) {
        screeningId = sCount++;
        this.screeningRoom = screeningRoom;
        this.day = day;
        this.startTime = startTime;

        // end screening after movie ends + ads
        setEndTime(startTime.plusMinutes(movie.getLength()+15));

        this.movie = movie;
    }

    public int getScreeningRoom() {
        return screeningRoom;
    }

    public void setScreeningRoom(int screeningRoom) {
        this.screeningRoom = screeningRoom;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }


    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public int getScreeningId() {
        return screeningId;
    }

    public void setScreeningId(int screeningId) {
        this.screeningId = screeningId;
    }

    public LocalDate getDay() {
        return day;
    }

    public void setDay(LocalDate day) {
        this.day = day;
    }

    @Override
    public String toString() {
        return "app.Screening{" +
                "screeningId=" + screeningId +
                ", screeningRoom=" + screeningRoom +
                ", day=" + day +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", movie=" + movie.getTitle() +
                '}';
    }
}
