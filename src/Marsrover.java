public class Marsrover {

    String latestCoordinates;
    int x_Coordinate;
    int y_Coordinate;

    public Marsrover(String departureCoordinates) {
        this.latestCoordinates = departureCoordinates;
        String[] arrOfSingleDatas = departureCoordinates.split(":");
        x_Coordinate = Integer.parseInt(arrOfSingleDatas[0]);
        y_Coordinate = Integer.parseInt(arrOfSingleDatas[1]);
    }

    public String getCoordinates() {
        return latestCoordinates;
    }

    public void move(String command) {
        if(command == "F"){
            y_Coordinate ++;
        }
    }
}
