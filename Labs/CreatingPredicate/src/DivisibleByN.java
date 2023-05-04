import java.util.Scanner;
import java.util.function.Predicate;

public class DivisibleByN implements Predicate<Integer> {

    private int n;

    public DivisibleByN(int n) {
        this.n = n;
    }

    // test function
    // returns the result of (mun%n == 0)
    @Override
    public boolean test(Integer num) {
        return (num%n == 0);
    }

    public static void main(String[] args) {

        // Create our predicate object.
        DivisibleByN dvb5 = new DivisibleByN(5);

        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int n = sc.nextInt();
            if (dvb5.test(n)) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
    }
}
