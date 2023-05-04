// don't change this code
// this is for test only

import java.util.Scanner;

public class TestRangeChecker {

    private static void testInteger() {

        Scanner scnr = new Scanner(System.in);
        int lo = scnr.nextInt();
        int hi = scnr.nextInt();

        RangeChecker<Integer> rc = new RangeChecker<Integer>(lo, hi);
        System.out.println(rc);

        while (scnr.hasNextInt()) {
            int i = scnr.nextInt();
            System.out.println(rc.check(i));
        }

        scnr.close();
    }

    private static void testString() {

        Scanner scnr = new Scanner(System.in);
        String lo = scnr.next();
        String hi = scnr.next();

        RangeChecker<String> rc = new RangeChecker<String>(lo, hi);
        System.out.println(rc);

        while (scnr.hasNext()) {
            String i = scnr.next();
            System.out.println(rc.check(i));
        }

        scnr.close();
    }

    public static void main(String[] args) {

        if ((args.length == 0) || (args[0].equals("Integer")))
            testInteger();
        else if (args[0].equals("String"))
            testString();
    }
}
