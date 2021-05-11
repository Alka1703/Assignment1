import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RectangleTest {

    //Validating Dimensions of Rectangle

    @Test
    public void shouldRaiseExceptionIfAnySideIsNegative() {
        Executable executable = () -> new Rectangle(-10, -3);

        assertThrows(ValidateRectangleDimensionException.class, executable);
    }

    @Test
    void shouldRaiseExceptionIfAnySideIsDoubleMax() {
        Executable executable = () -> new Rectangle(Double.MAX_VALUE, Double.MAX_VALUE);

        assertThrows(ValidateRectangleDimensionException.class, executable);

    }

    @Test
    public void shouldRaiseExceptionIfAnySideIsZero() {
        Executable executable = () -> new Rectangle(0, 0);

        assertThrows(ValidateRectangleDimensionException.class, executable);
    }

    //Area Tests

    @Test
    public void shouldReturnAreaEqualsOneIfBothSidesAreOne() throws ValidateRectangleDimensionException, AreaOutOfBoundsException {
        Rectangle rectangle = new Rectangle(1, 1);
        double expectedArea = 1;

        double actualArea = rectangle.area();

        assertEquals(expectedArea, actualArea);
    }

    @Test
    public void shouldReturnCalculatedAreaIfSidesArePositive() throws ValidateRectangleDimensionException, AreaOutOfBoundsException {
        Rectangle rectangle = new Rectangle(10, 20);
        double expectedArea = 200;

        double actualArea = rectangle.area();

        assertEquals(expectedArea, actualArea);
    }

    @Test
    void shouldRaiseExceptionIAreaOverFlowsMaxValueOfDouble() throws ValidateRectangleDimensionException {
        Rectangle rectangle = new Rectangle(Double.MAX_VALUE / 2, Double.MAX_VALUE / 2);
        Executable executable = rectangle::area;

        assertThrows(AreaOutOfBoundsException.class, executable);

    }

    // Perimeter Tests
    @Test
    public void shouldReturnPerimeterFourForUnitSides() throws ValidateRectangleDimensionException, PerimeterOutOfBoundsException {
        Rectangle rectangle = new Rectangle(1, 1);
        double expectedPerimeter = 4;

        double actualPerimeter = rectangle.perimeter();

        assertEquals(expectedPerimeter, actualPerimeter);
    }

    @Test
    public void shouldReturnPerimeterValueForPositiveSides() throws ValidateRectangleDimensionException, PerimeterOutOfBoundsException {
        Rectangle rectangle = new Rectangle(4, 5);
        double expectedPerimeter = 18;

        double actualPerimeter = rectangle.perimeter();

        assertEquals(expectedPerimeter, actualPerimeter);
    }

    @Test
    void shouldRaiseExceptionIfPerimeterOverFlowsMaxValueOfDouble() throws ValidateRectangleDimensionException {
        Rectangle rectangle = new Rectangle(Double.MAX_VALUE / 2, Double.MAX_VALUE / 2);
        Executable executable = rectangle::perimeter;

        assertThrows(PerimeterOutOfBoundsException.class, executable);

    }
}