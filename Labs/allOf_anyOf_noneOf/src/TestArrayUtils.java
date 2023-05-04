import java.util.Arrays;

public class TestArrayUtils {

    private static void error(String funcName, int testNum) {
        System.out.printf("%s test %d failed\n", funcName, testNum);
    }

    private static void testAllOf(boolean testSubRanges) {

        String funcName = "allOf";
        System.out.printf("Testing %s with%s subranges\n", funcName, testSubRanges ? "" : "out");

        int[] a1 = { 10, 10, 10, 10 };
        int[] a2 = { 20, 10, 10, 10 };
        int[] a3 = { 10, 10, 10, 20 };

        if (!ArrayUtilsExtra.allOf(a1, 10)) error(funcName, 1);
        if ( ArrayUtilsExtra.allOf(a1, 20)) error(funcName, 2);
        if ( ArrayUtilsExtra.allOf(a2, 10)) error(funcName, 3);
        if ( ArrayUtilsExtra.allOf(a2, 20)) error(funcName, 4);
        if ( ArrayUtilsExtra.allOf(a3, 10)) error(funcName, 5);
        if ( ArrayUtilsExtra.allOf(a3, 20)) error(funcName, 6);

        /////////////////////////////////
        //
        // Test subranges with a1
        //

        // Test full range.
        if (!ArrayUtilsExtra.allOf(a1, 0, 4, 10)) error(funcName, 7);
        if ( ArrayUtilsExtra.allOf(a1, 0, 4, 20)) error(funcName, 8);

        // Test without first element
        if (!ArrayUtilsExtra.allOf(a1, 1, 4, 10)) error(funcName, 9);
        if ( ArrayUtilsExtra.allOf(a1, 1, 4, 20)) error(funcName, 10);

        // Test without last element
        if (!ArrayUtilsExtra.allOf(a1, 0, 3, 10)) error(funcName, 11);
        if ( ArrayUtilsExtra.allOf(a1, 0, 3, 20)) error(funcName, 12);

        // Test empty range at beginning
        if (!ArrayUtilsExtra.allOf(a1, 0, 0, 10)) error(funcName, 13);
        if (!ArrayUtilsExtra.allOf(a1, 0, 0, 20)) error(funcName, 14);

        // Test empty range in the middle
        if (!ArrayUtilsExtra.allOf(a1, 2, 2, 10)) error(funcName, 15);
        if (!ArrayUtilsExtra.allOf(a1, 2, 2, 20)) error(funcName, 16);

        // Test empty range at the end
        if (!ArrayUtilsExtra.allOf(a1, 4, 4, 10)) error(funcName, 17);
        if (!ArrayUtilsExtra.allOf(a1, 4, 4, 20)) error(funcName, 18);

        // Test one-element range at the beginning
        if (!ArrayUtilsExtra.allOf(a1, 0, 1, 10)) error(funcName, 19);
        if ( ArrayUtilsExtra.allOf(a1, 0, 1, 20)) error(funcName, 20);

        // Test one-element range at the end
        if (!ArrayUtilsExtra.allOf(a1, 3, 4, 10)) error(funcName, 21);
        if ( ArrayUtilsExtra.allOf(a1, 3, 4, 20)) error(funcName, 22);

        /////////////////////////////////
        //
        // Test subranges with a2
        //

        // Test full range
        if ( ArrayUtilsExtra.allOf(a2, 0, 4, 10)) error(funcName, 23);
        if ( ArrayUtilsExtra.allOf(a2, 0, 4, 20)) error(funcName, 24);

        // Test 1-element range at the beginning
        if ( ArrayUtilsExtra.allOf(a2, 0, 1, 10)) error(funcName, 25);
        if (!ArrayUtilsExtra.allOf(a2, 0, 1, 20)) error(funcName, 26);

        // Test 1-element range after different element
        if (!ArrayUtilsExtra.allOf(a2, 1, 2, 10)) error(funcName, 27);
        if ( ArrayUtilsExtra.allOf(a2, 1, 2, 20)) error(funcName, 28);

        // Test 2-element range at the beginning
        if ( ArrayUtilsExtra.allOf(a2, 0, 2, 10)) error(funcName, 29);
        if ( ArrayUtilsExtra.allOf(a2, 0, 2, 20)) error(funcName, 30);

        /////////////////////////////////
        //
        // Test subranges with a3
        //

        // Test full range
        if ( ArrayUtilsExtra.allOf(a3, 0, 4, 10)) error(funcName, 31);
        if ( ArrayUtilsExtra.allOf(a3, 0, 4, 20)) error(funcName, 32);

        // Test 1-element range at the end
        if ( ArrayUtilsExtra.allOf(a3, 3, 4, 10)) error(funcName, 33);
        if (!ArrayUtilsExtra.allOf(a3, 3, 4, 20)) error(funcName, 34);

        // Test 1-element range before different element
        if (!ArrayUtilsExtra.allOf(a3, 2, 3, 10)) error(funcName, 35);
        if ( ArrayUtilsExtra.allOf(a3, 2, 3, 20)) error(funcName, 36);

        // Test 2-element range at the end
        if ( ArrayUtilsExtra.allOf(a3, 2, 4, 10)) error(funcName, 37);
        if ( ArrayUtilsExtra.allOf(a3, 2, 4, 20)) error(funcName, 38);
    }

