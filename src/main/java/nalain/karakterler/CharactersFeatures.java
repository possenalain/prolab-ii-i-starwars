package nalain.karakterler;
import lombok.Getter;
import lombok.Setter;
import nalain.PortableGameSetup;
import nalain.maze.Location;
import nalain.util.Algorithms;

import java.util.ArrayList;

@Getter
@Setter

public abstract class CharactersFeatures {

    protected PortableGameSetup portableGameSetup = PortableGameSetup.getInstance();
    protected ArrayList<Location> enkisayol=new ArrayList<>();
    protected  Location currentlocation;
    protected Location hedef;

    protected void calculateShortestPath() {
        this.currentlocation.reset();
        this.hedef.reset();
        portableGameSetup.getLabyrinth().resetLocationCosts();
        this.enkisayol = Algorithms.getShortestPathTo(this.currentlocation, this.hedef);
    }
    public void logShortestPath() {
        System.out.println("-------------------------");
        for (int i = 0; i < this.enkisayol.size(); i++) {
            System.out.println(enkisayol.get(i).getX() + "   " + enkisayol.get(i).getY());
        }
    }

    public void aquireTarget() {
        if (portableGameSetup.getIyikarakter() != null)
            this.setHedef(portableGameSetup.getIyikarakter().getCurrentlocation());
    }

    protected  abstract void moveAutomatically();
    protected abstract void move();
    protected abstract  void moveTo(Location location);
    protected abstract void log();
    protected int calculateSteps() {

        //TODO add implementatioon

        return 0;
    }
}
