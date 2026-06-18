// Name: Zaanie Bowen
// Class: CS3305/w03
// Term: Spring 2025
// Instructor: Prof. Wang
// Assignment: #1
// IDE: IntelliJ

import java.util.Scanner;

public class TestRectangle {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Create default rectangle
        Rectangle myRectangle = new Rectangle();

        // Prompt user for dimensions of yourRectangle
        System.out.print("Enter width for yourRectangle: ");
        double userWidth = input.nextDouble();
        System.out.print("Enter height for yourRectangle: ");
        double userHeight = input.nextDouble();
        Rectangle yourRectangle = new Rectangle(userWidth, userHeight);

        // Output for myRectangle
        System.out.println("\nTest data:\tmyRectangle:");
        System.out.println("\t\t------------");
        System.out.printf("\t\tWidth:\t\t%.2f%n", myRectangle.getWidth());
        System.out.printf("\t\tHeight:\t\t%.2f%n", myRectangle.getHeight());
        System.out.printf("\t\tArea:\t\t%.2f%n", myRectangle.getArea());
        System.out.printf("\t\tPerimeter:\t%.2f%n", myRectangle.getPerimeter());
        System.out.println();
        myRectangle.printRectangle("myRectangle");

        // Output for yourRectangle
        System.out.println();
        System.out.println("\tyourRectangle:");
        System.out.println("\t--------------");
        System.out.printf("\tWidth:\t\t%.2f%n", yourRectangle.getWidth());
        System.out.printf("\tHeight:\t\t%.2f%n", yourRectangle.getHeight());
        System.out.printf("\tArea:\t\t%.2f%n", yourRectangle.getArea());
        System.out.printf("\tPerimeter:\t%.2f%n", yourRectangle.getPerimeter());
        System.out.println();
        yourRectangle.printRectangle("yourRectangle");
    }
}
