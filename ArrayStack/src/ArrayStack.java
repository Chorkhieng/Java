public class ArrayStack<T> implements Stack<T>{

    private T[] stack;
    private int lastAdd = 0;
    private int numItems = 0;

    // ArrayStack constructor
    ArrayStack(int numItems){
        stack = (T[]) new Object[numItems];
    }

    // push item onto the stack
    @Override
    public void push(T item) {
        if (numItems == stack.length)
            throw new RuntimeException("Full stack!");

        stack[lastAdd++] = item;
        if (lastAdd == stack.length)
            lastAdd = 0;
        numItems += 1;
    }

    // pop the lasted added item from the stack
    @Override
    public T pop() {
        if (numItems == stack.length)
            throw new RuntimeException("Empty stack!");
        T item = stack[--lastAdd];
        if (lastAdd == stack.length)
            lastAdd = 0;
        numItems -= 1;
        return item;
    }

    // check the size of the stack
    @Override
    public int size() {
        return numItems;
    }

    // check if the stack is empty
    @Override
    public boolean isEmpty() {
        return numItems == 0;
    }
}
