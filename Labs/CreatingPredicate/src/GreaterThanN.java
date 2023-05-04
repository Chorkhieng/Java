// GreaterThanN
//
// Predicate whose test() function indicates whether a given
// integer is larger than the one provided to the constructor.

// Most languages (most notably C and Python) treat functions as "first
// class objects"; that is, we can pass a function to another function
// as an argument.
//
// Java does not support this.  Instead, we need to wrap the function
// in an object, which requires us to define a single-method interface
// whose single method defines that function type.
//
// Here, we're interested in a particular type of function called a
// "predicate"; this is a function that takes a single (usually) parameter
// and returns true or false depending on whether that parameter satisfies
// some criteria.
//
// Java supports this by defining an interface called Predicate, whose
// single method is called test().  To use this, you need to define your
// predicate as a class which implements Predicate<>, then create a
// specific object of that type, and pass that to a function that
// is written to use a predicate.  (See ArrayUtils.find() for an example.)

// I'm not showing it here (I don't want to confuse matters any further
// with yet one more layer of indirection), but Java does have nicer
// ways of doing this, using anonymous classes and lambda expressions.

import java.util.Scanner;
import java.util.function.Predicate;

// This class implements a predicate whose constructor takes a single
// integer n and whose test() method returns whether some given integer
// is greater than that n.
//
// Note that the 'implements' clause can indicate a specific type.
// In this case, we're only working with Integer values, so we can
// make the inherited Predicate behavior work only for Integers.
public class GreaterThanN implements Predicate<Integer> {

    private int n;

    public GreaterThanN(int n) {
        this.n = n;
    }

    @Override
    public boolean test(Integer other) {
        return other > n;
    }

    // This test client is basically the GreaterThan42 program
    // from an earlier lab, but done in an admittedly round-about
    // way by using a predicate.
    public static void main(String[] args) {

        // Create our predicate object.
        GreaterThanN gt42 = new GreaterThanN(42);

        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int n = sc.nextInt();
            if (gt42.test(n)) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
    }
}
