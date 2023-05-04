
// Stack defines the abstract interface for the Stack ADT.
//
// A Stack is a LIFO data structure; that is, the last item added
// to the stack (the top item) is the first one removed.  Only the
// top item is accessible.
//
// API:
//		void push(T data)	- add a new item onto the stack
//		T pop()				- remove and return the most recently-added item
//		isEmpty()			- return true if the stack has no elements
//		size()				- return the number of elements on the stack

public interface Stack<T> {
    void push(T data);
    T pop();
    boolean isEmpty();
    int size();
}
