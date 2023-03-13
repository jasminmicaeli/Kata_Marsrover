public class Marsrover {

    String latestCoordinates;
    int x_Coordinate;
    int y_Coordinate;
    String direction;

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
        if(command == "F"){
            y_Coordinate ++;
        }
    }
}
