import java.util.Scanner;

public class TestIntTrackMinMax {

    public static void main(String[] args) {

        Scanner scnr = new Scanner(System.in);
        IntTrackMinMax tmm = new IntTrackMinMax();

        while (scnr.hasNext()) {
            tmm.check(scnr.nextInt());
        }

        System.out.println("Minimum: " + tmm.getMin());
        System.out.println("Maximum: " + tmm.getMax());
        System.out.println(tmm);
    }
}

