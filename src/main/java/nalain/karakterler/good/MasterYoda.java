package nalain.karakterler.good;
import nalain.maze.Location;
public class MasterYoda extends GoodCharacter {
	public  MasterYoda() {

		this.setStepSize(1);
		this.setCan(6);
		this.setName("masteryoda");
		this.setInitialLocation(new Location(4, 5));
		this.setCurrentlocation(getInitialLocation());
	}

	public void reset() {
		this.setCurrentlocation(this.getInitialLocation());
		//mode auto play he will continuously get a safer way
		//this.enkisayol.clear();
	}

}
