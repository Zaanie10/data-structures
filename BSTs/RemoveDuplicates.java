// Name: Zaanie Bowen
// Class: CS3305/W03 
// Term: Summer 2025
// Instructor: Prof. Wang 
// Assignment: 6
// IDE Name: Visual Studio Code

import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer; // Used for splitting the input string into words

public class RemoveDuplicates {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        BST<String> wordTree = new BST<>(); // BST to store unique words (strings)
        String originalText = ""; // To store the original input text

        int option; // Stores user's menu selection

        // Main loop: displays menu until user selects Exit (option 3)
        do {
            System.out.println("----------------MAIN MENU---------------");
            System.out.println("1. Read input string");
            System.out.println("2. Remove duplicates and display outputs");
            System.out.println("3. Exit program");
            System.out.println();
            System.out.print("Enter option number: ");
            System.out.println();

            // Parse the user input into an integer menu option
            option = Integer.parseInt(input.nextLine().trim());

            // Process user's menu selection
            switch (option) {
                // 1: Read input string from the keyboard
                case 1:
                    System.out.print("Original Text: ");
                    originalText = input.nextLine().trim(); // Read the entire line

                    // Clear the tree for new input if it's not empty
                    if (wordTree.getSize() > 0) {
                        wordTree.clear();
                    }

                    // Use StringTokenizer to break the input string into words
                    // Space is the delimiter. Convert words to lowercase for consistent sorting and duplicate removal.
                    StringTokenizer tokenizer = new StringTokenizer(originalText.toLowerCase(), " ");
                    while (tokenizer.hasMoreTokens()) {
                        wordTree.insert(tokenizer.nextToken()); // Insert word into BST (duplicates are not added)
                    }
                    System.out.println(); // Add a newline for better readability
                    break;

                // 2: Remove duplicates (already handled by BST) and display outputs
                case 2:
                    System.out.println("Processed Text: ");
                    // Check if the tree is empty before attempting to traverse
                    if (wordTree.isEmpty()) {
                        System.out.println("No text has been entered yet. Please use option 1 to enter text.\n");
                    } else {
                        // Get the inorder traversal list from the BST
                        // Inorder traversal prints elements in sorted order and BST naturally handles duplicates.
                        List<BST.TreeNode<String>> processedWords = wordTree.inorder();
                        for (int i = 0; i < processedWords.size(); i++) {
                            System.out.print(processedWords.get(i).element + " ");
                        }
                        System.out.println("\n"); // Add newlines for formatting
                    }
                    break;

                // 3: Exit the program
                case 3:
                    System.out.println("Exiting program.");
                    break;

                // Catch any invalid menu choices
                default:
                    System.out.println("Invalid option. Please enter 1–3.\n");
            }

        } while (option != 3); // Sentinel loop condition

        input.close(); // Close scanner to free resources
    }
}
