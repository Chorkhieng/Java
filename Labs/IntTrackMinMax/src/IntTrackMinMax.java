// IntTrackMinMax

public class IntTrackMinMax {

    int min;
    int max;
    int position;

    // constructor
    IntTrackMinMax() {
        position = 0;
    }
    // check function
    public void check(int i) {
        if (position == 0) {
            min = i;
            max = i;
            position++;
        }
        if (i > max) max = i;
        if (i < min) min = i;
    }

    // getMin function
    public int getMin() {
        return min;
    }

    // getMax function
    public int getMax() {
        return max;
    }

    // toString function
    public String toString() {
        return String.format("[%d,%d]", min, max);
    }
}

