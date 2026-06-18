import java.util.Scanner;

public class myTest {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        LinkedList myList = new LinkedList(); // create a list object

        // Initial values
        myList.addLastNode(10);
        myList.addLastNode(20);
        myList.addLastNode(30);
        myList.addLastNode(40);
        myList.addLastNode(50);

        int choice;

        do {
            System.out.println("\n---------MAIN MENU--------");
            System.out.println("1 – Add First Node");
            System.out.println("2 – Add Last Node");
            System.out.println("3 – Add At Index");
            System.out.println("4 – Remove First Node");
            System.out.println("5 – Remove Last Node");
            System.out.println("6 – Remove At Index");
            System.out.println("7 – Print List Size");
            System.out.println("8 – Print List (Forward)");
            System.out.println("9 – Print List (In Reverse)");
            System.out.println("10- Exit program");
            System.out.print("Enter option number: ");
            choice = input.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Testing method addFirstNode()");
                    System.out.print("Enter value to add at the beginning: ");
                    int firstValue = input.nextInt();
                    System.out.print("List content before adding: ");
                    myList.printList();
                    myList.addFirstNode(firstValue);
                    System.out.print("List content after adding: ");
                    myList.printList();
                    break;

                case 2:
                    System.out.println("Testing method addLastNode()");
                    System.out.print("Enter value to add at the end: ");
                    int lastValue = input.nextInt();
                    System.out.print("List content before adding: ");
                    myList.printList();
                    myList.addLastNode(lastValue);
                    System.out.print("List content after adding: ");
                    myList.printList();
                    break;

                case 3:
                    System.out.println("Testing method addAtIndex()");
                    System.out.print("Enter index to insert at: ");
                    int indexAdd = input.nextInt();
                    System.out.print("Enter value to add: ");
                    int valueAdd = input.nextInt();
                    System.out.print("List content before adding: ");
                    myList.printList();
                    myList.addAtIndex(indexAdd, valueAdd);
                    System.out.print("List content after adding: ");
                    myList.printList();
                    break;

                case 4:
                    System.out.println("Testing method removeFirstNode()");
                    System.out.print("List content before removing: ");
                    myList.printList();
                    myList.removeFirstNode();
                    System.out.print("List content after removing: ");
                    myList.printList();
                    break;

                case 5:
                    System.out.println("Testing method removeLastNode()");
                    System.out.print("List content before removing: ");
                    myList.printList();
                    myList.removeLastNode();
                    System.out.print("List content after removing: ");
                    myList.printList();
                    break;

                case 6:
                    System.out.println("Testing method removeAtIndex()");
                    System.out.print("Enter index to remove: ");
                    int indexRemove = input.nextInt();
                    System.out.print("List content before removing: ");
                    myList.printList();
                    myList.removeAtIndex(indexRemove);
                    System.out.print("List content after removing: ");
                    myList.printList();
                    break;

                case 7:
                    System.out.println("List size is: " + myList.countNodes());
                    break;

                case 8:
                    System.out.print("List (Forward): ");
                    myList.printList();
                    break;

                case 9:
                    System.out.print("List (In Reverse): ");
                    myList.printInReverse();
                    System.out.println();
                    break;

                case 10:
                    System.out.println("Exiting program.");
                    break;

                default:
                    System.out.println("Invalid option. Try again.");
            }

        } while (choice != 10);
    }
}
