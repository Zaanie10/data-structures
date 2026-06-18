// Name:    Zaanie Bowen
// Class:   CS3305/W03
// Term:    Summer 2025
// Instructor:   Prof. Wang
// Assignment:   #3
// IDE Name:   IntelliJ IDEA

// A generic stack class implemented using a singly linked list.
// Provides standard stack operations: push, pop, top, size, isEmpty.
public class MyStack<E> {

    // Node class represents each element in the stack.
    private class Node {
        E data;
        Node next;

        // Constructor for Node
        public Node(E data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node top; // Reference to the top node of the stack
    private int size; // Number of elements in the stack

    // Constructs an empty stack
    public MyStack() {
        top = null;
        size = 0;
    }

    // Pushes a new element onto the stack
    public void push(E element) {
        Node newNode = new Node(element);
        newNode.next = top;
        top = newNode;
        size++;
    }

    // Removes and returns the top element of the stack
    // Throws RuntimeException if the stack is empty
    public E pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty. Cannot pop.");
        }
        E removed = top.data;
        top = top.next;
        size--;
        return removed;
    }

    // Returns the top element without removing it
    // Throws RuntimeException if the stack is empty
    public E top() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty. No top element.");
        }
        return top.data;
    }

    // Checks if the stack is empty
    // Returns true if the stack has no elements, false otherwise
    public boolean isEmpty() {
        return top == null;
    }

    // Returns the number of elements in the stack
    public int size() {
        return size;
    }

    // Returns a string representation of the stack from top to bottom
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node current = top;
        sb.append("[Top] ");
        while (current != null) {
            sb.append(current.data);
            if (current.next != null) sb.append(" -> ");
            current = current.next;
        }
        sb.append(" [Bottom]");
        return sb.toString();
    }
}
