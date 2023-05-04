// IntRangeChecker

public class IntRangeChecker {
    private int lo;
    private int hi;

    IntRangeChecker (int lo, int hi) {
        this.lo = lo;
        this.hi = hi;
    }

    // check function
    boolean check(int i) {
        if (i>=lo && i<hi) return true;
        else return false;
    }

    // toString function
    public String toString () {

        return String.format("[%d,%d)", lo, hi);
    }
}