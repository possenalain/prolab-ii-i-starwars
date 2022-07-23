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
    String kapi;
    protected String color;
    protected int can;
    protected int stepSize;
    protected int steps;
    protected Location initialLocation;
    protected Location currentlocation;
    protected Location hedef;


    protected PortableGameSetup portableGameSetup = PortableGameSetup.getInstance();
    protected ArrayList<Location> enkisayol = new ArrayList<>();

    protected abstract void aquireTarget();

    protected abstract int calculateSteps();

    protected abstract void calculateShortestPath();

    protected abstract void moveAutomatically();

    protected abstract void move();

    protected abstract void moveTo(Location location);

    protected abstract void reset();

    public abstract String toString();

    protected abstract void log();
}