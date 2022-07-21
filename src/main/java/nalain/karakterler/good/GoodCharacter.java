package nalain.karakterler.good;

import nalain.karakterler.Karakter;
import nalain.maze.Location;

public class GoodCharacter extends Karakter {
    @Override
    protected void moveAutomatically() {

        this.calculateShortestPath();
    }
    @Override
    protected void move() {
        this.calculateShortestPath();
    }
    @Override
    protected void moveTo(Location location) {
        this.calculateShortestPath();
    }
    protected void moveInDirection(int direction) {


        int directionX[] = {0, 1, 0, -1};
        int directionY[] = {-1, 0, 1, 0};

        int newY = this.getCurrentlocation().getY() + directionY[direction];
        int newX = this.getCurrentlocation().getX() + directionX[direction];

        if (newX >= 0
                && newX < portableGameSetup.getLabyrinth().getSizeX()
                && newY >= 0
                && newY < portableGameSetup.getLabyrinth().getSizeY()
        ) {

            if (!portableGameSetup.getLabyrinth().isObstacle(newX, newY)) {
                this.setCurrentlocation(portableGameSetup.getLabyrinth().mazeArrayWithLocations[newY][newX]);
            }
        }
    }
    public void moveUp() {
        moveInDirection(0);
    }
    public void moveRight() {
        moveInDirection(1);
    }
    public void moveDown() {
        moveInDirection(2);
    }
    public void moveLeft() {
        moveInDirection(3);
    }
}
