import java.util.Arrays;
import java.util.Scanner;
import java.util.Scanner;
import java.lang.Math;

public class PostfixCalc {

    private static double a, b;

    public static boolean isNumber(String s) {
        try {
            Double.parseDouble(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static void main(String[] args) {

        // Your code goes here
        // Create an appropriate collection to hold operands
        // Loop while there is input
        //    read a string
        //    if it is a number (see isNumber() above)
        //       convert to a number (use Double.parseDouble())
        //       add it to the collection
        //    else
        //       take action appropriate for this operator
        //       operators can be +, -, *, /, sqrt, print



        // modify this code:
        // change LinkedStack to ArrayQueue
        // for both String and Double since they need postfix

        Scanner in = new Scanner(System.in);

        String[] arrayString;

        LinkedStack<Double> operandStack = new LinkedStack<Double>();


        while(in.hasNextLine()) {


            // assign the entire line to arrayString and cut out the whitespace
            arrayString = in.nextLine().split(" ");

            for (String s : arrayString) {


                if (isNumber(s)) {
                    operandStack.push(Double.parseDouble(s));
                } else if (s.equals("+")) {
                    a = operandStack.pop();
                    b = operandStack.pop();
                    operandStack.push(a + b);
                } else if (s.equals("-")) {
                    a = operandStack.pop();
                    b = operandStack.pop();
                    operandStack.push(b - a);
                } else if (s.equals("/")) {
                    a = operandStack.pop();
                    b = operandStack.pop();
                    operandStack.push(b / a);
                } else if (s.equals("*")) {
                    a = operandStack.pop();
                    b = operandStack.pop();
                    operandStack.push(a * b);
                } else if (s.equals("sqrt")) {
                    operandStack.push(Math.sqrt(operandStack.pop()));
                } else if (s.equals("print")) {
                    System.out.println(operandStack.pop());
                }
            }
            // just to make it nice for the output
            // after breaking of for() loop
            System.out.println();
        }
    }

}


