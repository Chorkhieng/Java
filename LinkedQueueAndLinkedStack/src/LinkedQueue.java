// implement LinkedQueue class

public class LinkedQueue<T> implements Queue<T> {

    LinkedList<T> queue = new LinkedList<>();

    // add item to the queue
    @Override
    public void enqueue(T item) {;
        queue.addBack(item);
    }

    // remove element to the queue
    @Override
    public T dequeue() {
        return queue.removeFront();
    }

    // check the size of the queue
    @Override
    public int size() {
        return queue.size();
    }

    // check if the queue is empty
    @Override
    public boolean isEmpty() {
        return queue.isEmpty();
    }
}
