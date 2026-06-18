import java.util.Scanner;

public class CheckPalindrome {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MyStack<Character> charStack = new MyStack<>();
        String inputString = "";
        int option;

        // Main menu loop
        do {
            // Display menu
            System.out.println("\n\n-----------------MAIN MENU----------------");
            System.out.println("1 – Read input string");
            System.out.println("2 – Check palindrome and display output");
            System.out.println("3 - Exit program");
            System.out.print("\nEnter option number: ");
            option = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (option) {
                case 1:
                    // Read and sanitize the input string
                    System.out.print("\nEnter a string: ");
                    inputString = scanner.nextLine().trim();
                    System.out.println("Input saved.");
                    break;

                case 2:
                    if (inputString.isEmpty()) {
                        System.out.println("\nNo string entered yet. Please use option 1 first.");
                    } else {
                        // Clean the string: remove spaces and convert to lowercase
                        String cleaned = inputString.replaceAll("\\s+", "").toLowerCase();

                        // Push characters onto the stack
                        charStack = new MyStack<>();
                        for (char ch : cleaned.toCharArray()) {
                            charStack.push(ch);
                        }

                        // Pop characters to build reversed string
                        StringBuilder reversed = new StringBuilder();
                        while (!charStack.isEmpty()) {
                            reversed.append(charStack.pop());
                        }

                        // Display results
                        System.out.println("\nEntered String:   " + inputString);
                        if (cleaned.equals(reversed.toString())) {
                            System.out.println("Judgment:         Palindrome");
                        } else {
                            System.out.println("Judgment:         Not Palindrome");
                        }
                    }
                    break;

                case 3:
                    System.out.println("\nExiting program. Goodbye!");
                    break;

                default:
                    System.out.println("\nInvalid option. Please choose a number from 1 to 3.");
                    break;
            }
        } while (option != 3);

        scanner.close();
    }
}
