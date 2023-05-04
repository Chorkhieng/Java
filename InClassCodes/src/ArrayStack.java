public class ArrayStack<S> implements Stack<S> {

    private S[] stack;
    int first;
    int last;
    int numOfElement;

    ArrayStack (int numOfElement){
        stack = (S[]) new Object[numOfElement];
    }

    @Override
    public void push(S element) {
        if (numOfElement == stack.length)
            throw new RuntimeException("Full queue");
        stack[last++] = element;
        if (last == stack.length)
            last = 0;
        numOfElement += 1;
    }

    @Override
    public S pop() {
        S element = stack[first++];
        if (first == stack.length)
            first = 0;
        numOfElement -= 1;
        return element;
    }

    @Override
    public int size() {
        return stack.length;
    }

    @Override
    public boolean isEmpty() {
        return stack.length==0;
    }

    // main function
    public static void main(String[] args){
        ArrayStack<String> st = new ArrayStack<String>(4);
        st.push("CH");
        st.push("KK");
        st.push("HH");
        st.push("YY");

        System.out.println(st.pop());
        System.out.println(st.pop());
    }
}
