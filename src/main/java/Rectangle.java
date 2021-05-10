public class Rectangle {
    private final double length;
    private final double breadth;

    private void checkDimensionsValidity(double length, double breadth) {
        if (length < 0 || breadth < 0) {
            throw new IllegalArgumentException("Dimension cannot be negative.");
        }
    }

    public Rectangle(double length, double breadth) {
        checkDimensionsValidity(length, breadth);

        this.length = length;
        this.breadth = breadth;
    }

    public double area() {
        return length * breadth;
    }

    public double perimeter() {
        return 4;
    }
}
