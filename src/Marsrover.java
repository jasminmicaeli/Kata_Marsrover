public class Marsrover {

    String latestCoordinates;
    int x_Coordinate;
    int y_Coordinate;

    public Marsrover(String departureCoordinates) {
        this.latestCoordinates = departureCoordinates;
    }

    public String getCoordinates() {
        return latestCoordinates;
    }
}
