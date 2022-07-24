package nalain.karakterler.bad;

import nalain.karakterler.Karakter;

public class BadCharacter extends Karakter {
    @Override
    public void moveAutomatically() {
        this.aquireTarget();
        this.calculateShortestPath();

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
