import java.util.Scanner;

public class TestTwoSum {

    public static void main(String[] args) {

        Scanner scnr = new Scanner(System.in);

        int n = scnr.nextInt();
        int[] a = new int[n];

        for (int i = 0; i < n; i++)
            a[i] = scnr.nextInt();
        scnr.close();

        System.out.println(TwoSum.countSlow(a));
        System.out.println(TwoSum.countFast(a));
    }
}
