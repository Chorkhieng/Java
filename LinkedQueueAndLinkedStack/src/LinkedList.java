public class LinkedList<T> {

    // Invariant:
    // front == null and back == null and size == 0
    //      or
    // front != and back != null and size != 0
    private class Node {
        T data;
        Node next;

        Node(T data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    Node front = null;
    Node back = null;
    int nItems = 0;

    public void addFront(T item) {
        front = new Node(item, front);
        // If we're adding to an empty list, we need to have
        // back reference this new one-and-only Node.
        if (back == null)
            back = front;
        nItems++;
    }

    public void addBack(T item) {
        Node newNode = new Node(item, null);
        // Guard against an empty list.
        if (back != null)
            back.next = newNode;
        back = newNode;
        // If the list was empty, we need to make front reference
        // the new one-and-only Node.
        if (front == null)
            front = newNode;
        nItems++;
    }

    // Precondition: the list must not be empty
    public T removeFront() {
        assert front != null;
        T item = front.data;
        front = front.next;
        // If the list became empty, make sure the
        // back reference knows it.
        if (front == null)
            back = null;
        --nItems;
        return item;
    }

    public int size() {
        return nItems;
    }

    public boolean isEmpty() {
        return front == null;
    }

    private static boolean checkEA() {
        try {
            assert false;
            return false;
        } catch (AssertionError e) {
            return true;
        }
    }

    public static void main(String[] args) {

        if (!checkEA()) {
            System.out.println("This program needs to be run with the -ea option");
            return;
        }

        LinkedList<Integer> ll = new LinkedList<>();
        assert ll.size() == 0;
        assert ll.isEmpty();

        ll.addFront(27);
        assert ll.size() == 1;
        assert !ll.isEmpty();

        int i = ll.removeFront();
        assert i == 27;
        assert ll.size() == 0;
        assert ll.isEmpty();

        ll.addBack(82);
        assert ll.size() == 1;
        assert !ll.isEmpty();

        i = ll.removeFront();
        assert i == 82;
        assert ll.size() == 0;
        assert ll.isEmpty();

        ll.addFront(41);
        ll.addFront(124);
        assert ll.size() == 2;
        assert !ll.isEmpty();

        i = ll.removeFront();
        assert i == 124;
        assert ll.size() == 1;
        assert !ll.isEmpty();

        i = ll.removeFront();
        assert i == 41;
        assert ll.size() == 0;
        assert ll.isEmpty();

        ll.addBack(62);
        ll.addBack(31);
        assert ll.size() == 2;
        assert !ll.isEmpty();

        i = ll.removeFront();
        assert i == 62;
        assert ll.size() == 1;
        assert !ll.isEmpty();

        i = ll.removeFront();
        assert i == 31;
        assert ll.size() == 0;
        assert ll.isEmpty();

        ll.addFront(94);
        ll.addBack(47);
        assert ll.size() == 2;
        assert !ll.isEmpty();

        i = ll.removeFront();
        assert i == 94;
        assert ll.size() == 1;
        assert !ll.isEmpty();

        i = ll.removeFront();
        assert i == 47;
        assert ll.size() == 0;
        assert ll.isEmpty();

        ll.addBack(142);
        ll.addFront(71);
        assert ll.size() == 2;
        assert !ll.isEmpty();

        i = ll.removeFront();
        assert i == 71;
        assert ll.size() == 1;
        assert !ll.isEmpty();

        i = ll.removeFront();
        assert i == 142;
        assert ll.size() == 0;
        assert ll.isEmpty();
    }
}
