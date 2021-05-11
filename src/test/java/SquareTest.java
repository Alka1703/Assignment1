import com.thoughtworks.neev.exception.AreaOutOfBoundsException;
import com.thoughtworks.neev.exception.DimensionOutOfBoundException;
import com.thoughtworks.neev.exception.NonPositiveDimensionException;
import com.thoughtworks.neev.exception.PerimeterOutOfBoundsException;
import com.thoughtworks.neev.shapes.Rectangle;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static com.thoughtworks.neev.shapes.Rectangle.createSquare;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class SquareTest {

    @Test
    public void shouldRaiseExceptionForNegativeSide() {
        Executable executable = () -> createSquare(-10);

        assertThrows(NonPositiveDimensionException.class, executable);
    }

    @Test
    void shouldRaiseExceptionIfAnySideIsDoubleMax() {
        Executable executable = () -> createSquare(Double.MAX_VALUE - 1);

        assertThrows(DimensionOutOfBoundException.class, executable);
    }

    @Test
    public void shouldReturnAreaOneForUnitSides() throws AreaOutOfBoundsException, DimensionOutOfBoundException, NonPositiveDimensionException {
        Rectangle square = createSquare(1);
        double expectedArea = 1;

        double actualArea = square.area();

        assertEquals(expectedArea, actualArea);


    }

    @Test
    void shouldReturnPositiveAreaForPositiveSides() throws AreaOutOfBoundsException, DimensionOutOfBoundException, NonPositiveDimensionException {
        Rectangle square = createSquare(5);
        double expectedArea = 25;

        double actualArea = square.area();

        assertEquals(expectedArea, actualArea);

    }

    @Test
    void shouldReturnPerimeterFourForUnitSides() throws PerimeterOutOfBoundsException, DimensionOutOfBoundException, NonPositiveDimensionException {
        Rectangle square = createSquare(1);
        double expectedPerimeter = 4;

        double actualPerimeter = square.perimeter();

        assertEquals(expectedPerimeter, actualPerimeter);
    }

    @Test
    void shouldReturnPerimeterValueForPositiveSides() throws PerimeterOutOfBoundsException, DimensionOutOfBoundException, NonPositiveDimensionException {
        Rectangle square = createSquare(5);
        double expectedPerimeter = 20;

        double actualPerimeter = square.perimeter();

        assertEquals(expectedPerimeter, actualPerimeter);
    }
}
