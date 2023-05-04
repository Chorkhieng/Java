import java.util.Scanner;

public class TestIntRangeChecker {

    public static void main(String[] args) {

        Scanner scnr = new Scanner(System.in);
        int lo = scnr.nextInt();
        int hi = scnr.nextInt();

        IntRangeChecker rc = new IntRangeChecker(lo, hi);
        System.out.println(rc);

        while (scnr.hasNext()) {
            int i = scnr.nextInt();
            System.out.println(rc.check(i));
        }
    }
}
