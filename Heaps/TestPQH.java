import java.util.Scanner;

public class TestPQH {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Queue objects and state tracking
        PQ_heap<Integer> intQueue = null;
        PQ_heap<String> strQueue = null;
        boolean isInt = true;
        boolean initialized = false;

        // Menu loop
        while (true) {
            System.out.println("\n\n----------------MAIN MENU---------------");
            System.out.println("0. Enter Queue Type (integer or string)");
            System.out.println("1. Enqueue Element");
            System.out.println("2. Dequeue Element");
            System.out.println("3. Check is_Full");
            System.out.println("4. Check is_Empty");
            System.out.println("5. Print PQueue Size");
            System.out.println("6. Display Front Element");
            System.out.println("7. Print PQueue Elements");
            System.out.println("8. Exit program");
            System.out.print("\nEnter option number: ");

            int option = input.nextInt();
            input.nextLine(); // clear newline

            // Option 0 - Set queue type
            if (option == 0) {
                System.out.print("Enter type (integer/string): ");
                String type = input.nextLine().toLowerCase();

                if (type.equals("integer")) {
                    intQueue = new PQ_heap<>();
                    isInt = true;
                    initialized = true;
                    System.out.println("Integer priority queue created.");
                } else if (type.equals("string")) {
                    strQueue = new PQ_heap<>();
                    isInt = false;
                    initialized = true;
                    System.out.println("String priority queue created.");
                } else {
                    System.out.println("Invalid type! Please enter 'integer' or 'string'.");
                }

            } else if (!initialized) {
                System.out.println("Please select queue type first using Option 0.");

            } else if (option == 1) {
                // Enqueue
                System.out.println("Testing method Enqueue Element (Option 1)");
                System.out.print("Enter value: ");
                if (isInt) {
                    int val = input.nextInt();
                    intQueue.enqueue(val);
                } else {
                    String val = input.nextLine();
                    strQueue.enqueue(val);
                }

            } else if (option == 2) {
                // Dequeue
                System.out.println("Testing method Dequeue Element (Option 2)");
                if (isInt) {
                    System.out.println("Dequeued: " + intQueue.dequeue());
                } else {
                    System.out.println("Dequeued: " + strQueue.dequeue());
                }

            } else if (option == 3) {
                // is_full
                System.out.println("Testing method Check is_Full (Option 3)");
                boolean result = isInt ? intQueue.is_full() : strQueue.is_full();
                System.out.println("PQueue is full: " + result);

            } else if (option == 4) {
                // is_empty
                System.out.println("Testing method Check is_Empty (Option 4)");
                boolean result = isInt ? intQueue.is_empty() : strQueue.is_empty();
                System.out.println("PQueue is empty: " + result);

            } else if (option == 5) {
                // size
                System.out.println("Testing method Print PQueue Size (Option 5)");
                int size = isInt ? intQueue.size() : strQueue.size();
                System.out.println("PQueue size: " + size);

            } else if (option == 6) {
                // front/peek
                System.out.println("Testing method Display Front Element (Option 6)");
                Object front = isInt ? intQueue.front() : strQueue.front();
                System.out.println("Front element: " + front);

            } else if (option == 7) {
                // print elements
                System.out.println("Testing method Print PQueue Elements (Option 7)");

                java.util.ArrayList<?> list = isInt ? intQueue.getHeapList() : strQueue.getHeapList();
                int index = 0;
                int level = 0;

                while (index < list.size()) {
                    int nodesInLevel = (int)Math.pow(2, level);
                    System.out.print("Index " + index + ": ");
                    for (int i = 0; i < nodesInLevel && index < list.size(); i++, index++) {
                        System.out.print(list.get(index) + " ");
                    }
                    System.out.println();
                    level++;
                }

            } else if (option == 8) {
                // exit
                System.out.println("Exiting program...");
                break;

            } else {
                System.out.println("Invalid option. Please try again.");
            }
        }

        input.close();
    }
}
