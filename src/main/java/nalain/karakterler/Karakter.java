package nalain.karakterler;

import lombok.Getter;
import lombok.Setter;
import nalain.maze.Location;
import nalain.util.Algorithms;

@Getter
@Setter
public abstract class Karakter extends CharacterWithFeatures {
    public void aquireTarget() {
        if (portableGameSetup.getIyikarakter() != null)
            this.setHedef(portableGameSetup.getIyikarakter().getCurrentlocation());
    }
    protected int calculateSteps() {
        //TODO
        // add implementatioon how many steps to target
        return 0;
    }
    protected void calculateShortestPath() {
        this.currentlocation.reset();
        this.hedef.reset();
        portableGameSetup.getLabyrinth().resetLocationCosts();
        this.enkisayol = Algorithms.getShortestPathTo(this.currentlocation, this.hedef);
    }
    protected void moveTo(Location location) {
        this.setCurrentlocation(location);
        this.aquireTarget();
        this.calculateShortestPath();
        this.log();
    }

    public void reset() {
        this.setCurrentlocation(initialLocation);
    }
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
    protected void log() {
        String message = "";
        message += "name=" + name +
                ", at " + currentlocation +
                ", Target " + hedef +
                ", in  " + calculateSteps() + " steps";
        portableGameSetup.getLogger().addLog(message);
    }

}

