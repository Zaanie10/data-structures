// Name: Zaanie Bowen
// Class: CS3305/W03
// Term: Summer 2025
// Instructor: Prof. Wang
// Assignment: 4
// IDE Name: IntelliJ

import java.util.Scanner;

public class TestQueue {
    public static void main(String[] args) {
        Queue<Integer> queue = new Queue<>();
        Scanner input = new Scanner(System.in);
        int choice;

        do {
            // Display menu for each iteration
            System.out.println("\n\n--------MAIN MENU--------");
            System.out.println("1 – Enqueue element");
            System.out.println("2 – Dequeue element");
            System.out.println("3 – Get front element");
            System.out.println("4 – Get queue size");
            System.out.println("5 – Is Empty queue?");
            System.out.println("6 – Print queue");
            System.out.println("7 – Exit program");
            System.out.print("Enter option number: ");
            choice = input.nextInt();

            // Handle each menu option based on user's input
            switch (choice) {

                // Case 1: Enqueue an element into the queue
                case 1:
                    System.out.print("Enter element to enqueue: ");
                    int val = input.nextInt();       // Read user input
                    queue.enqueue(val);              // Add input value to the queue
                    break;
                // Executed only when the user selects option 1. Accepts any integer input.

                // Case 2: Dequeue an element from the queue
                case 2:
                    Integer removed = queue.dequeue();          // Try removing front element
                    if (removed != null) {                      // Only print if dequeue is successful
                        System.out.println("Dequeued: " + removed);
                    }
                    break;
                // Executes if queue is not empty. Prints error inside dequeue() if it is.

                // Case 3: View the front element without removing it
                case 3:
                    Integer front = queue.front();              // Get front item
                    if (front != null) {
                        System.out.println("Front element: " + front);
                    }
                    break;
                // Executes safely even if queue is empty. Error message handled inside front().

                // Case 4: Display the current size of the queue
                case 4:
                    System.out.println("Queue size: " + queue.size());
                    break;
                // Always valid. Returns number of elements regardless of state.

                // Case 5: Check if the queue is empty
                case 5:
                    System.out.println(queue.isEmpty() ? "Queue is empty." : "Queue is NOT empty.");
                    break;
                // Outputs true/false state of the queue.

                // Case 6: Print all elements in the queue
                case 6:
                    queue.printQueue();      // Displays all queue contents in order
                    break;
                // Always safe to call; internally handles empty queue.

                // Case 7: Exit the loop and terminate the program
                case 7:
                    System.out.println("Exiting program.");
                    break;
                // Ends the loop and closes the program.

                // Default case: Handles invalid input
                default:
                    System.out.println("Invalid option. Try again.");
                    break;
                // Catches typos or unrecognized menu choices
            }

// Loop continues until user selects option 7
        } while (choice != 7);

        input.close();
    }
}
// Interactive test program that uses a menu to test all key operations on the generic Queue class.
