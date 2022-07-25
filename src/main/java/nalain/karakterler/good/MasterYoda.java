package nalain.karakterler.good;

import nalain.maze.Location;

import java.util.ArrayList;

public class MasterYoda extends GoodCharacter {
    public MasterYoda() {

        this.setStepSize(1);
        this.setCan(6);
        this.setName("masteryoda");
        this.setInitialLocation(portableGameSetup.getLabyrinth().getCenter());
        this.setCurrentlocation(getInitialLocation());
        this.setHedef(portableGameSetup.getLabyrinth().findSignByIconName("trophy"));
        this.enkisayol = new ArrayList<>();

    }

    public void reset() {
        this.setCurrentlocation(this.getInitialLocation());
        //mode auto play he will continuously get a safer way
        //this.enkisayol.clear();
    }

}
