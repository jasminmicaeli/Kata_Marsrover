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
                Arguments.of("3:3:E", "4:3:E"),
                Arguments.of("3:3:S", "3:2:S"),
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

    @ParameterizedTest
    @MethodSource("movingBackwardFacingDifferentDirections")
    public void beAbleToMoveBackward_facingDifferentDirections(String departure, String expected){
        String actual;

        Marsrover marsrover = new Marsrover(departure);
        marsrover.move("B");
        actual = marsrover.getCoordinates();

        assertEquals(expected, actual);
    }

    private static Stream<Arguments>movingBackwardFacingDifferentDirections(){
        return Stream.of(
                Arguments.of("3:3:N", "3:2:N"),
                Arguments.of("3:3:E", "2:3:E"),
                Arguments.of("3:3:S", "3:4:S"),
                Arguments.of("3:3:W", "4:3:W")
        );
    }

    @ParameterizedTest
    @MethodSource("turningLeftFacingDifferentDirections")
    public void beAbleToTurnLeft_shouldChangeDirection(String departure, String expected){
        String actual;

        Marsrover marsrover = new Marsrover(departure);
        marsrover.move("L");
        actual = marsrover.direction;

        assertEquals(expected, actual);
    }

    private static Stream<Arguments>turningLeftFacingDifferentDirections(){
        return Stream.of(
                Arguments.of("2:2:N", "W"),
                Arguments.of("2:2:W", "S"),
                Arguments.of("2:2:S", "E"),
                Arguments.of("2:2:E", "N")
        );
    }


    @ParameterizedTest
    @MethodSource("turningRightFacingDifferentDirections")
    public void beAbleToTurnRight_shouldChangeDirection(String departure, String expected){
        String actual;

        Marsrover marsrover = new Marsrover(departure);
        marsrover.move("R");
        actual = marsrover.direction;

        assertEquals(expected, actual);
    }

    private static Stream<Arguments>turningRightFacingDifferentDirections(){
        return Stream.of(
                Arguments.of("2:2:N", "E"),
                Arguments.of("2:2:W", "N"),
                Arguments.of("2:2:S", "W"),
                Arguments.of("2:2:E", "S")
        );
    }

    @Test
    public void beAbleToHandleEdgeCases_shouldArriveAtBeginningWhenReachedMaxHeight_maxHeightBeing10(){
        int expected_x_coordinate = 5;
        int expected_y_coordinate = 1;
        int actual_x_coordinate;
        int actual_y_coordinate;
        String given= "5:10:N";

        Marsrover marsrover = new Marsrover(given);
        marsrover.move("F");

        actual_x_coordinate = marsrover.x_Coordinate;
        actual_y_coordinate = marsrover.y_Coordinate;

        assertEquals(expected_x_coordinate, actual_x_coordinate);
        assertEquals(expected_y_coordinate, actual_y_coordinate);
    }

    @ParameterizedTest
    @MethodSource("data_testingEdgeCases")
    public void shouldBeAbleToHandleEdgeCases(String coordinates, String command, String expectedFinalLocation){

        Marsrover marsrover = new Marsrover(coordinates);
        marsrover.move(command);
        String actualFinalLocation;

        actualFinalLocation = marsrover.getCoordinates();

        assertEquals(expectedFinalLocation, actualFinalLocation);

    }
    private static Stream<Arguments>data_testingEdgeCases(){
        return Stream.of(
                Arguments.of("10:1:E", "F", "1:1:E"),
                Arguments.of("3:1:S", "F", "3:10:S"),
                Arguments.of("1:1:E", "B", "10:1:E")
        );
    }
}