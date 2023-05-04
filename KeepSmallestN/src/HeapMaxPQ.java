
import java.util.NoSuchElementException;

public class HeapMaxPQ<Key extends Comparable<Key>> implements MaxPQ<Key> {

    int numItems;
    Key[] pq;

    @SuppressWarnings("unchecked")
    HeapMaxPQ(int initialSize) {

        numItems = 0;
        pq = (Key[]) new Comparable[initialSize];
    }

    @SuppressWarnings("unchecked")
    private void resize(int newSize) {

        Key[] newPQ = (Key[]) new Comparable[newSize];
        ArrayUtils.copy(pq, newPQ, 0, numItems);
        pq = newPQ;
    }

    @Override
    public void insert(Key k) {

        // Check to see if we need to resize the array.
        if (numItems == pq.length) {
            resize(pq.length * 2);
        }

        // Add the new item.
        pq[numItems++] = k;
        HeapUtils.swimMax(pq, numItems-1);
    }

    @Override
    public Key max() {

        // Make sure we actually have something.
        if (numItems == 0)
            throw new NoSuchElementException();

        return pq[0];
    }

    @Override
    public Key delMax() {

        // Make sure we actually have something.
        if (numItems == 0)
            throw new NoSuchElementException();

        Key m = pq[0];
        pq[0] = pq[--numItems];
        pq[numItems] = null;	// avoid loitering
        HeapUtils.sinkMax(pq, numItems, 0);

        // See if we can reduce the size of the queue.
        if (pq.length >= 4 && numItems < pq.length / 4) {
            resize(pq.length / 2);
        }

        return m;
    }

    @Override
    public boolean isEmpty() {
        return numItems == 0;
    }

    @Override
    public int size() {
        return numItems;
    }
}
