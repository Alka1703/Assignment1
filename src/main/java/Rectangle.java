public class Rectangle {
    private final double length;
    private final double breadth;

    private void checkDimensionsValidity(double length, double breadth) throws ValidateRectangleDimensionException {
        if (length <= 0 || breadth <= 0) {
            throw new ValidateRectangleDimensionException("Dimension cannot be negative.");
        }
        if (length >= Double.MAX_VALUE || breadth >= Double.MAX_VALUE) {
            throw new ValidateRectangleDimensionException("Dimension cannot be greater than Double Max.");
        }
    }

    public Rectangle(double length, double breadth) throws ValidateRectangleDimensionException {
        checkDimensionsValidity(length, breadth);

        this.length = length;
        this.breadth = breadth;
    }

    public double area() throws AreaOutOfBoundsException {
        double area = length * breadth;
        if (area == Double.MAX_VALUE || area == Double.POSITIVE_INFINITY)
        throw new AreaOutOfBoundsException("Area Value exceeds the double range");
        return area;
    }

    public double perimeter() throws PerimeterOutOfBoundsException {


        double perimeter = 2 * (length + breadth);
        if (perimeter == Double.MAX_VALUE || perimeter == Double.POSITIVE_INFINITY)
            throw new PerimeterOutOfBoundsException("Perimeter Value exceeds the double range");

        return perimeter;
    }
}
