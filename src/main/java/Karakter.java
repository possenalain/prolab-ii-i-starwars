
import java.util.ArrayList;

public class Karakter {
    String name;
    String type;
    String kapi;
    Location currentlocation;
    String color;
    int can;

    ArrayList<Location> enkisayol=new ArrayList();
    int steps;

    public Karakter() {

    }

    public String getKapi() {
        return kapi;
    }

    public void setKapi(String kapi) {
        this.kapi = kapi;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Location getCurrentlocation() {
        return currentlocation;
    }

    public void setCurrentlocation(Location currentlocation) {
        this.currentlocation = currentlocation;
    }

    public int getSteps() {
        return steps;
    }

    public void setSteps(int steps) {
        this.steps = steps;
    }

    public int getCan() {
        return can;
    }

    public void setCan(int can) {
        this.can = can;
    }

}

