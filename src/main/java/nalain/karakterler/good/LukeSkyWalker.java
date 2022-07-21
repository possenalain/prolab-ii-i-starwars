package nalain.karakterler.good;

import nalain.karakterler.Karakter;
import nalain.maze.Location;

import java.util.ArrayList;

public class LukeSkyWalker extends GoodCharacter {
	public LukeSkyWalker() {
		this.can = 3;
		this.name = "sky";
		this.setInitialLocation(new Location(4, 5));
		this.setCurrentlocation(getInitialLocation());
		this.enkisayol = new ArrayList<>();
	}

	public void reset() {
		this.setCurrentlocation(this.getInitialLocation());
		//mode auto play he will continuously get a safer way
		//this.enkisayol.clear();
	}

}
