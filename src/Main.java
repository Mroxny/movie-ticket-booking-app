import java.time.LocalDate;
import java.time.LocalTime;

public class Main {
    public static void main(String[] args) {
        LocalTime testTime = LocalTime.of(13,15);
        System.out.println(testTime);

        LocalDate testDate = LocalDate.of(2001,2,22);
        System.out.println(testDate);
    }
}
