import java.util.Scanner;

public class TestMyStack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MyStack<Integer> stack = new MyStack<>();
        int option;

        // Main loop for the menu
        do {
            // Display menu
            System.out.println("\n\n--------MAIN MENU-------");
            System.out.println("1 – Push element");
            System.out.println("2 – Pop element");
            System.out.println("3 – Get top element");
            System.out.println("4 – Get stack size");
            System.out.println("5 – Is empty stack?");
            System.out.println("6 – Print stack");
            System.out.println("7 – Exit program");
            System.out.print("\nEnter option number: ");
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    // Push an element to the stack
                    System.out.println("\nBefore push: " + stack.toString());
                    System.out.print("Enter integer to push: ");
                    int toPush = scanner.nextInt();
                    stack.push(toPush);
                    System.out.println("After push: " + stack.toString());
                    break;

                case 2:
                    // Pop the top element from the stack
                    System.out.println("\nBefore pop: " + stack.toString());
                    if (!stack.isEmpty()) {
                        int popped = stack.pop();
                        System.out.println("Popped element: " + popped);
                    } else {
                        System.out.println("Stack is empty. Nothing to pop.");
                    }
                    System.out.println("After pop: " + stack.toString());
                    break;

                case 3:
                    // Show the top element
                    System.out.println("\nBefore top: " + stack.toString());
                    if (!stack.isEmpty()) {
                        System.out.println("Top element: " + stack.top());
                    } else {
                        System.out.println("Stack is empty. No top element.");
                    }
                    System.out.println("After top: " + stack.toString());
                    break;

                case 4:
                    // Show the current size of the stack
                    System.out.println("\nBefore size check: " + stack.toString());
                    System.out.println("Stack size: " + stack.size());
                    break;

                case 5:
                    // Check if the stack is empty
                    System.out.println("\nBefore empty check: " + stack.toString());
                    if (stack.isEmpty()) {
                        System.out.println("The stack is empty.");
                    } else {
                        System.out.println("The stack is NOT empty.");
                    }
                    break;

                case 6:
                    // Print the full stack
                    System.out.println("\nCurrent stack: " + stack.toString());
                    break;

                case 7:
                    // Exit the program
                    System.out.println("\nExiting program. Goodbye!");
                    break;

                default:
                    // Handle invalid input
                    System.out.println("\nInvalid option. Please choose a number from 1 to 7.");
                    break;
            }
        } while (option != 7);

        scanner.close();
    }
}
