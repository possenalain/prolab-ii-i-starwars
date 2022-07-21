package nalain.karakterler;
import nalain.maze.Location;
public class MasterYoda extends Karakter {
	public  MasterYoda() {
		this.stepSize=1;
		this.setCan(6);
		this.setName("masteryoda");
		this.setInitialLocation(new Location(4, 5));
		this.setCurrentlocation(getInitialLocation());
	}
}
