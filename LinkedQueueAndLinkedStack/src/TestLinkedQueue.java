public class TestLinkedQueue {

    public static void main(String[] args) {

        LinkedQueue<Integer> qInt1 = new LinkedQueue<>();
        if (qInt1.size() != 0)
            System.out.println("New queue, size != 0");
        if (!qInt1.isEmpty())
            System.out.println("New queue, not empty");

        qInt1.enqueue(27);
        if (qInt1.size() != 1)
            System.out.println("Added 1 item, size != 1");
        if (qInt1.isEmpty())
            System.out.println("Added 1 item, still empty");

        int i = qInt1.dequeue();
        if (i != 27)
            System.out.println("dequeue returned incorrect value (not 27)");
        if (qInt1.size() != 0)
            System.out.println("Removed only item, size != 0");
        if (!qInt1.isEmpty())
            System.out.println("Removed only item, not empty");

        qInt1.enqueue(82);
        qInt1.enqueue(41);
        if (qInt1.size() != 2)
            System.out.println("Added 2 items, size != 2");
        if (qInt1.isEmpty())
            System.out.println("Added 2 items, still empty");

        i = qInt1.dequeue();
        if (i != 82)
            System.out.println("dequeue returned incorrect value (not 82)");
        i = qInt1.dequeue();
        if (i != 41)
            System.out.println("dequeue returned incorrect value (not 41)");
        if (qInt1.size() != 0)
            System.out.println("Removed two items, size != 0");
        if (!qInt1.isEmpty())
            System.out.println("Removed two items, not empty");

        qInt1.enqueue(124);
        qInt1.enqueue(62);
        i = qInt1.dequeue();
        if (i != 124)
            System.out.println("dequeue returned incorrect value (not 124)");
        qInt1.enqueue(31);
        i = qInt1.dequeue();
        if (i != 62)
            System.out.println("dequeue returned incorrect value (not 62)");
        i = qInt1.dequeue();
        if (i != 31)
            System.out.println("dequeue returned incorrect value (not 31)");
        if (qInt1.size() != 0)
            System.out.println("At end, size != 0");
        if (!qInt1.isEmpty())
            System.out.println("At end items, not empty");

        System.out.println("All tests complete.");
    }
}
