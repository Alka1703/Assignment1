import com.thoughtworks.neev.exception.AreaOutOfBoundsException;
import com.thoughtworks.neev.exception.DimensionOutOfBoundException;
import com.thoughtworks.neev.exception.PerimeterOutOfBoundsException;
import com.thoughtworks.neev.exception.NonPositiveDimensionException;
import com.thoughtworks.neev.shapes.Rectangle;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static com.thoughtworks.neev.shapes.Rectangle.createRectangle;
import static com.thoughtworks.neev.shapes.Rectangle.createSquare;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RectangleTest {

    @Test
    public void shouldRaiseExceptionIfAnySideIsNegative() {
        Executable executable = () -> createRectangle(-10, -3);

        assertThrows(NonPositiveDimensionException.class, executable);
    }

    @Test
    void shouldRaiseExceptionIfAnySideIsDoubleMax() {
        Executable executable = () -> createRectangle(Double.MAX_VALUE + 1, Double.MAX_VALUE + 1);

        assertThrows(DimensionOutOfBoundException.class, executable);

    }

    @Test
    public void shouldRaiseExceptionIfAnySideIsZero() {
        Executable executable = () -> createRectangle(0, 0);

        assertThrows(NonPositiveDimensionException.class, executable);
    }

    @Test
    @Tag("Area")
    public void shouldReturnAreaEqualsOneIfBothSidesAreOne() {
        Rectangle rectangle = createRectangle(1, 1);
        double expectedArea = 1;

        double actualArea = rectangle.area();

        assertEquals(expectedArea, actualArea);
    }

    @Test
    @Tag("Area")
    void shouldReturnPositiveAreaForPositiveSides() {
        Rectangle square = createSquare(5);
        double expectedArea = 25;

        double actualArea = square.area();

        assertEquals(expectedArea, actualArea);

    }

    @Test
    public void shouldReturnCalculatedAreaIfSidesArePositive() {
        Rectangle rectangle = createRectangle(10, 20);
        double expectedArea = 200;

        double actualArea = rectangle.area();

        assertEquals(expectedArea, actualArea);
    }

    @Test
    void shouldRaiseExceptionIfAreaOverFlowsMaxValueOfDouble() {
        Rectangle rectangle = createRectangle(Double.MAX_VALUE / 5, Double.MAX_VALUE / 10);
        Executable executable = rectangle::area;

        assertThrows(AreaOutOfBoundsException.class, executable);
    }

    @Test
    public void shouldReturnPerimeterFourForUnitSides() {
        Rectangle rectangle = createRectangle(1, 1);
        double expectedPerimeter = 4;

        double actualPerimeter = rectangle.perimeter();

        assertEquals(expectedPerimeter, actualPerimeter);
    }

    @Test
    public void shouldReturnPerimeterValueForPositiveSides() {
        Rectangle rectangle = createRectangle(4, 5);
        double expectedPerimeter = 18;

        double actualPerimeter = rectangle.perimeter();

        assertEquals(expectedPerimeter, actualPerimeter);
    }

    @Test
    void shouldRaiseExceptionIfPerimeterOverFlowsMaxValueOfDouble() {
        Rectangle rectangle = createRectangle(Double.MAX_VALUE / 2, Double.MAX_VALUE / 2);
        Executable executable = rectangle::perimeter;

        assertThrows(PerimeterOutOfBoundsException.class, executable);

    }

}