public class LinkedList<T> {

    private class Node {
        T data;
        Node next;

        Node(T item, Node next){
            this.data = item;
            this.next = next;
        }
    }

    private Node front = null;
    private Node back = null;

    public void addFront(T item) {
        front = new Node(item, front);
        if (back == null)
            back = front;
    }

    public void addBack(T item) {
        Node newNode = new Node(item, null);
        back.next = newNode;
        back = newNode;
        if (front == null)
            front = back;
    }

    public T removeFront() {
        if (front == null)
            throw new RuntimeException("Attempt to remove from an empty list.");
        T item = front.data;
        front = front.next;
        if (front == null)
            back = null;
        return item;
    }

    public int size(){
        return 0;
    }

    public boolean isEmpty(){
        return false;
    }

    // main function
    public static void main(String[] args) {
        LinkedList<String> names = new LinkedList<>();
        names.addFront("Chork");
        names.addFront("Okkk");
        names.addFront("Waaaalllaa");
        names.addFront("KAAkaKkkaa");

        System.out.println(names);
    }
}
