package nalain.maze;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
public class Labyrinth implements Cloneable {
    public int[][] mazearray;
    public Location[][] mazeArrayWithLocations;
    int sizeX;
    int sizeY;
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

    public Location findSignByIconName(String iconName) {
        for (LabyrinthSign sign : labyrinthSigns) {
            if (sign.getIconName().equalsIgnoreCase(iconName)) {
                return sign.getCoordinates();
            }
        }
        return new Location(0, 0);
    }

    public Boolean isObstacle(int x, int y) {
        return mazearray[y][x] != 1;
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
