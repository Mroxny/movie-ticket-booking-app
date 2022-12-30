import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        LocalTime testTime1_1 = LocalTime.of(13,15);
        System.out.println(testTime1_1);
        LocalTime testTime1_2 = LocalTime.of(14,0);
        System.out.println(testTime1_2);
        LocalTime testTime2_1 = LocalTime.of(11,30);
        System.out.println(testTime2_1);
        LocalTime testTime2_2 = LocalTime.of(17,25);
        System.out.println(testTime2_2);

        LocalDate testDate1 = LocalDate.of(2001,2,22);
        System.out.println(testDate1);
        LocalDate testDate2 = LocalDate.now();
        System.out.println(testDate2);

        List<Seat> seats1 = Arrays.asList(
                new Seat(1, 1),
                new Seat(1, 2),
                new Seat(1, 3),
                new Seat(1, 4),
                new Seat(1, 5),
                new Seat(2, 1),
                new Seat(2, 2),
                new Seat(2, 3),
                new Seat(2, 4),
                new Seat(2, 5)
        );
        List<Seat> seats2 = Arrays.asList(
                new Seat(1, 1),
                new Seat(1, 2),
                new Seat(1, 3),
                new Seat(1, 4),
                new Seat(1, 5),
                new Seat(1, 6),
                new Seat(1, 1),
                new Seat(1, 2),
                new Seat(1, 3),
                new Seat(1, 4),
                new Seat(1, 5),
                new Seat(1, 6)
        );

        List<Seat> seats3 = Arrays.asList(
                new Seat(1, 1),
                new Seat(1, 2)
        );

        Movie movie1 = new Movie("Test1", 120);
        Movie movie2 = new Movie("Test2", 90);

        List<Room> rooms = new ArrayList<Room>(){};
        rooms.add(new Room(1, seats1));
        rooms.add(new Room(2, seats2));
        rooms.add(new Room(3, seats1));
        rooms.add(new Room(4, seats2));

        List<Screening> screenings = new ArrayList<Screening>(){};
        screenings.add(new Screening(1,testDate1,testTime1_1, movie1));
        screenings.add(new Screening(3,testDate2,testTime1_2, movie2));
        screenings.add(new Screening(2,testDate1,testTime2_1, movie1));
        screenings.add(new Screening(1,testDate2,testTime2_2, movie2));


        MultiplexManager mm = new MultiplexManager(screenings, rooms);

        System.out.println(mm.listScreenings(testDate2, LocalTime.of(12,0), LocalTime.of(23,59)));
        System.out.println(mm.makeReservation("Test", "SurTest", 3, seats2));
    }
}
