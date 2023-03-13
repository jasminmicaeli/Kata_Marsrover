import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MarsroverTest {

    @Test
    public void beAbleToReturnLastCoordinates_shouldReturn_1_1_N(){
        String expected = "1:1:N";
        String actual;
        String departure = "1:1:N";

        Marsrover marsrover = new Marsrover(departure);
        actual = marsrover.getCoordinates();

        assertEquals(expected, actual);
    }

}