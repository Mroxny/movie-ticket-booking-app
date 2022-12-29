import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        LocalTime testTime1_1 = LocalTime.of(13,15);
        System.out.println(testTime1_1);
        LocalTime testTime1_2 = LocalTime.of(13,15);
        System.out.println(testTime1_2);
        LocalTime testTime2_1 = LocalTime.of(13,15);
        System.out.println(testTime2_1);
        LocalTime testTime2_2 = LocalTime.of(13,15);
        System.out.println(testTime2_2);

        LocalDate testDate1 = LocalDate.of(2001,2,22);
        System.out.println(testDate1);
        LocalDate testDate2 = LocalDate.now();
        System.out.println(testDate1);

        List<Seat> seats1 = Arrays.asList(
                new Seat(1, 1),
                new Seat(1, 2),
                new Seat(1, 3),
                new Seat(1, 4),
                new Seat(1, 5)
        );
    }
}
