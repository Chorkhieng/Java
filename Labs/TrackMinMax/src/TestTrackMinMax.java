// don't change this code
// this is for test only
// run with command-line environment
// java TestTrackMinMax String (to run with the String inputs)
// java TestTrackMinMax Integer (to run with the Integer inputs)

import java.util.Scanner;

public class TestTrackMinMax {

    private static void testString() {

        Scanner scnr = new Scanner(System.in);

        TrackMinMax<String> tmms = new TrackMinMax<String>();

        while (scnr.hasNext()) {
            tmms.check(scnr.next());
        }

        System.out.println("Minimum: " + tmms.getMin());
        System.out.println("Maximum: " + tmms.getMax());
        System.out.println(tmms);
    }

    private static void testInteger() {

        Scanner scnr = new Scanner(System.in);

        TrackMinMax<Integer> tmmi = new TrackMinMax<Integer>();

        while (scnr.hasNextInt()) {
            tmmi.check(scnr.nextInt());
        }

        System.out.println("Minimum: " + tmmi.getMin());
        System.out.println("Maximum: " + tmmi.getMax());
        System.out.println(tmmi);
    }

    public static void main(String[] args) {

        if ((args.length == 0) || (args[0].equals("Integer")))
            testInteger();
        else if (args[0].equals("String"))
            testString();
    }
}
