import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RectangleTest {

    @Test
    public void shouldReturnAreaEqualsZeroIfSideIsZero() {
        Rectangle rectangle = new Rectangle(0, 3);
        double expectedArea = 0;

        double actualArea = rectangle.area();

        assertEquals(expectedArea, actualArea);
    }

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
    public void shouldReturnCalculatedAreaIfSideIsNegative() {
        assertThrows(IllegalArgumentException.class, () -> new Rectangle(-10, -3));
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

}