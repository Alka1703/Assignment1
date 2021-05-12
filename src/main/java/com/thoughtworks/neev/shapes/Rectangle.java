package com.thoughtworks.neev.shapes;

import com.thoughtworks.neev.exception.AreaOutOfBoundsException;
import com.thoughtworks.neev.exception.DimensionOutOfBoundException;
import com.thoughtworks.neev.exception.PerimeterOutOfBoundsException;
import com.thoughtworks.neev.exception.NonPositiveDimensionException;

public class Rectangle {
    private final double length;
    private final double breadth;

    public static Rectangle createSquare(double side) {
        return new Rectangle(side, side);
    }

    public static Rectangle createRectangle(double length, double breadth) {
        return new Rectangle(length, breadth);
    }

    private void checkDimensionsValidity(double length, double breadth) {
        if (length <= 0 || breadth <= 0) {
            throw new NonPositiveDimensionException("Dimension cannot be negative.");
        }

        if (length >= Double.MAX_VALUE || breadth >= Double.MAX_VALUE) {
            throw new DimensionOutOfBoundException("Dimension cannot be greater than Double Max.");
        }
    }

    private Rectangle(double length, double breadth) {
        checkDimensionsValidity(length, breadth);

        this.length = length;
        this.breadth = breadth;
    }

    public double area() {
        double area = length * breadth;
        if (area >= Double.MAX_VALUE || area == Double.POSITIVE_INFINITY)
            throw new AreaOutOfBoundsException("Area Value exceeds the double range");
        return area;
    }

    public double perimeter() {


        double perimeter = 2 * (length + breadth);
        if (perimeter >= Double.MAX_VALUE || perimeter == Double.POSITIVE_INFINITY)
            throw new PerimeterOutOfBoundsException("Perimeter Value exceeds the double range");

        return perimeter;
    }
}
