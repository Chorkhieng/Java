
// Implementation of the Queue interface using a fixed-length array.

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayQueue<T> implements Queue<T> {

    private T[] queue;
    int head = 0;
    int tail = 0;
    int numItems = 0;

    @SuppressWarnings("unchecked")
    public ArrayQueue(int maxSize) {
        queue = (T[])new Object[maxSize];
    }

    @Override
    public void add(T item) {
        if (numItems == queue.length)
            throw new IllegalStateException();
        queue[tail++] = item;
        if (tail == queue.length)
            tail = 0;
        numItems++;
    }

    @Override
    public T remove() {
        if (numItems == 0)
            throw new NoSuchElementException();
        T item = queue[head++];
        if (head == queue.length)
            head = 0;
        --numItems;
        return item;
    }

    @Override
    public boolean isEmpty() {
        return numItems == 0;
    }

    @Override
    public int size() {
        return numItems;
    }

    private class QueueIterator implements Iterator<T> {

        int next = head;
        int numLeft = numItems;

        @Override
        public boolean hasNext() {
            return numLeft != 0;
        }

        @Override
        public T next() {
            T item = queue[next++];
            if (next == queue.length)
                next = 0;
            --numLeft;
            return item;
        }

    }
    @Override
    public Iterator<T> iterator() {
        return new QueueIterator();
    }
}
