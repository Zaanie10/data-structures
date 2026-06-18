// Name: Zaanie Bowen
// Class: CS3305/W03
// Term: Summer 2025
// Instructor: Prof. Wang
// Assignment: 4
// IDE Name: IntelliJ

public class Queue<E> {
    private Node<E> front; // Points to the front (head) of the queue
    private Node<E> rear;  // Points to the rear (tail) of the queue
    private int size;      // Tracks the number of elements in the queue

    // Inner Node class to store data and next pointer
    private static class Node<E> {
        E data;
        Node<E> next;

        Node(E data) {
            this.data = data;
            this.next = null;
        }
        // Creates a new node with given data and null next pointer
    }

    public Queue() {
        front = rear = null;
        size = 0;
    }
    // Initializes an empty queue with null front and rear pointers and size 0

    public void enqueue(E e) {
        Node<E> newNode = new Node<>(e); // Create new node with data
        if (rear == null) {
            front = rear = newNode; // If queue is empty, both front and rear point to new node
        } else {
            rear.next = newNode;    // Link current rear to new node
            rear = newNode;         // Update rear to point to new node
        }
        size++;
    }
    // Adds an element to the end of the queue

    public E dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Cannot dequeue.");
            return null;
        }
        E data = front.data;
        front = front.next;
        if (front == null) rear = null; // If queue becomes empty after dequeue
        size--;
        return data;
    }
    // Removes and returns front element. Updates pointers and size.

    public E front() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Nothing at front.");
            return null;
        }
        return front.data;
    }
    // Returns front element without removing it

    public int size() {
        return size;
    }
    // Returns number of elements in queue

    public boolean isEmpty() {
        return front == null;
    }
    // Returns true if the queue has no elements

    public void printQueue() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return;
        }
        Node<E> current = front;
        System.out.print("Queue: ");
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
    // Prints all elements in the queue from front to rear
}
