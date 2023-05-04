// don't change this code
// for test only

import java.util.function.Predicate;

public class TestArrayUtils {

    private static void testPredicates() {

        Integer[] ia = { 62, 63, 30, 63, 29, 9, 57, 72, 33, 87 };

        Predicate<Integer> gt0   = new GreaterThanN(0);
        Predicate<Integer> gt50  = new GreaterThanN(50);
        Predicate<Integer> gt100 = new GreaterThanN(100);

        if (!ArrayUtils.anyOf(ia, gt0 ))  System.out.println("Test P1 failed");
        if (!ArrayUtils.anyOf(ia, gt50))  System.out.println("Test P2 failed");
        if ( ArrayUtils.anyOf(ia, gt100)) System.out.println("Test P3 failed");

        if (!ArrayUtils.allOf(ia, gt0 ))  System.out.println("Test P4 failed");
        if ( ArrayUtils.allOf(ia, gt50))  System.out.println("Test P5 failed");
        if ( ArrayUtils.allOf(ia, gt100)) System.out.println("Test P6 failed");

        String[] dw = { "Bashful", "Doc", "Dopey", "Grumpy", "Happy", "Sleepy", "Sneezy" };
        String[] nm = { "Don", "Donna", "Dolly", "Dolores", "Dominic", "Doria" };

        Predicate<String> swDo = new StartsWith("Do");
        Predicate<String> swS  = new StartsWith("S");
        Predicate<String> swX = new StartsWith("X");

        if (!ArrayUtils.anyOf(dw, swDo)) System.out.println("Test P7 failed");
        if (!ArrayUtils.anyOf(dw, swS))  System.out.println("Test P8 failed");
        if ( ArrayUtils.anyOf(dw, swX))  System.out.println("Test P9 failed");

        if (!ArrayUtils.allOf(nm, swDo)) System.out.println("Test P10 failed");
        if ( ArrayUtils.allOf(nm, swS))  System.out.println("Test P11 failed");
        if ( ArrayUtils.allOf(nm, swX))  System.out.println("Test P12 failed");
    }

    public static void main(String[] args) {

        testPredicates();
    }
}
