// don't change this code
// this is for test only

import java.io.FileInputStream;
import java.util.Scanner;

public class TestLastN {

    public static void printArray(String[] sa) {
        for (String s : sa)
            System.out.println(s);
    }

    public static void studentTest() {

        // First test: give 4 strings, keep 3
        {
            LastN ln = new LastN(3);
            ln.keep("one");
            ln.keep("two");
            ln.keep("three");
            ln.keep("four");
            String[] last3 = ln.getLastN();
            printArray(last3);
            System.out.println();
        }

        // second test: give 2 strings, keep 3
        {
            LastN ln = new LastN(3);
            ln.keep("one");
            ln.keep("two");
            String[] last3 = ln.getLastN();
            printArray(last3);
            System.out.println();
        }

        // third test: give 4 strings, keep 1
        {
            LastN ln = new LastN(1);
            ln.keep("one");
            ln.keep("two");
            ln.keep("three");
            ln.keep("four");
            String[] last1 = ln.getLastN();
            printArray(last1);
            System.out.println();
        }

        // fourth test: give 4 strings, keep 2, then give 4 more.
        {
            LastN ln = new LastN(2);
            ln.keep("one");
            ln.keep("two");
            ln.keep("three");
            ln.keep("four");
            String[] last2 = ln.getLastN();
            printArray(last2);
            System.out.println();
            ln.keep("five");
            ln.keep("six");
            last2 = ln.getLastN();
            printArray(last2);
            System.out.println();
        }
    }

    public static void zyBooksTest(String[] args) {

        int n = Integer.parseInt(args[0]);
        LastN ln = new LastN(n);

        Scanner scnr = new Scanner(System.in);
        while (scnr.hasNext()) {
            String s = scnr.next();
            if (s.equals("---")) {
                String[] sa = ln.getLastN();
                printArray(sa);
            } else {
                ln.keep(s);
            }
        }
        scnr.close();
        String[] sa = ln.getLastN();
        printArray(sa);
    }

    public static void zyBooksFileTest(String[] args) {

        int n = Integer.parseInt(args[0]);
        LastN ln = new LastN(n);

        try
        {
            FileInputStream inFile = new FileInputStream(args[1]);
            Scanner scnr = new Scanner(inFile);
            while (scnr.hasNextLine()) {
                String s = scnr.nextLine();
                ln.keep(s);
            }
            scnr.close();
        }
        catch (Exception e)
        {
            System.out.printf("Exception: %s\n", e.getMessage());
        }
        String[] sa = ln.getLastN();
        printArray(sa);
    }

    public static void main(String[] args) {

        if (args.length == 0)
            studentTest();
        else if (args.length == 1)
            zyBooksTest(args);
        else
            zyBooksFileTest(args);
    }
}
