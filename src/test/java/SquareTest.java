import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SquareTest {

    @Test
    public void shouldReturnAreaOneForUnitSides() {
        Square square = new Square();
        double expectedArea = 1;

        double actualArea = square.area();

        assertEquals(expectedArea, actualArea);


    }


}
