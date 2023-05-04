import java.util.function.Predicate;

public class TestArrayUtils {

    private static void testValues() {

        Integer[] iaDiff = { 62, 63, 30, 63, 29, 9, 57, 72, 33, 87 };
        Integer[] iaSame = { 42, 42, 42 };

        if (!ArrayUtilsExtra.anyOf(iaDiff, 62)) System.out.println("Test V1 failed");
        if (!ArrayUtilsExtra.anyOf(iaDiff, 87)) System.out.println("Test V2 failed");
        if ( ArrayUtilsExtra.anyOf(iaDiff, 42)) System.out.println("Test V3 failed");

        if (!ArrayUtilsExtra.allOf(iaSame, 42)) System.out.println("Test V4 failed");
        if ( ArrayUtilsExtra.allOf(iaSame, 24)) System.out.println("Test V5 failed");
        if ( ArrayUtilsExtra.allOf(iaDiff, 30)) System.out.println("Test V6 failed");

        String[] saDiff = { "SixtyTwo", "Thirty", "TwentyNine", "FiftySeven", "ThirtyThree" };
        String[] saSame = { "FortyTwo", "FortyTwo", "FortyTwo" };

        if (!ArrayUtilsExtra.anyOf(saDiff, "SixtyTwo"))    System.out.println("Test V7 failed");
        if (!ArrayUtilsExtra.anyOf(saDiff, "ThirtyThree")) System.out.println("Test V8 failed");
        if ( ArrayUtilsExtra.anyOf(saDiff, "FortyTwo"))    System.out.println("Test V9 failed");

        if (!ArrayUtilsExtra.allOf(saSame, "FortyTwo"))   System.out.println("Test V10 failed");
        if ( ArrayUtilsExtra.allOf(saSame, "TwentyFour")) System.out.println("Test V11 failed");
        if ( ArrayUtilsExtra.allOf(saDiff, "Thirty"))     System.out.println("Test V12 failed");

        // If these are the only tests that fails, you made a really common mistake!
        if (!ArrayUtilsExtra.anyOf(saDiff, StringUtils.concat("Sixty", "Two"))) System.out.println("Test V13 failed");
        if (!ArrayUtilsExtra.allOf(saSame, StringUtils.concat("Forty", "Two"))) System.out.println("Test V14 failed");
    }

    public static void main(String[] args) {

        testValues();
    }
}
