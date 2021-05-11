package com.thoughtworks.neev.shapes;

import com.thoughtworks.neev.exception.AreaOutOfBoundsException;
import com.thoughtworks.neev.exception.DimensionOutOfBoundException;
import com.thoughtworks.neev.exception.PerimeterOutOfBoundsException;
import com.thoughtworks.neev.exception.NonPositiveDimensionException;

public class Rectangle {
    private final double length;
    private final double breadth;

    public Rectangle(double side) {
        this.length=side;
        this.breadth=side;
    }

    private void checkDimensionsValidity(double length, double breadth) throws NonPositiveDimensionException, DimensionOutOfBoundException {
        if (length <= 0 || breadth <= 0) {
            throw new NonPositiveDimensionException("Dimension cannot be negative.");
        }
        if (length >= Double.MAX_VALUE || breadth >= Double.MAX_VALUE) {
            throw new DimensionOutOfBoundException("Dimension cannot be greater than Double Max.");
        }
    }

    public Rectangle(double length, double breadth) throws NonPositiveDimensionException, DimensionOutOfBoundException {
        checkDimensionsValidity(length, breadth);

        this.length = length;
        this.breadth = breadth;
    }

    public double area() throws AreaOutOfBoundsException {
        double area = length * breadth;
        if (area >= Double.MAX_VALUE || area == Double.POSITIVE_INFINITY)
        throw new AreaOutOfBoundsException("Area Value exceeds the double range");
        return area;
    }

    public double perimeter() throws PerimeterOutOfBoundsException {


        double perimeter = 2 * (length + breadth);
        if (perimeter >= Double.MAX_VALUE || perimeter == Double.POSITIVE_INFINITY)
            throw new PerimeterOutOfBoundsException("Perimeter Value exceeds the double range");

        return perimeter;
    }
}
