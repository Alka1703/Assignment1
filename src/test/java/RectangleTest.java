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
}