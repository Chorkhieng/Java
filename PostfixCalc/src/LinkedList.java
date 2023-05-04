
import java.util.NoSuchElementException;

// LinkedList - a basic generic linked list class
//
// API:
//		void addFront(T data)	- add an item to the front of the list
//		void addBack(T data)	- add an item to the back of the list
//		T removeFront()			- remove and return the front item
//		boolean isEmpty()		- return true if the list is empty
//		int size()				- return the number of items in the list
//
// All operations are O(1).
//
// There is no removeBack() function because it cannot be implemented in
// O(1) time without the unnecessary complexity of a double-linked list.
//
// This class was designed mainly to be used to implement simple
// Stack and Queue ADTs.  With relatively few changes it could be
// used for (inefficient) symbol tables and other sorts of ADTs.

public class LinkedList<T> {

    // Each item is stored in a node, which stores the
    // data and a reference to the next node in the list.
    private class Node {
        T data;
        Node next;

        Node(T data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    // Each list maintains a reference to the first and last
    // nodes in the list, and a count of the number of elements
    // currently in the list.
    // The class invariant is that
    //		(front == null and back == null and numItems == 0)
    //					or
    //		(front != null and back != null and numItems != 0)
    // Also
    // 		numItems = # calls to addFront + # calls to addBack
    //				 - # calls to removeFront

    private Node front = null;
    private Node back = null;
    private int numItems = 0;

    // Add an item to the front of the list.
    void addFront(T data) {
        front = new Node(data, front);

        // If the list was empty, this is also a new
        // back-most node.
        if (back == null)
            back = front;

        numItems++;
    }

    // Add an item to the back of the list.
    void addBack(T data) {

        // Adding to the back of an empty list is the
        // same as adding to the front.
        if (back == null) {
            addFront(data);
        } else {
            Node newNode = new Node(data, null);
            back.next = newNode;
            back = newNode;
            numItems++;
        }
    }

    // Remove the front-most item and return it.
    T removeFront() {

        // We need to have an item to remove.
        if (front == null)
            throw new NoSuchElementException("removeFront called for an empty list");
        T data = front.data;
        front = front.next;

        // If the list is now empty, it means we removed
        // the only node, which was also the back node.
        if (front == null)
            back = null;

        --numItems;
        return data;
    }

    // Check to see if the list is empty.
    boolean isEmpty() {
        return front == null;
    }

    // Get the number of items in the list.
    int size() {
        return numItems;
    }

    public static void main(String[] args) {

        LinkedList<String> stringList = new LinkedList<String>();
        assert stringList.isEmpty();
        assert stringList.size() == 0;

        stringList.addFront("dopey");
        assert !stringList.isEmpty();
        assert stringList.size() == 1;
        assert stringList.removeFront().equals("dopey");
        assert stringList.isEmpty();
        assert stringList.size() == 0;

        stringList.addBack("grumpy");
        assert !stringList.isEmpty();
        assert stringList.size() == 1;
        assert stringList.removeFront().equals("grumpy");
        assert stringList.isEmpty();
        assert stringList.size() == 0;

        stringList.addBack("grumpy");
        assert !stringList.isEmpty();
        assert stringList.size() == 1;
        assert stringList.removeFront().equals("grumpy");
        assert stringList.isEmpty();
        assert stringList.size() == 0;

        stringList.addFront("sleepy");
        stringList.addFront("sneezy");
        assert stringList.removeFront().equals("sneezy");
        assert stringList.removeFront().equals("sleepy");

        stringList.addFront("bashful");
        stringList.addFront("happy");
        assert stringList.removeFront().equals("happy");
        stringList.addFront("doc");
        assert stringList.removeFront().equals("doc");
        assert stringList.removeFront().equals("bashful");
        assert stringList.isEmpty();
        assert stringList.size() == 0;
    }
}
