package nalain.karakterler.bad;

import nalain.karakterler.Karakter;
import nalain.maze.Location;

public class BadCharacter extends Karakter {
    @Override
    public void moveAutomatically() {
        //TODO move according to the step size

        this.aquireTarget();
        this.calculateShortestPath();

        if (!this.getEnkisayol().isEmpty())
            this.setCurrentlocation(this.getEnkisayol().remove(0));
        this.log();
    }
    @Override
    protected void moveTo(Location location) {

        this.aquireTarget();
        this.calculateShortestPath();
        this.logShortestPath();
    }

    @Override
    public void move() {
        //could recieive comands from outside

        this.aquireTarget();
        this.calculateShortestPath();
        this.logShortestPath();
    }
}
