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
        this.enkisayol.clear();
        this.aquireTarget();
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
}

