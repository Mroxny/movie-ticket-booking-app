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
        LocalTime testTime2_2 = LocalTime.of(23,58);
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
                new Seat(1, 1, TicketType.ADULT),
                new Seat(1, 2, TicketType.CHILD),
                new Seat(1, 2, TicketType.STUDENT)
        );

        Movie movie1 = new Movie("Test1", 120);
        Movie movie2 = new Movie("Test2", 90);
        Movie movie3 = new Movie("Test3", 100);

        List<Room> rooms = new ArrayList<Room>(){};
        rooms.add(new Room(1, seats1));
        rooms.add(new Room(2, seats2));
        rooms.add(new Room(3, seats1));

        List<Screening> screenings = new ArrayList<Screening>(){};
        screenings.add(new Screening(1,testDate1,testTime1_1, movie1));
        screenings.add(new Screening(2,testDate2,testTime1_2, movie2));
        screenings.add(new Screening(3,testDate1,testTime2_1, movie1));
        screenings.add(new Screening(1,testDate1.plusDays(1),testTime1_1.plusHours(2), movie1));
        screenings.add(new Screening(2,testDate2.plusDays(1),testTime1_2.plusHours(2), movie2));
        screenings.add(new Screening(3,testDate1.plusDays(1),testTime2_1.plusHours(2), movie1));
        screenings.add(new Screening(1,testDate1.plusDays(2),testTime1_1.plusHours(2), movie1));
        screenings.add(new Screening(2,testDate2.plusDays(2),testTime1_2.plusHours(2), movie2));
        screenings.add(new Screening(3,testDate1.plusDays(2),testTime2_1.plusHours(2), movie1));


        MultiplexManager mm = new MultiplexManager(screenings, rooms);

        screenings.forEach(s -> System.out.println(s+"\n"));
        System.out.println(mm.listScreenings(testDate2.plusDays(2), LocalTime.of(0,0), LocalTime.of(23,59)));
        System.out.println(mm.makeReservation("Test", "żółć", 7, seats3));
    }
}
