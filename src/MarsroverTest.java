import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MarsroverTest {

    @Test
    public void beAbleToReturnLastCoordinates_shouldReturn_1_1_N(){
        String expected = "1:1:N";
        String actual;

        Marsrover marsrover = new Marsrover();
        actual = marsrover.getCoordinates();

        assertEquals(expected, actual);
    }

}