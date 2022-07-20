package nalain.maze;
import java.util.ArrayList;

public class Location {
	private int x;
	private int y;
	Boolean duvar;
	ArrayList<Location> shortpath;
	int cost;
	
	public Location() {

		duvar=false;
		cost=0;
		this.shortpath=new ArrayList<Location>();
	}
	public Location(int x, int y) {
		this.x=x;
		this.y=y;
		this.duvar=false;
		this.shortpath=new ArrayList<Location>();
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}

	public Boolean getDuvar() {
		return duvar;
	}
	public void setDuvar(Boolean duvar) {
		this.duvar = duvar;
	}

	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}

	public ArrayList<Location> getShortpath() {
		return shortpath;
	}
	public void setShortpath(ArrayList<Location> shortpath) {
		this.shortpath = shortpath;
	}
}
