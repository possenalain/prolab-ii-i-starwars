package nalain.karakterler;

import lombok.Getter;
import lombok.Setter;
import nalain.maze.Location;
@Getter
@Setter
public abstract class Karakter extends CharactersFeatures {
    protected String name;
    protected String type;
    String kapi;
    protected String color;
    protected int can;
    protected int stepSize;
    protected int steps;
    protected Location initialLocation;
    public void reset() {
        this.setCurrentlocation(initialLocation);
    }
    @Override
    public String toString() {

        return "Karakter{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", kapi='" + kapi + '\'' +
                ", currentlocation=" + currentlocation +
                ", color='" + color + '\'' +
                ", can=" + can +
                ", stepSize=" + stepSize +
                ", steps=" + steps +
                ", hedef=" + hedef +
                '}';
    }
    @Override
    protected void log() {
        String message="";
        message+= "name=" + name +
                ", at " + currentlocation +
                ", Target " + hedef +
                ", in  " + calculateSteps() + " steps";
        portableGameSetup.getLogger().log(message);
    }
}

