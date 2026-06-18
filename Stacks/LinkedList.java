// Name: Zaanie Bowen
// Class: CS3305/W03
// Term: Summer 2025
// Instructor: Prof. Wang
// Assignment: #2 - Used for #3
// IDE Name: IntelliJ IDEA

/*
This class define a linked list that stores integer values.
*/

public class LinkedList
{
    public Node head, tail;

    //constructor method to create a list of object with head, tail, and size.
    public LinkedList()
    {
        head = null;
        tail = null;
    }

    //method add node to end of list
    public void addLastNode(int data)
    {
        if (tail == null)
            head = tail = new Node(data); //empty list
        else
        {
            tail.next = new Node(data); //link new node as last node
            tail = tail.next; //make tail pointer points to last node
        }
    }

    //======== Your part to complete for this assignment =========

    //method #1: add first node
    // Adds a new node with the given data at the beginning of the list
    public void addFirstNode(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
    }

    //method #2: add node at index
    // Inserts a new node with the given data at the specified index
    public void addAtIndex(int index, int data) {
        if (index < 0 || index > countNodes()) {
            System.out.println("Invalid index, try again.");
            return;
        }

        if (index == 0) {
            addFirstNode(data);
        } else if (index == countNodes()) {
            addLastNode(data);
        } else {
            Node newNode = new Node(data);
            Node current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
        }
    }

    //method #3: remove first node
    // Removes the first node in the list
    public void removeFirstNode() {
        if (head == null) {
            System.out.println("List is Empty");
            return;
        }

        head = head.next;
        if (head == null) {
            tail = null;
        }
    }

    //method #4: remove last node
    // Removes the last node in the list
    public void removeLastNode() {
        if (head == null) {
            System.out.println("List is Empty");
            return;
        }

        if (head == tail) {
            head = tail = null;
        } else {
            Node current = head;
            while (current.next != tail) {
                current = current.next;
            }
            current.next = null;
            tail = current;
        }
    }

    //method #5: remove node at index
    // Removes the node at the specified index
    public void removeAtIndex(int index) {
        if (head == null) {
            System.out.println("List is Empty");
            return;
        }

        if (index < 0 || index >= countNodes()) {
            System.out.println("Invalid index, try again.");
            return;
        }

        if (index == 0) {
            removeFirstNode();
        } else {
            Node current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            current.next = current.next.next;
            if (current.next == null) {
                tail = current;
            }
        }
    }

    //method #6: countNodes
    // Returns the number of nodes in the list
    public int countNodes() {
        int count = 0;
        Node current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    //method #7: printInReverse  (Recursive method)
    // Initiates recursive printing of the list in reverse
    public void printInReverse() {
        printInReverseRecursive(head);
    }

    // Helper method to recursively print list in reverse
    private void printInReverseRecursive(Node node) {
        if (node == null) return;
        printInReverseRecursive(node.next);
        System.out.print(node.data + "   ");
    }

//================= end of your part ==============


    //method to print out the list
    public void printList()
    {
        Node temp;
        temp = head;
        while (temp != null)
        {
            System.out.print(temp.data + "   ");
            temp = temp.next;
        }
    }

    //class to create nodes as objects
    private class Node
    {
        private int data;  //data field
        private Node next; //link field

        public Node(int item) //constructor method
        {
            data = item;
            next = null;
        }
    }
}
