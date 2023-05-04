public class TestBinarySearch {

    private static void error(int testNum) {
        System.out.printf("Test %d failed\n", testNum);
    }

    public static void main(String[] args) {

        int[] a = { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31 };

        for (int i = 0; i < a.length; i++)
            if (BinarySearchExtra.indexOf(a, a[i]) != i)
                error(i);

        if (BinarySearchExtra.indexOf(a, 1) != -1) error(11);
        if (BinarySearchExtra.indexOf(a, 10) != -1) error(12);
        if (BinarySearchExtra.indexOf(a, 37) != -1) error(13);

        int lo = 3;
        int hi = 8;
        for (int i = lo; i < hi; i++)
            if (BinarySearchExtra.indexOf(a, lo, hi, a[i]) != i)
                error(i+20);

        if (BinarySearchExtra.indexOf(a, lo, hi, a[lo-1]) != -1) error(31);
        if (BinarySearchExtra.indexOf(a, lo, hi, a[hi]) != -1) error(32);
        if (BinarySearchExtra.indexOf(a, lo, hi, 1) != -1) error(33);
        if (BinarySearchExtra.indexOf(a, lo, hi, 15) != -1) error(34);
        if (BinarySearchExtra.indexOf(a, lo, hi, 37) != -1) error(35);
    }
}
