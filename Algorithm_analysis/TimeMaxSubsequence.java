import java.util.Random;

public class TimeMaxSubsequence {

    public static void runOneTest(int alg, int size) {

        // Create a random number generator with a given seed;
        // this way we get the same sequence every time.
        // FWIW, it is not all that important that we get an
        // absolutely even distribution.  Using the remainder
        // is sufficient, even if it means some numbers may be
        // generated more often than others.
        Random rand = new Random(42);
        int[] a = new int[size];
        for (int i = 0; i < a.length; i++)
            a[i] = rand.nextInt() % 200 - 100;

        int mss = 0;
        Timer timer = new Timer();
        if (alg == 1)
            mss = MaxSubsequence.maxSubsequence1(a);
        else if (alg == 2)
            mss = MaxSubsequence.maxSubsequence2(a);
        else if (alg == 3)
            mss = MaxSubsequence.maxSubsequence3(a);
        else if (alg == 4)
            mss = MaxSubsequence.maxSubsequence4(a);
        double t = timer.elapsed();

        System.out.printf("%d,%7d,%5d,%7.3f\n", alg, size, mss, t);
    }

    public static void main(String[] args) {

        if (args.length < 2) {
            System.out.println("Usage: TimeMaxSubsequence <alg> <size>\n");
            System.exit(0);
        }
        int alg = Integer.parseInt(args[0]);
        int size = Integer.parseInt(args[1]);

        runOneTest(alg, size);
    }
}