    private static void testAnyOf(boolean testSubRanges) {

        String funcName = "anyOf";
        System.out.printf("Testing %s with%s subranges\n", funcName, testSubRanges ? "" : "out");

        int[] a1 = { 10, 10, 10, 10 };
        int[] a2 = { 20, 10, 10, 10 };
        int[] a3 = { 10, 10, 10, 20 };

        if (!ArrayUtilsExtra.anyOf(a1, 10)) error(funcName, 1);
        if ( ArrayUtilsExtra.anyOf(a1, 20)) error(funcName, 2);
        if (!ArrayUtilsExtra.anyOf(a2, 10)) error(funcName, 3);
        if (!ArrayUtilsExtra.anyOf(a2, 20)) error(funcName, 4);
        if (!ArrayUtilsExtra.anyOf(a3, 10)) error(funcName, 5);
        if (!ArrayUtilsExtra.anyOf(a3, 20)) error(funcName, 6);

        /////////////////////////////////
        //
        // Test subranges with a1
        //

        // Test full range.
        if (!ArrayUtilsExtra.anyOf(a1, 0, 4, 10)) error(funcName, 7);
        if ( ArrayUtilsExtra.anyOf(a1, 0, 4, 20)) error(funcName, 8);

        // Test without first element
        if (!ArrayUtilsExtra.anyOf(a1, 1, 4, 10)) error(funcName, 9);
        if ( ArrayUtilsExtra.anyOf(a1, 1, 4, 20)) error(funcName, 10);

        // Test without last element
        if (!ArrayUtilsExtra.anyOf(a1, 0, 3, 10)) error(funcName, 11);
        if ( ArrayUtilsExtra.anyOf(a1, 0, 3, 20)) error(funcName, 12);

        // Test empty range at beginning
        if ( ArrayUtilsExtra.anyOf(a1, 0, 0, 10)) error(funcName, 13);
        if ( ArrayUtilsExtra.anyOf(a1, 0, 0, 20)) error(funcName, 14);

        // Test empty range in the middle
        if ( ArrayUtilsExtra.anyOf(a1, 2, 2, 10)) error(funcName, 15);
        if ( ArrayUtilsExtra.anyOf(a1, 2, 2, 20)) error(funcName, 16);

        // Test empty range at the end
        if ( ArrayUtilsExtra.anyOf(a1, 4, 4, 10)) error(funcName, 17);
        if ( ArrayUtilsExtra.anyOf(a1, 4, 4, 20)) error(funcName, 18);

        // Test one-element range at the beginning
        if (!ArrayUtilsExtra.anyOf(a1, 0, 1, 10)) error(funcName, 19);
        if ( ArrayUtilsExtra.anyOf(a1, 0, 1, 20)) error(funcName, 20);

        // Test one-element range at the end
        if (!ArrayUtilsExtra.anyOf(a1, 3, 4, 10)) error(funcName, 21);
        if ( ArrayUtilsExtra.anyOf(a1, 3, 4, 20)) error(funcName, 22);

        /////////////////////////////////
        //
        // Test subranges with a2
        //

        // Test full range
        if (!ArrayUtilsExtra.anyOf(a2, 0, 4, 10)) error(funcName, 23);
        if (!ArrayUtilsExtra.anyOf(a2, 0, 4, 20)) error(funcName, 24);

        // Test 1-element range at the beginning
        if ( ArrayUtilsExtra.anyOf(a2, 0, 1, 10)) error(funcName, 25);
        if (!ArrayUtilsExtra.anyOf(a2, 0, 1, 20)) error(funcName, 26);

        // Test 1-element range after different element
        if (!ArrayUtilsExtra.anyOf(a2, 1, 2, 10)) error(funcName, 27);
        if ( ArrayUtilsExtra.anyOf(a2, 1, 2, 20)) error(funcName, 28);

        // Test 2-element range at the beginning
        if (!ArrayUtilsExtra.anyOf(a2, 0, 2, 10)) error(funcName, 29);
        if (!ArrayUtilsExtra.anyOf(a2, 0, 2, 20)) error(funcName, 30);

        /////////////////////////////////
        //
        // Test subranges with a3
        //

        // Test full range
        if (!ArrayUtilsExtra.anyOf(a3, 0, 4, 10)) error(funcName, 31);
        if (!ArrayUtilsExtra.anyOf(a3, 0, 4, 20)) error(funcName, 32);

        // Test 1-element range at the end
        if ( ArrayUtilsExtra.anyOf(a3, 3, 4, 10)) error(funcName, 33);
        if (!ArrayUtilsExtra.anyOf(a3, 3, 4, 20)) error(funcName, 34);

        // Test 1-element range before different element
        if (!ArrayUtilsExtra.anyOf(a3, 2, 3, 10)) error(funcName, 35);
        if ( ArrayUtilsExtra.anyOf(a3, 2, 3, 20)) error(funcName, 36);

        // Test 2-element range at the end
        if (!ArrayUtilsExtra.anyOf(a3, 2, 4, 10)) error(funcName, 37);
        if (!ArrayUtilsExtra.anyOf(a3, 2, 4, 20)) error(funcName, 38);
    }

