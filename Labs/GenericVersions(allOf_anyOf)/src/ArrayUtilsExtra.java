
public class ArrayUtilsExtra {

    // Your new versions of anyOf() and allOf() go here.



    // The versions of the find() algorithm provided below
    // should help you determine the changes you need to make
    // to your code to create the new versions of anyOf()
    // and all().

    // Returns the index of the first element of 'a' that
    // is equal to 'val'.  Returns -1 if no element matches.
    public static <T> int find(T[] a, T val) {
        for (int i = 0; i < a.length; i++)
            if (a[i].equals(val))
                return i;
        return -1;
    }

    // Returns true if any element of 'a' is equal to 'val'
    // and false otherwise.
    public static <T> boolean anyOf(T[] a, T val) {
        for (int i = 0; i < a.length; i++)
            if (a[i].equals(val))
                return true;
        return false;
    }

    // Returns true if every element of 'a' is equal to 'val'
    // and false otherwise.
    public static <T> boolean allOf(T[] a, T val) {
        for (int i = 0; i < a.length; i++)
            if (!a[i].equals(val))
                return false;
        return true;
    }
}


