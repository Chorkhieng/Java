
public interface Queue<T> extends Iterable<T> {
    void add(T item);
    T remove();
    boolean isEmpty();
    int size();
}
