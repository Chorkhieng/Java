public class BinarySearchExtra {

    public static int indexOf(int[] a, int lo, int hi, int value) {
        int curLo = lo;
        int curHi = hi;

        while (curLo < curHi) {
            int mid = curLo + (curHi - curLo) / 2;
            if (a[mid] == value){
                return mid;
            } else if (a[mid] < value){
                curLo = mid + 1;
            } else {
                curHi = mid;
            }
        }

        return -1;
    }

    public static int indexOf(int[] a, int value) {
        return indexOf(a, 0, a.length, value);
    }
}
