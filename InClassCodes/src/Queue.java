public interface Queue<T> {

    void add(T item);
    T remove();
    int size();
    boolean isEmpty();
}
