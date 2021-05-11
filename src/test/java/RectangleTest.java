import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RectangleTest {

    //Validating Dimensions of Rectangle

    @Test
    public void shouldRaiseExceptionIfAnySideIsNegative() {
        Executable executable = () -> new Rectangle(-10, -3);

        assertThrows(IllegalArgumentException.class, executable);
    }

    @Test
    void shouldRaiseExceptionIfAnySideIsDoubleMax() {
        Executable executable = () -> new Rectangle(Double.MAX_VALUE, Double.MAX_VALUE);

        assertThrows(IllegalArgumentException.class, executable);

    }

    @Test
    public void shouldRaiseExceptionIfAnySideIsZero() {
        Executable executable = () -> new Rectangle(0, 0);

        assertThrows(IllegalArgumentException.class, executable);
    }

    //Area Tests

    @Test
    public void shouldReturnAreaEqualsOneIfBothSidesAreOne() {
        Rectangle rectangle = new Rectangle(1, 1);
        double expectedArea = 1;

        double actualArea = rectangle.area();

        assertEquals(expectedArea, actualArea);
    }

    @Test
    public void shouldReturnCalculatedAreaIfSidesArePositive() {
        Rectangle rectangle = new Rectangle(10, 20);
        double expectedArea = 200;

        double actualArea = rectangle.area();

        assertEquals(expectedArea, actualArea);
    }

    @Test
    public void shouldReturnInfinityIfTheAreaOverflowsMaxValueOfDouble() {
        Rectangle rectangle = new Rectangle(Double.MAX_VALUE - 1, Double.MAX_VALUE - 1);
        double expectedArea = Double.POSITIVE_INFINITY;

        double actualArea = rectangle.area();

        assertEquals(expectedArea, actualArea);
    }

    // Perimeter Tests
    @Test
    public void shouldReturnPerimeterFourForUnitSides() {
        Rectangle rectangle = new Rectangle(1, 1);
        double expectedPerimeter = 4;

        double actualPerimeter = rectangle.perimeter();

        assertEquals(expectedPerimeter, actualPerimeter);
    }

    @Test
    public void shouldReturnPerimeterValueForPositiveSides() {
        Rectangle rectangle = new Rectangle(4, 5);
        double expectedPerimeter = 18;

        double actualPerimeter = rectangle.perimeter();

        assertEquals(expectedPerimeter, actualPerimeter);
    }

    @Test
    void shouldReturnInfinityIfPerimeterOverFlowsMaxValueOfDouble() {
        Rectangle rectangle = new Rectangle(Double.MAX_VALUE - 1, Double.MAX_VALUE);
        double expectedPerimeter = Double.POSITIVE_INFINITY;

        double actualPerimeter = rectangle.perimeter();

        assertEquals(expectedPerimeter, actualPerimeter);
    }
}