package nalain.karakterler;

import nalain.maze.Location;

public class LukeSkyWalker extends Karakter{
	public  LukeSkyWalker() {
		this.can=3;
		this.name="sky";
		this.setInitialLocation(new Location(4, 5));
		this.setCurrentlocation(getInitialLocation());

	}

}
