package nalain.maze;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
public class Labyrinth implements Cloneable {
    int sizeX;
    int sizeY;
    public int[][] mazearray;
    public Location[][] mazeArrayWithLocations;
    ArrayList<LabyrinthSign> labyrinthSigns;


    public Labyrinth(int x, int y) {
        this.sizeX = x;
        this.sizeY = y;
        this.mazearray = new int[sizeY][sizeX];
        mazeArrayWithLocations = new Location[sizeY][sizeX];
        labyrinthSigns = new ArrayList<>();
    }

    public Labyrinth() {
        this(14, 11);
    }

    public Location findSignByName(String name) {

        for (LabyrinthSign sign : labyrinthSigns) {
            if (sign.getName().equalsIgnoreCase(name)) {
                return sign.getCoordinates();
            }
        }
        return new Location(0, 0);
    }

    public Boolean isObstacle(int x, int y) {
        if (mazearray[y][x] == 1) {
            return false;
        }

        return true;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public void resetLocationCosts() {

        for (int y = 0; y < mazeArrayWithLocations.length; y++) {
            for (Location location : mazeArrayWithLocations[y]) {
                location.reset();
            }
        }
    }

}
