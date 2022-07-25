package nalain.karakterler.good;

import nalain.karakterler.Karakter;

public class GoodCharacter extends Karakter {

    @Override
    public void aquireTarget() {
    }

    @Override
    protected void moveAutomatically() {
        //TODO move according to the step size
        this.aquireTarget();
        this.calculateShortestPath();

        if (!this.getEnkisayol().isEmpty())
            this.setCurrentlocation(this.getEnkisayol().remove(0));
        this.log();
    }

    @Override
    public void move() {
        this.moveAutomatically();
        if (destinationReached()) {
            //TODO game is over initilize a new game
            // new game not round
            portableGameSetup.setIsGameOver(true);
        }
    }

    protected void moveInDirection(int direction) {


        int[] directionX = {0, 1, 0, -1};
        int[] directionY = {-1, 0, 1, 0};

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

        if (destinationReached()) {
            //TODO game is over initilize a new game
            // new game not round
            portableGameSetup.setIsGameOver(true);
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
