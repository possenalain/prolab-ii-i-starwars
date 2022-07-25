package nalain.karakterler;

import lombok.Getter;
import lombok.Setter;
import nalain.PortableGameSetup;
import nalain.maze.Location;

import java.util.ArrayList;

@Getter
@Setter

public abstract class CharacterWithFeatures {
    protected String name;
    protected String type;
    protected String color = "";
    protected int can;
    protected int stepSize;
    protected Location initialLocation;
    protected Location currentlocation;
    protected Location hedef;
    protected PortableGameSetup portableGameSetup = PortableGameSetup.getInstance();
    protected ArrayList<Location> enkisayol = new ArrayList<>();
    String entrance;

    protected abstract void aquireTarget();

    protected abstract int calculateSteps();

    protected abstract void calculateShortestPath();

    protected abstract void moveAutomatically();

    public abstract void move();

    protected abstract boolean destinationReached();

    protected abstract void moveTo(Location location);

    protected abstract void reset();

    public abstract String toString();

    protected abstract void log();
}
