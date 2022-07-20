package nalain.maze;

public class Labyrinth {

    int sizeX=11;
    int sizeY=14;

    public Labyrinth(int x, int y){
        this.sizeX=x;
        this.sizeY=y;
    }
    public int[][] mazearray;
    Labyrinth(){
        this.mazearray= new int[11][14];
    }

    public Location getDoor(String door) {

        int doorsX[]={0,4,12,13,4};
        int doorsY[]={5,0,0,5,10};

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
}
