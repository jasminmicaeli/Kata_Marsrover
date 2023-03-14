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

    public void changeSizeOfPlanet(int width, int height){
        this.widthOfPlanet = width;
        this.heightOfPlanet = height;
    }

    public String getCoordinates() {
        return x_Coordinate + ":" + y_Coordinate + ":" + direction;
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
            case "N" -> {
                y_Coordinate--;
                if(reachedEdge("bottom")) y_Coordinate = heightOfPlanet;
            }
            case "E" -> {
                x_Coordinate--;
                if(reachedEdge("left")) x_Coordinate = widthOfPlanet;
            }
            case "S" -> {
                y_Coordinate++;
                if (reachedEdge("top")) y_Coordinate = 1;
            }
            case "W" -> {
                x_Coordinate++;
                if(reachedEdge("right")) x_Coordinate = 1;
            }
        }
    }

    private void moveForward() {
        switch (direction) {
            case "N" -> {
                y_Coordinate++;
                if(reachedEdge("top")) y_Coordinate = 1;
            }
            case "E" -> {
                x_Coordinate++;
                if(reachedEdge("right")) x_Coordinate = 1;
            }
            case "S" -> {
                y_Coordinate--;
                if(reachedEdge("bottom")) y_Coordinate = heightOfPlanet;
            }
            case "W" -> {
                x_Coordinate--;
                if(reachedEdge("left")) x_Coordinate = widthOfPlanet;
            }
        }
    }

    private boolean reachedEdge(String edge) {
        if          (Objects.equals(edge, "top")    && y_Coordinate > heightOfPlanet)   return true;
        else if     (Objects.equals(edge, "bottom") && y_Coordinate < 1)                return true;
        else if     (Objects.equals(edge, "left")   && x_Coordinate < 1)                return true;
        else return  Objects.equals(edge, "right")  && x_Coordinate > widthOfPlanet;
    }
}