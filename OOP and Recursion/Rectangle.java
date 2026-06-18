public class Rectangle {
    private double width;
    private double height;

    // Default constructor
    public Rectangle() {
        this.width = 1.0;
        this.height = 1.0;
    }

    // Parameterized constructor
    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    // Getters
    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    // Area
    public double getArea() {
        return width * height;
    }

    // Perimeter
    public double getPerimeter() {
        return 2 * (width + height);
    }

    // Print rectangle details
    public void printRectangle(String objectName) {
        String widthLabel = (width == 1.0) ? "unit" : "units";
        String heightLabel = (height == 1.0) ? "unit" : "units";

        System.out.printf("Rectangle %s is %.1f %s wide and %.1f %s high.%n",
            objectName, width, widthLabel, height, heightLabel);
    }
}
