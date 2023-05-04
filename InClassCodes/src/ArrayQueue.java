public class ArrayQueue<T> implements Queue<T> {

    private T[] queue;
    int front = 0;
    int back  = 0;
    int numItem = 0;

    public ArrayQueue(int maxItem) {
        queue = (T[]) new Object[maxItem];
    }

    @Override
    public void add(T item) {
        if (numItem == queue.length)
            throw new RuntimeException("Full queue");
        queue[back++] = item;
        if (back == queue.length)
            back = 0;
        numItem += 1;
    }

    @Override
    public T remove() {
        T item = queue[front++];
        if (front == queue.length)
            front = 0;
        numItem -= 1;
        return item;
    }

    @Override
    public int size() {
        return queue.length;
    }

    @Override
    public boolean isEmpty() {
        return numItem==0;
    }

    // main function
    public static void main(String[] args){
        ArrayQueue<String> sq = new ArrayQueue<String>(4);
        sq.add("CH");
        sq.add("KK");
        sq.add("HH");
        sq.add("YY");

        System.out.println(sq.remove());
    }
}



