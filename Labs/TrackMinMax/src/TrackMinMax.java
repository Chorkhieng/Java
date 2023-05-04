// IntTrackMinMax
// run on command-line environment with TestTrackMinMax:

// creating new type from TrackMinMax with Comparable interface

public class TrackMinMax<T extends Comparable<T>>{

    // declare instance variables as type T
    private T min;
    private T max;

    // declare a instance boolean variable
    private boolean exist;

    // constructor
    public TrackMinMax() {
        exist = false;
    }

    // check function
    public void check(T i) {
        if (exist == false) { // can be used as (!exist)
            exist = true;
            min = i;
            max = i;

        }
        if (i.compareTo(max) > 0) max = i;
        if (i.compareTo(min) < 0) min = i;
    }

    // return type in getMin and getMax must be T type
    // getMin function
    public T getMin() {
        return min;
    }

    // getMax function
    public T getMax() {
        return max;
    }

    // toString function
    // can't use String.format() because type T is generics
    public String toString() {
        return "[" + min + "," + max + "]";
    }
}
