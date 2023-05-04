public class TestArrayStack {

    private static void testStringStack() {

        System.out.println("Testing stack of Strings");

        Stack<String> stk = new ArrayStack<String>(3);
        if (stk.size() != 0)
            System.out.println("New stack has non-zero size.");
        if (!stk.isEmpty())
            System.out.println("New stack is not empty.");

        stk.push("Moe");
        if (stk.size() != 1)
            System.out.println("Pushed one item, size is not 1.");
        if (stk.isEmpty())
            System.out.println("Pushed one item, stack is empty.");

        stk.push("Larry");
        if (stk.size() != 2)
            System.out.println("Pushed two items, size is not 2.");
        if (stk.isEmpty())
            System.out.println("Pushed two items, stack is empty.");

        if (stk.pop() != "Larry")
            System.out.println("pop() did not return last item pushed. (1)");
        if (stk.size() != 1)
            System.out.println("Pushed two, popped one, size is not 1. (1)");
        if (stk.isEmpty())
            System.out.println("Pushed two, popped one, stack is empty. (1)");

        stk.push("Curly");
        if (stk.size() != 2)
            System.out.println("Pushed two items, size is not 2.");
        if (stk.isEmpty())
            System.out.println("Pushed two items, stack is empty.");

        if (stk.pop() != "Curly")
            System.out.println("pop() did not return last item pushed. (2)");
        if (stk.size() != 1)
            System.out.println("Pushed two, popped one, size is not 1. (2)");
        if (stk.isEmpty())
            System.out.println("Pushed two, popped one, stack is empty. (2)");

        if (stk.pop() != "Moe")
            System.out.println("pop() did not return first item pushed.");
        if (stk.size() != 0)
            System.out.println("Popped last item, size is not 0. (2)");
        if (!stk.isEmpty())
            System.out.println("Pushed last item, stack is not empty. (2)");

        stk.push("Shep");

        Stack<String> stk2 = new ArrayStack<>(10);
        if (stk2.size() != 0)
            System.out.println("New stack has non-zero size. (2)");
        if (!stk2.isEmpty())
            System.out.println("New stack is not empty. (2)");

        System.out.println("Done testing stack of Strings");
    }

    private static void testIntegerStack() {

        System.out.println("Testing stack of Integers");

        Stack<Integer> stk = new ArrayStack<Integer>(3);

        if (stk.size() != 0)
            System.out.println("New stack has non-zero size.");
        if (!stk.isEmpty())
            System.out.println("New stack is not empty.");

        stk.push(27);
        if (stk.size() != 1)
            System.out.println("Pushed one item, size is not 1.");
        if (stk.isEmpty())
            System.out.println("Pushed one item, stack is empty.");

        stk.push(82);
        if (stk.size() != 2)
            System.out.println("Pushed two items, size is not 2.");
        if (stk.isEmpty())
            System.out.println("Pushed two items, stack is empty.");

        if (stk.pop() != 82)
            System.out.println("pop() did not return last item pushed. (1)");
        if (stk.size() != 1)
            System.out.println("Pushed two, popped one, size is not 1. (1)");
        if (stk.isEmpty())
            System.out.println("Pushed two, popped one, stack is empty. (1)");

        stk.push(41);
        if (stk.size() != 2)
            System.out.println("Pushed two items, size is not 2.");
        if (stk.isEmpty())
            System.out.println("Pushed two items, stack is empty.");

        if (stk.pop() != 41)
            System.out.println("pop() did not return last item pushed. (2)");
        if (stk.size() != 1)
            System.out.println("Pushed two, popped one, size is not 1. (2)");
        if (stk.isEmpty())
            System.out.println("Pushed two, popped one, stack is empty. (2)");

        if (stk.pop() != 27)
            System.out.println("pop() did not return first item pushed.");
        if (stk.size() != 0)
            System.out.println("Popped last item, size is not 0. (2)");
        if (!stk.isEmpty())
            System.out.println("Pushed last item, stack is not empty. (2)");

        System.out.println("Done testing stack of Integers");
    }

    public static void main(String[] args) {

        int test = args.length == 0 ? 3 : Integer.parseInt(args[0]);

        if ((test & 1) != 0)
            testStringStack();
        if ((test & 2) != 0)
            testIntegerStack();
    }
}
