// Name: Zaanie Bowen
// Class: CS3305/W03 
// Term: Summer 2025
// Instructor: Prof. Wang 
// Assignment: 6
// IDE Name: Visual Studio Code

import java.util.List;
import java.util.Scanner;

public class MyTestBST {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Create two tree objects — one for integers, one for strings
        BST<Integer> intTree = null;
        BST<String> stringTree = null;

        // Track which tree type was selected and ensure selection happens before other operations
        boolean isIntegerTree = false;
        boolean dataTypeSelected = false;

        int option;  // Stores user's menu selection

        // Main loop: displays menu until user selects Exit (option 10)
        do {
            System.out.println("----------------MAIN MENU---------------");
            System.out.println("0. Enter Tree Data Type (integer or string)");
            System.out.println("1. Insert Data Element");
            System.out.println("2. Delete Data Element");
            System.out.println("3. Search for Data Element");
            System.out.println("4. Print Tree Size");
            System.out.println("5. Path from Root to Data Element");
            System.out.println("6. Check if Empty Tree");
            System.out.println("7. Print Preorder Traversal");
            System.out.println("8. Print Inorder Traversal");
            System.out.println("9. Print Postorder Traversal");
            System.out.println("10. Exit program");
            System.out.println();
            System.out.print("Enter option number: ");
            System.out.println();

            // Parse the user input into an integer menu option
            option = Integer.parseInt(input.nextLine().trim());

            // Force the user to pick a tree data type first before doing anything else
            if (option != 0 && !dataTypeSelected) {
                System.out.println("Please select the tree data type first (option 0).\n");
                continue;
            }

            // Process user's menu selection
            switch (option) {

                // 0: Prompt the user to choose tree type — Integer or String
                case 0:
                    System.out.print("Enter tree data type (integer or string): ");
                    String type = input.nextLine().trim().toLowerCase();

                    if (type.equals("integer")) {
                        intTree = new BST<>();
                        isIntegerTree = true;
                        dataTypeSelected = true;
                        System.out.println("Integer BST created.\n");

                    } else if (type.equals("string")) {
                        stringTree = new BST<>();
                        isIntegerTree = false;
                        dataTypeSelected = true;
                        System.out.println("String BST created.\n");

                    } else {
                        System.out.println("Invalid type. Please enter 'integer' or 'string'.\n");
                    }
                    break;

                // 1: Insert a new value into the BST
                case 1:
                    System.out.println("Testing method Insert Data Element (Option 1)");

                    // Print tree before insertion (inorder)
                    System.out.print("BST before inserting (Inorder):\t"); // Added tab for alignment
                    if (isIntegerTree) printInorder(intTree);
                    else printInorder(stringTree);

                    // Prompt user for value to insert
                    System.out.print("Enter element to insert: ");
                    String toInsert = input.nextLine().trim();

                    // Insert into appropriate tree with type checking
                    if (isIntegerTree) {
                        try {
                            intTree.insert(Integer.parseInt(toInsert));
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid integer input. Please enter a valid integer.\n");
                            break;
                        }
                    } else {
                        stringTree.insert(toInsert);
                    }

                    // Print tree after insertion (inorder)
                    System.out.print("BST after inserting (Inorder):\t"); // Added tab for alignment
                    if (isIntegerTree) printInorder(intTree);
                    else printInorder(stringTree);
                    System.out.println();
                    break;

                // 2: Delete an existing value from the BST
                case 2:
                    System.out.println("Testing method Delete Data Element (Option 2)");
                    System.out.print("Enter element to delete: ");
                    String toDelete = input.nextLine().trim();

                    // Print current tree before deletion
                    System.out.print("BST before deleting (Inorder):\t"); // Added tab for alignment
                    if (isIntegerTree) {
                        printInorder(intTree);
                        try {
                            if (!intTree.delete(Integer.parseInt(toDelete))) {
                                System.out.println("Element not found in tree.");
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid integer input. Please enter a valid integer.\n");
                            break;
                        }
                    } else {
                        printInorder(stringTree);
                        if (!stringTree.delete(toDelete)) {
                            System.out.println("Element not found in tree.");
                        }
                    }

                    // Print tree after deletion
                    System.out.print("BST after deleting (Inorder):\t"); // Added tab for alignment
                    if (isIntegerTree) printInorder(intTree);
                    else printInorder(stringTree);
                    System.out.println();
                    break;

                // 3: Search for a value in the BST
                case 3:
                    System.out.println("Testing method Search for Data Element (Option 3)");
                    System.out.print("Enter element to search: ");
                    String toSearch = input.nextLine().trim();

                    boolean found = false;

                    if (isIntegerTree) {
                        try {
                            found = intTree.search(Integer.parseInt(toSearch));
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid integer input. Please enter a valid integer.\n");
                            break;
                        }
                    } else {
                        found = stringTree.search(toSearch);
                    }

                    // Display whether the element was found
                    System.out.println("Is " + toSearch + " in the tree?\t" + found + "\n");
                    break;

                // 4: Display the size (number of nodes) of the tree
                case 4:
                    System.out.println("Testing method Tree size (Option 4)");
                    int size = 0;
                    if (isIntegerTree && intTree != null) {
                        size = intTree.getSize();
                    } else if (!isIntegerTree && stringTree != null) {
                        size = stringTree.getSize();
                    }
                    System.out.println("Tree size:\t" + size + "\n");
                    break;

                // 5: Show the path from the root to a specific element
                case 5:
                    System.out.println("Testing method Path from Root to Data Element (Option 5)");
                    System.out.print("Enter element: ");
                    String toFind = input.nextLine().trim();

                    // Traverse and print the path to the element
                    if (isIntegerTree) {
                        try {
                            System.out.print("Path from root to " + toFind + ":\t");
                            List<BST.TreeNode<Integer>> path = intTree.path(Integer.parseInt(toFind));
                            if (path != null && !path.isEmpty()) {
                                if (!path.get(path.size() - 1).element.equals(Integer.parseInt(toFind))) {
                                    System.out.println("Element not found in tree.");
                                } else {
                                    for (int i = 0; i < path.size(); i++) {
                                        System.out.print(path.get(i).element + " ");
                                    }
                                }
                            } else {
                                System.out.println("Tree is empty or element not found.");
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid integer input. Please enter a valid integer.\n");
                            break;
                        }
                    } else {
                        System.out.print("Path from root to " + toFind + ":\t");
                        List<BST.TreeNode<String>> path = stringTree.path(toFind);
                        if (path != null && !path.isEmpty()) {
                             if (!path.get(path.size() - 1).element.equals(toFind)) {
                                System.out.println("Element not found in tree.");
                            } else {
                                for (int i = 0; i < path.size(); i++) {
                                    System.out.print(path.get(i).element + " ");
                                }
                            }
                        } else {
                            System.out.println("Tree is empty or element not found.");
                        }
                    }
                    System.out.println("\n");
                    break;

                // 6: Check whether the tree is currently empty
                case 6:
                    System.out.println("Testing method Check if Empty Tree (Option 6)");
                    boolean empty = true;
                    if (isIntegerTree && intTree != null) {
                        empty = intTree.isEmpty();
                    } else if (!isIntegerTree && stringTree != null) {
                        empty = stringTree.isEmpty();
                    }
                    System.out.println("Is empty tree?\t" + empty + "\n");
                    break;

                // 7: Print the tree in preorder traversal format
                case 7:
                    System.out.println("Testing method Preorder Traversal (Option 7)");
                    System.out.print("Preorder:\t");
                    if (isIntegerTree) {
                        if (intTree != null && !intTree.isEmpty()) {
                            List<BST.TreeNode<Integer>> preorder = intTree.preorder();
                            for (int i = 0; i < preorder.size(); i++) {
                                System.out.print(preorder.get(i).element + " ");
                            }
                        } else {
                            System.out.print("Tree is empty.");
                        }
                    } else {
                        if (stringTree != null && !stringTree.isEmpty()) {
                            List<BST.TreeNode<String>> preorder = stringTree.preorder();
                            for (int i = 0; i < preorder.size(); i++) {
                                System.out.print(preorder.get(i).element + " ");
                            }
                        } else {
                            System.out.print("Tree is empty.");
                        }
                    }
                    System.out.println("\n");
                    break;

                // 8: Print the tree in inorder traversal format
                case 8:
                    System.out.println("Testing method Inorder Traversal (Option 8)");
                    System.out.print("Inorder:\t");
                    if (isIntegerTree) {
                        if (intTree != null && !intTree.isEmpty()) {
                            List<BST.TreeNode<Integer>> inorder = intTree.inorder();
                            for (int i = 0; i < inorder.size(); i++) {
                                System.out.print(inorder.get(i).element + " ");
                            }
                        } else {
                            System.out.print("Tree is empty.");
                        }
                    } else {
                        if (stringTree != null && !stringTree.isEmpty()) {
                            List<BST.TreeNode<String>> inorder = stringTree.inorder();
                            for (int i = 0; i < inorder.size(); i++) {
                                System.out.print(inorder.get(i).element + " ");
                            }
                        } else {
                            System.out.print("Tree is empty.");
                        }
                    }
                    System.out.println("\n");
                    break;

                // 9: Print the tree in postorder traversal format
                case 9:
                    System.out.println("Testing method Postorder Traversal (Option 9)");
                    System.out.print("Postorder:\t");
                    if (isIntegerTree) {
                        if (intTree != null && !intTree.isEmpty()) {
                            List<BST.TreeNode<Integer>> postorder = intTree.postorder();
                            for (int i = 0; i < postorder.size(); i++) {
                                System.out.print(postorder.get(i).element + " ");
                            }
                        } else {
                            System.out.print("Tree is empty.");
                        }
                    } else {
                        if (stringTree != null && !stringTree.isEmpty()) {
                            List<BST.TreeNode<String>> postorder = stringTree.postorder();
                            for (int i = 0; i < postorder.size(); i++) {
                                System.out.print(postorder.get(i).element + " ");
                            }
                        } else {
                            System.out.print("Tree is empty.");
                        }
                    }
                    System.out.println("\n");
                    break;

                // 10: Exit the program
                case 10:
                    System.out.println("Exiting program.");
                    break;

                // Catch any invalid menu choices
                default:
                    System.out.println("Invalid option. Please enter 0–10.\n");
            }

        } while (option != 10);  // Sentinel loop condition

        input.close();  // Close scanner to free resources
    }

    /**
     * Generic helper method to print inorder traversal of a tree.
     * This method now takes a BST and retrieves the inorder list from it.
     * @param tree The BST to print.
     */
    private static <E> void printInorder(BST<E> tree) {
        if (tree == null || tree.isEmpty()) {
            System.out.println("Tree is empty.");
            return;
        }
        List<BST.TreeNode<E>> inorder = tree.inorder();
        for (int i = 0; i < inorder.size(); i++) {
            System.out.print(inorder.get(i).element + " ");
        }
        System.out.println();
    }
}
