// RangeChecker

public class RangeChecker<T extends Comparable<T>>{

    private T lo;
    private T hi;

    RangeChecker (T lo, T hi) {
        this.lo = lo;
        this.hi = hi;
    }

    // check function
    // returns true if i is greater than or equal to lo, and i is less than hi: [lo,hi)
    // otherwise returns false
    boolean check(T i) {
        if ((i.compareTo(lo) >= 0) && (i.compareTo(hi)) < 0) return true;
        else return false;
    }

    // toString function
    public String toString () {

        return "[" + lo + "," + hi + ")";
    }
}