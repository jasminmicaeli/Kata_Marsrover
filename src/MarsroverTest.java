import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.rmi.MarshalledObject;
import java.util.stream.Stream;

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

    @Test
    public void beAbleToMoveForward_shouldReturn_1_2_N(){
        String expected = "1:2:N";
        String actual;
        String departure = "1:1:N";

        Marsrover marsrover = new Marsrover(departure);
        marsrover.move("F");
        actual = marsrover.getCoordinates();

        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @MethodSource("movingForwardFacingDifferentDirections")
    public void beAbleToMoveForward_facingDifferentDirections(String departure, String expected){
        String actual;

        Marsrover marsrover = new Marsrover(departure);
        marsrover.move("F");
        actual = marsrover.getCoordinates();

        assertEquals(expected, actual);
    }

    private static Stream<Arguments>movingForwardFacingDifferentDirections(){
        return Stream.of(
                Arguments.of("3:3:N", "3:4:N"),
                Arguments.of("3:3:E", "2:3:E"),
                Arguments.of("3:3:S", "2:3:S"),
                Arguments.of("3:3:W", "2:3:W")
        );
    }


    @Test
    public void beAbleToMoveBackwards_shouldReturn_2_1_N(){
        String expected = "2:1:N";
        String actual;
        String departure = "2:2:N";

        Marsrover marsrover = new Marsrover(departure);
        marsrover.move("B");
        actual = marsrover.getCoordinates();

        assertEquals(expected, actual);
    }

}