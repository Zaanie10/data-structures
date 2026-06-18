// Name: Zaanie Bowen
// Class: CS3305/w03
// Term: Spring 2025
// Instructor: Prof. Wang
// Assignment: #1
// IDE: IntelliJ

import java.util.Scanner;

public class vowels {
    static String userInput = "";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int option;

        do {
            // Display menu
            System.out.println("\n-----MAIN MENU-----");
            System.out.println("1. Read input string");
            System.out.println("2. Compute number of vowels");
            System.out.println("3. Exit program");
            System.out.print("Enter option number: ");
            option = scanner.nextInt();
            scanner.nextLine(); // Consume leftover newline

            switch (option) {
                case 1:
                    System.out.print("Enter a string: ");
                    userInput = scanner.nextLine();
                    break;
                case 2:
                    if (userInput.isEmpty()) {
                        System.out.println("No input string found. Please enter a string first.");
                    } else {
                        int count = countVowels(userInput.toLowerCase());
                        System.out.println("\nYou entered string: " + userInput);
                        System.out.println("Number of vowels: " + count);
                    }
                    break;
                case 3:
                    System.out.println("Exiting program.");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }

        } while (option != 3);
    }

    // Recursive method to count vowels
    public static int countVowels(String input) {
        if (input.isEmpty()) {
            return 0;
        }

        char firstChar = input.charAt(0);
        int count = (firstChar == 'a' || firstChar == 'e' || firstChar == 'i' ||
                firstChar == 'o' || firstChar == 'u') ? 1 : 0;

        return count + countVowels(input.substring(1));
    }
}
