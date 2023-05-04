public class ArrayUtils {
    public static <T extends Comparable<T>> int minElement(T[] a, int lo, int hi) {
        int idxMin = lo;
        for (int i = lo + 1; i < hi; i++)
            if (a[i].compareTo(a[idxMin]) < 0)
                idxMin = i;
        return idxMin;
    }

    public static <T> void swap(T[] a, int idx1, int idx2) {
        T t = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = t;
    }

    public static <T> void rotateRight(T[] a, int lo, int hi) {
        if (hi - lo < 2)
            return;
        T t = a[hi - 1];
        for (int i = hi - 1; i > lo; i--) {
            a[i] = a[i - 1];
        }
        a[lo] = t;
    }

    public static <T extends Comparable<T>> int upperBound(T[] a, int lo, int hi, T value) {
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (a[mid].compareTo(value) <= 0)
                lo = mid + 1;
            else
                hi = mid;
        }
        return hi;
    }
}
