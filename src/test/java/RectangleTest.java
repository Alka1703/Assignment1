import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
        Rectangle rectangle = new Rectangle(10, 3);
        double expectedArea = 30;

        double actualArea = rectangle.area();

        assertEquals(expectedArea, actualArea);
    }
}