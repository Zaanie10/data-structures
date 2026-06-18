import java.util.Scanner;

public class ReverseString {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MyStack<String> wordStack = new MyStack<>();
        String inputSentence = "";
        int option;

        // Main menu loop
        do {
            // Display menu
            System.out.println("\n\n-----------------MAIN MENU---------------");
            System.out.println("1 – Read input string of words");
            System.out.println("2 – Reverse string and display outputs");
            System.out.println("3 - Exit program");
            System.out.print("\nEnter option number: ");
            option = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (option) {
                case 1:
                    // Read input sentence and push words onto the stack
                    System.out.print("\nEnter a sentence: ");
                    inputSentence = scanner.nextLine();

                    // Clear the stack in case of re-entry
                    wordStack = new MyStack<>();

                    // Split words and push onto the stack
                    String[] words = inputSentence.split("\\s+");
                    for (String word : words) {
                        wordStack.push(word);
                    }
                    System.out.println("Input saved.\n");
                    break;

                case 2:
                    // Display original and reversed sentence
                    if (inputSentence.isEmpty()) {
                        System.out.println("\nNo sentence entered yet. Please use option 1 first.");
                    } else {
                        System.out.println("\nEntered string:   " + inputSentence);
                        System.out.print("Reversed String:  ");
                        while (!wordStack.isEmpty()) {
                            System.out.print(wordStack.pop() + " ");
                        }
                        System.out.println(); // New line after reversed output
                    }
                    break;

                case 3:
                    // Exit program
                    System.out.println("\nExiting program. Goodbye!");
                    break;

                default:
                    // Handle invalid input
                    System.out.println("\nInvalid option. Please choose a number from 1 to 3.");
                    break;
            }
        } while (option != 3);

        scanner.close();
    }
}
