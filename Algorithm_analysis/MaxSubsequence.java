import java.util.Random;

public class MaxSubsequence {

    // Adapted from _Data Structures and Algorithm Analysis_,
    // by Mark Allen Weiss

    public static int maxSubsequence1(int[] a) {
        int maxSum = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j <= a.length; j++) {
                int sum = 0;
                for (int k = i; k < j; k++)
                    sum += a[k];
                if (sum > maxSum)
                    maxSum = sum;
            }
        }
        return maxSum;
    }

    public static int maxSubsequence2(int[] a) {
        int maxSum = 0;
        for (int i = 0; i < a.length; i++) {
            int sum = 0;
            for (int j = i; j < a.length; j++) {
                sum += a[j];
                if (sum > maxSum)
                    maxSum = sum;
            }
        }
        return maxSum;
    }

    private static int max3(int a, int b, int c) {
        if ((a > b) && (a > c))
            return a;
        else if ((b > a) && (b > c))
            return b;
        else
            return c;
    }

    // Return maximum subsequence in a[lo,hi).
    public static int maxSubsequence3(int[] a, int lo, int hi) {

        // Base case: a 1-element range.
        if (hi - lo == 1)
            return Math.max(a[lo], 0);

        int mid = lo + (hi - lo) / 2;
        int maxLeft = maxSubsequence3(a, lo, mid);
        int maxRight = maxSubsequence3(a, mid, hi);

        int maxLeftBorder = 0;
        int leftBorder = 0;
        for (int i = mid; i > lo;) {
            leftBorder += a[--i];
            if (leftBorder > maxLeftBorder)
                maxLeftBorder = leftBorder;
        }

        int maxRightBorder = 0;
        int rightBorder = 0;
        for (int i = mid; i < hi;) {
            rightBorder += a[i++];
            if (rightBorder > maxRightBorder)
                maxRightBorder = rightBorder;
        }

        return max3(maxLeft, maxRight, maxLeftBorder + maxRightBorder);
    }

    public static int maxSubsequence3(int[] a) {
        return maxSubsequence3(a, 0, a.length);
    }

    public static int maxSubsequence4(int[] a) {
        int maxSum = 0;
        int sum = 0;
        for (int n : a) {
            sum += n;
            if (sum > maxSum)
                maxSum = sum;
            else if (sum < 0)
                sum = 0;
        }
        return maxSum;
    }

    public static void main(String[] args) {

        // Create a random number generator with a given seed; this
        // way we get the same sequence every time.
        // FWIW, it is not all that important that we get an
        // absolutely even distribution; this is just a test
        // client.  Using the remainder is sufficient, even if
        // it means some numbers may be generated more often
        // than others.
        Random rand = new Random(1);
        int[] a = new int[10];
        for (int i = 0; i < a.length; i++)
            a[i] = rand.nextInt() % 200 - 50;

        if (true) {
            for (int n : a)
                System.out.printf("%d ", n);
            System.out.println();
        }

        System.out.printf("Algorithm 1: %d\n", maxSubsequence1(a));
        System.out.printf("Algorithm 2: %d\n", maxSubsequence2(a));
        System.out.printf("Algorithm 3: %d\n", maxSubsequence3(a));
        System.out.printf("Algorithm 4: %d\n", maxSubsequence4(a));
    }
}
