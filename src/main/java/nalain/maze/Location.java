package nalain.maze;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter

public class Location implements Comparable<Location> {
    Boolean duvar;
    ArrayList<Location> shortpath;
    int cost;
    private int x;
    private int y;

    public Location() {
        duvar = false;
        cost = 0;
        this.shortpath = new ArrayList<Location>();
    }

    public Location(int x, int y) {
        this.x = x;
        this.y = y;
        this.duvar = false;
        this.shortpath = new ArrayList<Location>();
    }

    @Override
    public int compareTo(Location o) {
        return this.getCost() - o.getCost();
    }

    public void reset() {
        cost = 0;
        this.shortpath = new ArrayList<Location>();
    }

    public boolean isSameAs(Location location) {
        return (this.getX() == location.getX() && this.getY() == location.getY());
    }

    @Override
    public String toString() {
        return "{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
