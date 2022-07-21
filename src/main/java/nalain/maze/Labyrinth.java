package nalain.maze;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Labyrinth implements Cloneable {
    int sizeX;
    int sizeY;
    public int[][] mazearray;
    public Location[][] mazeArrayWithLocations;

    public Labyrinth() {
        this.sizeY = 11;
        this.sizeX = 14;
        this.mazearray = new int[sizeY][sizeX];
        mazeArrayWithLocations = new Location[sizeY][sizeX];
    }
    public Labyrinth(int x, int y) {
        this.sizeX = x;
        this.sizeY = y;
        this.mazearray = new int[sizeY][sizeX];
        mazeArrayWithLocations = new Location[sizeY][sizeX];
    }

    public Location getDoor(String door) {

        int doorsX[] = {0, 4, 12, 13, 4};
        int doorsY[] = {5, 0, 0, 5, 10};

        if (door.equalsIgnoreCase("A"))
            return new Location(doorsX[0], doorsY[0]);

        else if (door.equalsIgnoreCase("B"))
            return new Location(doorsX[1], doorsY[1]);

        else if (door.equalsIgnoreCase("C"))
            return new Location(doorsX[2], doorsY[2]);

        else if (door.equalsIgnoreCase("D"))
            return new Location(doorsX[3], doorsY[3]);

        else if (door.equalsIgnoreCase("E"))
            return new Location(doorsX[4], doorsY[4]);

        return null;
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

        for(int y=0;y<mazeArrayWithLocations.length;y++) {
            for(Location location : mazeArrayWithLocations[y]) {
            location.reset();
            }
        }
    }
}
