import java.util.Arrays;

public class TestTimeOfDayComparable {
    public static void main(String[] args) {

        TimeOfDay[] times = new TimeOfDay[14];

        times[0] = new TimeOfDay(3, 3, 3);
        times[1] = new TimeOfDay(2, 3, 3);
        times[2] = new TimeOfDay(2, 2, 2);
        times[3] = new TimeOfDay(2, 4, 4);
        times[4] = new TimeOfDay(3, 3, 3);
        times[5] = new TimeOfDay(3, 4, 2);
        times[6] = new TimeOfDay(3, 4, 4);
        times[7] = new TimeOfDay(3, 2, 2);
        times[8] = new TimeOfDay(3, 2, 4);
        times[9] = new TimeOfDay(4, 3, 3);
        times[10] = new TimeOfDay(4, 2, 2);
        times[11] = new TimeOfDay(4, 4, 4);
        times[12] = new TimeOfDay(4, 2, 4);
        times[13] = new TimeOfDay(4, 4, 2);

        if (times[0].compareTo(times[1]) <= 0)
            System.out.println("Test 1 failed.");
        if (times[0].compareTo(times[2]) <= 0)
            System.out.println("Test 2 failed.");
        if (times[0].compareTo(times[3]) <= 0)
            System.out.println("Test 3 failed.");
        if (times[0].compareTo(times[4]) != 0)
            System.out.println("Test 4 failed.");
        if (times[0].compareTo(times[5]) >= 0)
            System.out.println("Test 5 failed.");
        if (times[0].compareTo(times[6]) >=  0)
            System.out.println("Test 6 failed.");
        if (times[0].compareTo(times[7]) <= 0)
            System.out.println("Test 7 failed.");
        if (times[0].compareTo(times[8]) <= 0)
            System.out.println("Test 8 failed.");
        if (times[0].compareTo(times[9]) >= 0)
            System.out.println("Test 9 failed.");
        if (times[0].compareTo(times[10]) >= 0)
            System.out.println("Test 10 failed.");
        if (times[0].compareTo(times[11]) >= 0)
            System.out.println("Test 11 failed.");
        if (times[0].compareTo(times[12]) >= 0)
            System.out.println("Test 12 failed.");
        if (times[0].compareTo(times[13]) >= 0)
            System.out.println("Test 13 failed.");

        Arrays.sort(times);
        for (TimeOfDay t : times)
            System.out.println(t);
    }
}
