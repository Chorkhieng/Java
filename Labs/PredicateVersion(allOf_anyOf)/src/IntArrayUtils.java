// This is provided for reference only.  It isn't really needed
// for the assignment itself.
// this original version of the previous lab

public class IntArrayUtils {

    // Returns the index of the first element of 'a' that
    // is equal to 'val'.  Returns -1 if no element matches.
    public static int find(int[] a, int val) {
        for (int i = 0; i < a.length; i++)
            if (a[i] == val)
                return i;
        return -1;
    }

    // Returns true if any element of 'a' is equal to 'val'
    // and false otherwise.
    public static boolean anyOf(int[] a, int val) {
        for (int i = 0; i < a.length; i++)
            if (a[i] == val)
                return true;
        return false;
    }

    // Returns true if every element of 'a' is equal to 'val'
    // and false otherwise.
    public static boolean allOf(int[] a, int val) {
        for (int i = 0; i < a.length; i++)
            if (a[i] != val)
                return false;
        return true;
    }
}
