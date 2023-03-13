import java.util.Objects;

public class Marsrover {

    String latestCoordinates;
    int x_Coordinate;
    int y_Coordinate;
    String direction;
    int widthOfPlanet = 10;
    int heightOfPlanet = 10;

    public Marsrover(String departureCoordinates) {
        this.latestCoordinates = departureCoordinates;
        String[] arrOfSingleDatas = departureCoordinates.split(":");
        x_Coordinate = Integer.parseInt(arrOfSingleDatas[0]);
        y_Coordinate = Integer.parseInt(arrOfSingleDatas[1]);
        direction = arrOfSingleDatas[2];
    }

    public String getCoordinates() {
        return String.valueOf(x_Coordinate) + ":" + String.valueOf(y_Coordinate) + ":" + direction;
    }

    public void move(String command) {
        switch (command) {
            case "F" -> moveForward();
            case "B" -> moveBackwards();
            case "L" -> turnLeft();
            case "R" -> turnRight();
        }
    }

    private void turnRight() {
        switch (direction){
            case "N" -> direction = "E";
            case "E" -> direction = "S";
            case "S" -> direction = "W";
            case "W" -> direction = "N";
        }
    }

    private void turnLeft() {
        switch (direction){
            case "N" -> direction = "W";
            case "E" -> direction = "N";
            case "S" -> direction = "E";
            case "W" -> direction = "S";
        }
    }

    private void moveBackwards() {
        switch (direction) {
            case "N" -> y_Coordinate--;
            case "E" -> x_Coordinate--;
            case "S" -> y_Coordinate++;
            case "W" -> x_Coordinate++;
        }
    }

    private void moveForward() {
        switch (direction) {
            case "N" -> y_Coordinate++;
            case "E" -> x_Coordinate++;
            case "S" -> y_Coordinate--;
            case "W" -> x_Coordinate--;
        }

    }
}