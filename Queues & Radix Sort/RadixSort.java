// Name: Zaanie Bowen
// Class: CS3305/W03
// Term: Summer 2025
// Instructor: Prof. Wang
// Assignment: 4
// IDE Name: IntelliJ

import java.util.Scanner;

public class RadixSort {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] inputs = new int[0];  // Integer array to hold input numbers
        int size = 0;
        int choice;

        // Start interactive loop for Radix Sort program
        do {
            // Display the main menu
            System.out.println("\n\n---------------MAIN MENU---------------");
            System.out.println("1 – Read array size");
            System.out.println("2 – Read array values");
            System.out.println("3 – Run Radix Sort and print outputs");
            System.out.println("4 – Exit program");
            System.out.print("Enter option number: ");
            choice = input.nextInt();  // Get user's menu selection

            // Handle the selected menu option
            switch (choice) {

                // Case 1: Read array size from user
                case 1:
                    System.out.print("Enter array size: ");
                    size = input.nextInt();         // Read size
                    inputs = new int[size];         // Initialize array with that size
                    break;
                // Executes only once per session unless user wants to reset size
                // Necessary before entering values (Option 2)

                // Case 2: Read array values
                case 2:
                    if (size == 0) {
                        System.out.println("Please enter size first (option 1).");
                        break; // Avoids filling uninitialized array
                    }
                    System.out.println("Enter " + size + " positive integers:");
                    for (int i = 0; i < size; i++) {
                        inputs[i] = input.nextInt();  // Populate array
                    }
                    break;
                // Skips execution if user hasn't set size yet
                // Allows storing user-defined positive integers

                // Case 3: Perform Radix Sort and print results
                case 3:
                    if (inputs.length == 0) {
                        System.out.println("Array is empty. Read values first.");
                        break;
                    }

                    // Save original values in string format for display
                    String before = "";
                    for (int num : inputs) {
                        before += num + ", ";
                    }
                    before = before.substring(0, before.length() - 2); // Remove trailing comma

                    // Sort the array using radixSort algorithm
                    radixSort(inputs);

                    // Print before and after arrays
                    System.out.println("Array values before sorting: " + before);
                    System.out.print("Array values after sorting: ");
                    for (int i = 0; i < inputs.length; i++) {
                        System.out.print(inputs[i]);
                        if (i != inputs.length - 1) System.out.print(", ");
                    }
                    System.out.println();
                    break;
                // Executes only if array has been filled; avoids errors
                // Displays a clear before-and-after comparison

                // Case 4: Exit the program
                case 4:
                    System.out.println("Exiting program.");
                    break;
                // Ends the loop and terminates user interaction

                // Default: Invalid input handler
                default:
                    System.out.println("Invalid option.");
                    break;
                // Catches anything other than 1–4
            }

// Continue loop unless user selects option 4
        } while (choice != 4);

        input.close();
    }

    public static void radixSort(int[] arr) {
        @SuppressWarnings("unchecked")
        Queue<Integer>[] buckets = new Queue[10];
        for (int i = 0; i < 10; i++) buckets[i] = new Queue<>();

        int maxDigits = getMaxDigits(arr); // Find max digit count for loop limit

        // Loop once for each digit position
        for (int pos = 0; pos < maxDigits; pos++) {
            // Distribute numbers into buckets based on current digit
            for (int num : arr) {
                int digit = extractDigit(num, pos);
                buckets[digit].enqueue(num);
            }

            // Reassemble numbers from buckets into original array
            int index = 0;
            for (int b = 0; b < 10; b++) {
                while (!buckets[b].isEmpty()) {
                    arr[index++] = buckets[b].dequeue();
                }
            }
        }
    }

    // Extracts digit at a specific position (0 = units, 1 = tens, 2 = hundreds, etc.)
    public static int extractDigit(int number, int pos) {
        // Divide number by 10^pos to shift desired digit to the units place,
        // then use modulo 10 to isolate the digit
        return (number / (int) Math.pow(10, pos)) % 10;
    }

    // Finds the maximum number of digits in the largest number in the array
    public static int getMaxDigits(int[] arr) {
        int max = arr[0]; // Start with the first value
        for (int num : arr) {
            if (num > max) max = num; // Track highest value
        }

        // Log base 10 of max gives digit count: log10(3465) ≈ 3.5 → 4 digits
        return (int) Math.log10(max) + 1;
    }
}
// Determines how many digit-positions are needed for sorting
// Ensures radix sort loops for correct number of passes
