package nalain.karakterler.bad;

import nalain.karakterler.Karakter;
import nalain.maze.Location;

public class BadCharacter extends Karakter {
    @Override
    public void moveAutomatically() {
        if(this.getEnkisayol().size()>5){
            int size=this.getEnkisayol().size();
            Location lastAdded=this.getEnkisayol().get(size-1);

            if(! lastAdded.isSameAs(portableGameSetup.getIyikarakter().getCurrentlocation()))
            this.getEnkisayol().add(portableGameSetup.getIyikarakter().getCurrentlocation());
            this.aquireTarget();
        }
        else{
            this.aquireTarget();
            this.calculateShortestPath();

        }

        if (!this.getEnkisayol().isEmpty()) {
            int newLocationIndex = 1;
            if (this.getEnkisayol().size() > this.getStepSize()) {
                newLocationIndex = this.getStepSize();
            } else {
                newLocationIndex = this.getEnkisayol().size();
            }
            this.getEnkisayol().subList(0, (newLocationIndex > 0 ? (newLocationIndex - 1) : 0)).clear();
            this.setCurrentlocation(this.getEnkisayol().remove(0));
        }
        this.log();
    }

    @Override
    public void move() {
        this.moveAutomatically();
    }
}
