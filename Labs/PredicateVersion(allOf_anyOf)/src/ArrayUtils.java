import java.util.function.Predicate;

public class ArrayUtils {

    // Your new versions of anyOf() and allOf() go here.

    // anyOf predicate version
    public static <T> boolean anyOf(T[] a, Predicate<T> pred) {
        for (T t : a)               // same as for(int i = 0; i < a.length; i++)
            if (pred.test(t))
                return true;
        return false;
    }

    // allOf predicate version
    public static <T> boolean allOf(T[] a, Predicate<T> pred) {
        for (T t : a)               // same as for(int i = 0; i < a.length; i++)
            if (!pred.test(t))
                return false;
            return true;
    }


    // The version of the find() algorithm provided below
    // should help you determine the changes you need to make
    // to your code to create the new versions of anyOf()
    // and all().

    // Returns the index of the first element of 'a' for
    // which the given predicate returns true.  Returns
    // -1 if the predicate is false for all elements.
    public static <T> int find(T[] a, Predicate<T> pred) {
        for (int i = 0; i < a.length; i++)
            if (pred.test(a[i]))
                return i;
            return -1;
    }

}
