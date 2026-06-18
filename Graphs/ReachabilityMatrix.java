// Name: Zaanie Bowen
// Class: CS3305/Section
// Term: Summer 2025
// Instructor: Prof. Wang
// Assignment: #8
// IDE Name: IntelliJ IDEA

import java.util.Scanner;

public class ReachabilityMatrix {

    static final int MAX_NODES = 5; // maximum allowed nodes
    static int[][] A1 = new int[MAX_NODES][MAX_NODES]; // adjacency matrix
    static int[][][] powers = new int[MAX_NODES][][]; // A1 to A5
    static int numNodes = 0;
    static boolean dataEntered = false;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int choice;

        do {
            // Print menu with blank lines before/after
            System.out.println("\n------MAIN MENU------");
            System.out.println("1. Enter graph data");
            System.out.println("2. Print outputs");
            System.out.println("3. Exit program");
            System.out.println();
            System.out.print("Enter option number: ");
            System.out.println();

            choice = input.nextInt();

            switch (choice) {
                case 1:
                    enterGraphData(input); // input graph from user
                    break;
                case 2:
                    if (!dataEntered) {
                        // alert if graph not entered yet
                        System.out.println("\nPlease enter graph data first.\n");
                    } else {
                        // call all 10 output methods
                        printInputMatrix();
                        printReachabilityMatrix();
                        printInDegrees();
                        printOutDegrees();
                        printSelfLoops();
                        printCycles();
                        printTotalPathsLength1();
                        printTotalPathsLength3();
                        printTotalPaths1to3();
                        printTotalCycles1to3();
                    }
                    break;
                case 3:
                    System.out.println("\nProgram exited.");
                    break;
                default:
                    System.out.println("\nInvalid option. Please try again.");
            }

        } while (choice != 3);

        input.close();
    }

    // Reads graph data into adjacency matrix A1
    public static void enterGraphData(Scanner input) {
        System.out.print("Enter number of nodes (<=5): ");
        numNodes = input.nextInt();

        // validate node count
        while (numNodes < 1 || numNodes > MAX_NODES) {
            System.out.print("Invalid input. Enter number of nodes (1 to 5): ");
            numNodes = input.nextInt();
        }

        // Read matrix values row-by-row
        for (int i = 0; i < numNodes; i++) {
            for (int j = 0; j < numNodes; j++) {
                System.out.print("Enter A1[" + i + "," + j + "]: ");
                A1[i][j] = input.nextInt();
            }
        }

        // Precompute A^2 to A^n
        powers[0] = A1;
        for (int p = 1; p < numNodes; p++) {
            powers[p] = multiplyMatrices(powers[p - 1], A1);
        }

        dataEntered = true; // allow output menu access
    }

    // Prints the input adjacency matrix
    public static void printInputMatrix() {
        System.out.println("\nInput Matrix:");
        printMatrix(A1);
    }

    // Computes and prints reachability matrix (sum of A1 through An)
    public static void printReachabilityMatrix() {
        int[][] reach = new int[numNodes][numNodes];

        // sum all power matrices
        for (int k = 0; k < numNodes; k++) {
            for (int i = 0; i < numNodes; i++) {
                for (int j = 0; j < numNodes; j++) {
                    reach[i][j] += powers[k][i][j];
                }
            }
        }

        System.out.println("\nReachability Matrix:");
        printMatrix(reach);
    }

    // Prints in-degree for each node
    public static void printInDegrees() {
        System.out.println("\nIn-degrees:");
        for (int j = 0; j < numNodes; j++) {
            int in = 0;
            for (int i = 0; i < numNodes; i++) {
                in += A1[i][j];
            }
            System.out.println("Node " + (j + 1) + " in-degree is " + in);
        }
    }

    // Prints out-degree for each node
    public static void printOutDegrees() {
        System.out.println("\nOut-degrees:");
        for (int i = 0; i < numNodes; i++) {
            int out = 0;
            for (int j = 0; j < numNodes; j++) {
                out += A1[i][j];
            }
            System.out.println("Node " + (i + 1) + " out-degree is " + out);
        }
    }

    // Prints total number of self-loops (diagonal values in A1)
    public static void printSelfLoops() {
        int loops = 0;
        for (int i = 0; i < numNodes; i++) {
            if (A1[i][i] == 1) loops++;
        }
        System.out.println("\nTotal number of self-loops: " + loops);
    }

    // Prints total cycles of length N
    public static void printCycles() {
        int[][] An = powers[numNodes - 1];
        int cycles = 0;
        for (int i = 0; i < numNodes; i++) {
            cycles += An[i][i]; // diagonal trace
        }
        System.out.println("Total number of cycles of length " + numNodes + " edges: " + cycles);
    }

    // Total paths of length 1 (sum of all values in A1)
    public static void printTotalPathsLength1() {
        int count = 0;
        for (int i = 0; i < numNodes; i++) {
            for (int j = 0; j < numNodes; j++) {
                count += A1[i][j];
            }
        }
        System.out.println("Total number of paths of length 1 edge: " + count);
    }

    // Total paths of length 3 (sum of all values in A3)
    public static void printTotalPathsLength3() {
        if (numNodes < 3) {
            System.out.println("Total number of paths of length 3 edges: 0");
            return;
        }

        int[][] A3 = powers[2];
        int count = 0;
        for (int i = 0; i < numNodes; i++) {
            for (int j = 0; j < numNodes; j++) {
                count += A3[i][j];
            }
        }
        System.out.println("Total number of paths of length 3 edges: " + count);
    }

    // Total number of paths of length 1 to 3
    public static void printTotalPaths1to3() {
        int sum = 0;
        for (int k = 0; k < 3 && k < numNodes; k++) {
            for (int i = 0; i < numNodes; i++) {
                for (int j = 0; j < numNodes; j++) {
                    sum += powers[k][i][j];
                }
            }
        }
        System.out.println("Total number of paths of length 1 to 3 edges: " + sum);
    }

    // Total cycles of length 1 to 3
    public static void printTotalCycles1to3() {
        int cycles = 0;
        for (int k = 0; k < 3 && k < numNodes; k++) {
            for (int i = 0; i < numNodes; i++) {
                cycles += powers[k][i][i]; // diagonal sum from A1 to A3
            }
        }
        System.out.println("Total number of cycles of length 1 to 3 edges: " + cycles);
        System.out.println("--------------------------------------------------");
        System.out.println();

    }

    // Multiplies two matrices of size [n][n]
    public static int[][] multiplyMatrices(int[][] a, int[][] b) {
        int[][] result = new int[numNodes][numNodes];
        for (int i = 0; i < numNodes; i++) {
            for (int j = 0; j < numNodes; j++) {
                for (int k = 0; k < numNodes; k++) {
                    result[i][j] += a[i][k] * b[k][j];
                }
            }
        }
        return result;
    }

    // Utility to print any n x n matrix
    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i < numNodes; i++) {
            for (int j = 0; j < numNodes; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println(); // newline after row
        }
    }
}
