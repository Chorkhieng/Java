public class Sort2 {

    public static <T extends Comparable<T>> void selectionSort(T[] a) {
        for (int i = 0; i < a.length; i++) {
            int idx = ArrayUtils.minElement(a, i, a.length);
            ArrayUtils.swap(a, i, idx);
        }
    }

    public static <T1 extends Comparable<T1>, T2> void selectionSort(T1[] a, T2[] b) {
        // Your code goes here.
        for (int i = 0; i < a.length && i < b.length; i++) {
            int idx = ArrayUtils.minElement(a, i, a.length);
            ArrayUtils.swap(a, i, idx);
            ArrayUtils.swap(b, i, idx);
        }
    }

    public static <T1 extends Comparable<T1>> void insertionSort(T1[] a) {
        for (int i = +1; i < a.length; i++) {
            int idx = ArrayUtils.upperBound(a, 0, i, a[i]);
            ArrayUtils.rotateRight(a, idx, i+1);
        }
    }

    public static <T1 extends Comparable<T1>, T2> void insertionSort(T1[] a, T2[] b) {
        // Your code goes here.
        for (int i = +1; i < a.length && i < b.length; i++) {
            int idx = ArrayUtils.upperBound(a, 0, i, a[i]);
            ArrayUtils.rotateRight(a, idx, i+1);
            ArrayUtils.rotateRight(b, idx, i+1);
        }
    }
}
