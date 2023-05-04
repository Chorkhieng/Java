
// LinkedStack - linked-list implementation of a stack.

public class LinkedStack<T> implements Stack<T> {

    // The LinkedList object does all the real work.  The
    // LinkedList class was actually designed for the
    // main purpose of implementing the Stack and Queue
    // interfaces.
    // See the Stack interface for a description of the
    // API functions.
    private LinkedList<T> stack;

    @Override
    public void push(T data) {
        stack.addFront(data);
    }

    @Override
    public T pop() {
        return stack.removeFront();
    }

    @Override
    public boolean isEmpty() {
        return stack.isEmpty();
    }

    @Override
    public int size() {
        return stack.size();
    }

    public static void main(String[] args) {

        Stack<Integer> intStack = new LinkedStack<Integer>();
        assert intStack.isEmpty();
        assert intStack.size() == 0;

        intStack.push(42);
        assert !intStack.isEmpty();
        assert intStack.size() == 1;
        assert intStack.pop() == 42;
        assert intStack.isEmpty();
        assert intStack.size() == 0;
    }
}
