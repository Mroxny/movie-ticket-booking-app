package com.mroxny.mtba;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class TestData {

    /**
     *
     * @param num Seat type variant
     * @return Returns the list of seats for the given variant
     */
    public static List<Seat> getSeats(int num){
        List<Seat> seats1 = Arrays.asList(
                new Seat(1, 1, TicketType.ADULT),
                new Seat(1, 2, TicketType.ADULT),
                new Seat(1, 3, TicketType.ADULT),
                new Seat(1, 4, TicketType.ADULT),
                new Seat(1, 5, TicketType.ADULT),
                new Seat(2, 1, TicketType.ADULT),
                new Seat(2, 2, TicketType.ADULT),
                new Seat(2, 3, TicketType.ADULT),
                new Seat(2, 4, TicketType.ADULT),
                new Seat(2, 5, TicketType.ADULT)
        );

        List<Seat> seats2 = Arrays.asList(
                new Seat(1, 1, TicketType.ADULT),
                new Seat(1, 2, TicketType.ADULT),
                new Seat(1, 3, TicketType.ADULT),
                new Seat(1, 4, TicketType.ADULT),
                new Seat(1, 5, TicketType.ADULT),
                new Seat(1, 6, TicketType.ADULT),
                new Seat(2, 1, TicketType.ADULT),
                new Seat(2, 2, TicketType.ADULT),
                new Seat(2, 3, TicketType.ADULT),
                new Seat(2, 4, TicketType.ADULT),
                new Seat(2, 5, TicketType.ADULT),
                new Seat(2, 6, TicketType.ADULT)
        );

        List<Seat> seats3 = Arrays.asList(
                new Seat(1, 1, TicketType.ADULT),
                new Seat(1, 3, TicketType.CHILD),
                new Seat(1, 2, TicketType.STUDENT)
        );

        switch (num) {
            case 1 -> {
                return seats1;
            }
            case 2 -> {
                return seats2;
            }
            case 3 -> {
                return seats3;
            }
        }
        return seats1;
    }

    public static List<Room> getRooms(){
        List<Room> rooms = new ArrayList<Room>(){};
        rooms.add(new Room(1, getSeats(1)));
        rooms.add(new Room(2, getSeats(2)));
        rooms.add(new Room(3, getSeats(1)));

        return rooms;
    }

    public static List<Screening> getScreenings(){
        Movie movie1 = new Movie("Test1", 120);
        Movie movie2 = new Movie("Test2", 90);
        Movie movie3 = new Movie("Test3", 100);



        List<Screening> screenings = new ArrayList<Screening>(){};
        screenings.add(new Screening(1,LocalDate.now(),LocalTime.of(12,0), movie1));
        screenings.add(new Screening(2,LocalDate.now(),LocalTime.of(11,25), movie2));
        screenings.add(new Screening(3,LocalDate.now(),LocalTime.of(15,30), movie1));
        screenings.add(new Screening(1,LocalDate.now().plusDays(1),LocalTime.of(12,0).plusHours(2), movie1));
        screenings.add(new Screening(2,LocalDate.now().plusDays(1),LocalTime.of(12,0).plusHours(2), movie2));
        screenings.add(new Screening(3,LocalDate.now().plusDays(1),LocalTime.of(12,0).plusHours(2), movie1));

        return screenings;
    }
}
