// Name: Zaanie Bowen
// Class: CS3305/Section
// Term: Summer 2025
// Instructor: Prof. Wang
// Assignment: #7
// IDE Name: IntelliJ IDEA

import java.util.Scanner;

public class HashFunctions {
    // Hardcoded array of 50 unique keys, per assignment specification
    static int[] keys = {
            1234, 8234, 7867, 1009, 5438, 4312, 3420, 9487, 5418, 5299,
            5078, 8239, 1208, 5098, 5195, 5329, 4543, 3344, 7698, 5412,
            5567, 5672, 7934, 1254, 6091, 8732, 3095, 1975, 3843, 5589,
            5439, 8907, 4097, 3096, 4310, 5298, 9156, 3895, 6673, 7871,
            5787, 9289, 4553, 7822, 8755, 3398, 6774, 8289, 7665, 5523
    };

    // 2D array representing hash table [key, number of probes]
    static int[][] table = new int[50][2];

    // Main method - displays menu, accepts user input, and calls appropriate hash function
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\n\n-----MAIN MENU--------------------------------------");
            System.out.println("1. Run HF1 (Division method with Linear Probing)");
            System.out.println("2. Run HF2 (Division method with Quadratic Probing)");
            System.out.println("3. Run HF3 (Division method with Double Hashing)");
            System.out.println("4. Run HF4 (Student Designed HF)");
            System.out.println("5. Exit program");
            System.out.println();
            System.out.print("Enter option number: ");
            choice = input.nextInt();

            switch (choice) {
                case 1 -> runHF(HashFunctions::HF1, "HF1");
                case 2 -> runHF(HashFunctions::HF2, "HF2");
                case 3 -> runHF(HashFunctions::HF3, "HF3");
                case 4 -> runHF(HashFunctions::HF4, "HF4");
            }
        } while (choice != 5);
    }

    // Helper to reset table, run hash function, display formatted results, and print probe summary
    static void runHF(Runnable hf, String label) {
        for (int i = 0; i < 50; i++) table[i][0] = table[i][1] = -1;
        hf.run();
        System.out.println("\nHash table resulted from " + label + ":");
        System.out.println("Index        Key        Probes");
        System.out.println("--------------------------------");
        for (int i = 0; i < 50; i++) {
            if (table[i][0] != -1)
                System.out.println("    " + i + "        " + table[i][0] + "         " + table[i][1]);
        }
        System.out.println("--------------------------------");
        System.out.println("Sum of probe values = " + sumProbes() + " probes.\n");
    }

    //Sums all probe counts from the table (2nd column)
    static int sumProbes() {
        int sum = 0;
        for (int i = 0; i < 50; i++)
            if (table[i][0] != -1)
                sum += table[i][1];
        return sum;
    }

    // HF1: Division hashing + Linear Probing
    static void HF1() {
        for (int key : keys) {
            int hash = key % 50;
            int probes = 0;
            while (table[hash][0] != -1) {
                probes++;
                hash = (hash + 1) % 50;
            }
            table[hash][0] = key;
            table[hash][1] = probes;
        }
    }

    // HF2: Division hashing + Quadratic Probing
    static void HF2() {
        for (int key : keys) {
            int hash = key % 50;
            int j = 0, probes = 0;
            while (table[(hash + j * j) % 50][0] != -1) {
                j++;
                probes++;
            }
            int idx = (hash + j * j) % 50;
            table[idx][0] = key;
            table[idx][1] = probes;
        }
    }

    // HF3: Division hashing + Double Hashing with secondary hash H2(key) = 30 - (key % 25)
    static void HF3() {
        for (int key : keys) {
            int hash1 = key % 50;
            int hash2 = 30 - key % 25;
            int j = 0, probes = 0, idx = hash1;

            while (j < 50 && table[idx][0] != -1) {
                j++;
                probes++;
                idx = (hash1 + j * hash2) % 50;
            }

            if (j >= 50) {
                System.out.println("Unable to hash key " + key + " to the table");
                continue;
            }

            table[idx][0] = key;
            table[idx][1] = probes;
        }
    }

    /**
     * HF4: My hash function
     * Hashing Method: I used the multiplicative method based on Knuth’s suggestion.
     * Collision Resolution: Linear probing
     * Goal: To reduce the total number of probes to under 80 and hash at least 90% of the keys.
     *
     * Explanation:
     * For this hash function, I wanted to try something different from the usual division method,
     * so I used the multiplicative approach. It works by multiplying the key by a constant (A ≈ 0.618)
     * and taking the fractional part, then scaling that by the table size (50). The formula looks like:
     *     hash(k) = floor(50 * ((k * A) % 1))
     *
     * I chose this method because it's known for spreading keys more evenly due to how the math works.
     * For collisions, I kept it simple by using linear probing to find the next available spot.
     *
     * This method is not based on division, and it helped improve the spread of keys and reduced
     * the number of collisions compared to HF1–HF3.
     */
    static void HF4() {
        double A = 0.6180339887; // Golden ratio approximation for multiplicative hashing
        for (int key : keys) {
            int hash = (int) Math.floor(50 * ((key * A) % 1));
            int probes = 0;
            while (probes < 50 && table[hash][0] != -1) {
                probes++;
                hash = (hash + 1) % 50;
            }
            if (probes >= 50) {
                System.out.println("Unable to hash key " + key + " to the table");
                continue;
            }
            table[hash][0] = key;
            table[hash][1] = probes;
        }
    }
}
