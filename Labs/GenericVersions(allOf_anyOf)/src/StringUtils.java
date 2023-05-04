
public class StringUtils {

    // Concatentate two String objects.
    // This is a sneaky of breaking code that compares String
    // objects using == instead of .equals().
    public static String concat(String s1, String s2) {
        return s1 + s2;
    }
}