    private static void testNoneOf(boolean testSubRanges) {

        String funcName = "noneOf";
        System.out.printf("Testing %s with%s subranges\n", funcName, testSubRanges ? "" : "out");

        int[] a1 = { 10, 10, 10, 10 };
        int[] a2 = { 20, 10, 10, 10 };
        int[] a3 = { 10, 10, 10, 20 };

        if ( ArrayUtilsExtra.noneOf(a1, 10)) error(funcName, 1);
        if (!ArrayUtilsExtra.noneOf(a1, 20)) error(funcName, 2);
        if ( ArrayUtilsExtra.noneOf(a2, 10)) error(funcName, 3);
        if ( ArrayUtilsExtra.noneOf(a2, 20)) error(funcName, 4);
        if ( ArrayUtilsExtra.noneOf(a3, 10)) error(funcName, 5);
        if ( ArrayUtilsExtra.noneOf(a3, 20)) error(funcName, 6);

        /////////////////////////////////
        //
        // Test subranges with a1
        //

        // Test full range.
        if ( ArrayUtilsExtra.noneOf(a1, 0, 4, 10)) error(funcName, 7);
        if (!ArrayUtilsExtra.noneOf(a1, 0, 4, 20)) error(funcName, 8);

        // Test without first element
        if ( ArrayUtilsExtra.noneOf(a1, 1, 4, 10)) error(funcName, 9);
        if (!ArrayUtilsExtra.noneOf(a1, 1, 4, 20)) error(funcName, 10);

        // Test without last element
        if ( ArrayUtilsExtra.noneOf(a1, 0, 3, 10)) error(funcName, 11);
        if (!ArrayUtilsExtra.noneOf(a1, 0, 3, 20)) error(funcName, 12);

        // Test empty range at beginning
        if (!ArrayUtilsExtra.noneOf(a1, 0, 0, 10)) error(funcName, 13);
        if (!ArrayUtilsExtra.noneOf(a1, 0, 0, 20)) error(funcName, 14);

        // Test empty range in the middle
        if (!ArrayUtilsExtra.noneOf(a1, 2, 2, 10)) error(funcName, 15);
        if (!ArrayUtilsExtra.noneOf(a1, 2, 2, 20)) error(funcName, 16);

        // Test empty range at the end
        if (!ArrayUtilsExtra.noneOf(a1, 4, 4, 10)) error(funcName, 17);
        if (!ArrayUtilsExtra.noneOf(a1, 4, 4, 20)) error(funcName, 18);

        // Test one-element range at the beginning
        if ( ArrayUtilsExtra.noneOf(a1, 0, 1, 10)) error(funcName, 19);
        if (!ArrayUtilsExtra.noneOf(a1, 0, 1, 20)) error(funcName, 20);

        // Test one-element range at the end
        if ( ArrayUtilsExtra.noneOf(a1, 3, 4, 10)) error(funcName, 21);
        if (!ArrayUtilsExtra.noneOf(a1, 3, 4, 20)) error(funcName, 22);

        /////////////////////////////////
        //
        // Test subranges with a2
        //

        // Test full range
        if ( ArrayUtilsExtra.noneOf(a2, 0, 4, 10)) error(funcName, 23);
        if ( ArrayUtilsExtra.noneOf(a2, 0, 4, 20)) error(funcName, 24);

        // Test 1-element range at the beginning
        if (!ArrayUtilsExtra.noneOf(a2, 0, 1, 10)) error(funcName, 25);
        if ( ArrayUtilsExtra.noneOf(a2, 0, 1, 20)) error(funcName, 26);

        // Test 1-element range after different element
        if ( ArrayUtilsExtra.noneOf(a2, 1, 2, 10)) error(funcName, 27);
        if (!ArrayUtilsExtra.noneOf(a2, 1, 2, 20)) error(funcName, 28);

        // Test 2-element range at the beginning
        if ( ArrayUtilsExtra.noneOf(a2, 0, 2, 10)) error(funcName, 29);
        if ( ArrayUtilsExtra.noneOf(a2, 0, 2, 20)) error(funcName, 30);

        /////////////////////////////////
        //
        // Test subranges with a3
        //

        // Test full range
        if ( ArrayUtilsExtra.noneOf(a3, 0, 4, 10)) error(funcName, 31);
        if ( ArrayUtilsExtra.noneOf(a3, 0, 4, 20)) error(funcName, 32);

        // Test 1-element range at the end
        if (!ArrayUtilsExtra.noneOf(a3, 3, 4, 10)) error(funcName, 33);
        if ( ArrayUtilsExtra.noneOf(a3, 3, 4, 20)) error(funcName, 34);

        // Test 1-element range before different element
        if ( ArrayUtilsExtra.noneOf(a3, 2, 3, 10)) error(funcName, 35);
        if (!ArrayUtilsExtra.noneOf(a3, 2, 3, 20)) error(funcName, 36);

        // Test 2-element range at the end
        if ( ArrayUtilsExtra.noneOf(a3, 2, 4, 10)) error(funcName, 37);
        if ( ArrayUtilsExtra.noneOf(a3, 2, 4, 20)) error(funcName, 38);
    }

    public static void testHugeArrays() {

        System.out.println("Testing huge arrays.");

        int[] a = new int[500000];

        Arrays.fill(a, 42);

        if (!ArrayUtilsExtra.allOf (a, 42)) error("allOf", 1);
        if ( ArrayUtilsExtra.anyOf (a, 24)) error("anyOf", 2);
        if (!ArrayUtilsExtra.noneOf(a, 24)) error("noneOf", 3);

        System.out.println("Huge array tests complete.");
    }

    public static void main(String[] args) {

        if (args.length == 0) {
            System.out.println("usage: java ArrayUtils N");
            System.out.println("    N & 1  -> test allOf");
            System.out.println("    N & 2  -> test anyOf");
            System.out.println("    N & 4  -> test noneOf");
            System.out.println("    N & 8  -> test subranges");
            System.out.println("    N & 16 -> test huge arrays");
            return;
        }

        int command = Integer.parseInt(args[0]);
        boolean testSubRanges = (command & 8) != 0;
        if ((command &  1) != 0) testAllOf(testSubRanges);
        if ((command &  2) != 0) testAnyOf(testSubRanges);
        if ((command &  4) != 0) testNoneOf(testSubRanges);
        if ((command & 16) != 0) testHugeArrays();
    }
}
