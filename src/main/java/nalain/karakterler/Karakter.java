package nalain.karakterler;

import nalain.maze.Location;

import java.util.ArrayList;
import java.util.Arrays;

public class Karakter extends AllCharacters {
    String name;
    String type;
    String kapi;
    String color;
    int can;
    int stepSize;
    int steps;
    Location currentlocation;
    Location hedef;
    ArrayList<Location> enkisayol = new ArrayList();
    ArrayList<Location> visited = new ArrayList();
    ArrayList<Location> visitnext = new ArrayList();

    int mazematrix[][];
    Location locationmatrices[][];
    private Location initialLocation;


    public void setmazematrix(int matrix[][]) {
        mazematrix = new int[11][14];
        this.mazematrix = matrix.clone();
    }

    public void sethedef(Location iyikarakter) {

        this.hedef = iyikarakter;
        this.enkisayol.removeAll(enkisayol);
        this.visitnext.add(this.currentlocation);
        ilocations();
    }


    void ilocations() {
        locationmatrices = new Location[11][14];

        for (int y = 0; y < mazematrix.length; y++) {

            for (int x = 0; x < mazematrix[y].length; x++) {
                Location tempo = new Location(x, y);
                if (mazematrix[y][x] == 0) {
                    tempo.setDuvar(true);
                }
                locationmatrices[y][x] = tempo;
            }
        }

    }

    boolean nodevisited(Location temp) {
        for (int i = 0; i < this.visited.size(); i++) {
            if ((visited.get(i).getX() == temp.getX()) && (visited.get(i).getY() == temp.getY())) {

                return true;
            }
        }

        return false;
    }

    void updatevisitnext(Location temp) {
        //todo
        // use priorityqueue instead of doing it manually
        boolean done = false;

        for (int i = 0; i < visitnext.size(); i++) {
            if (temp.getCost() < visitnext.get(i).getCost()) {
                visitnext.add(i, temp);
                done = true;
                break;
            }
        }
        if (!done) {
            visitnext.add(temp);
        }

    }

    public void EnKisaYol() {

        int hedefx, hedefy;
        hedefx = this.hedef.getX();
        hedefy = this.hedef.getY();


        int x, y;
        Location visiting;

        if (visitnext.size() > 0) {
            visiting = visitnext.get(0);
            x = visiting.getX();
            y = visiting.getY();


            if (hedefx == x && hedefy == y) {

                this.enkisayol = (ArrayList<Location>) visiting.getShortpath().clone();

                visiting.getShortpath().removeAll(enkisayol);
                visitnext.removeAll(visitnext);
                visited.removeAll(visited);

                if (this.enkisayol.size() <= 1) {

                    //either ways destination reached

                    this.currentlocation.setX(hedefx);
                    this.currentlocation.setY(hedefy);


                } else {
                    this.currentlocation.setX(this.enkisayol.get(0).getX());
                    this.currentlocation.setY(this.enkisayol.get(0).getY());
                    this.enkisayol.remove(0);
                }

                return;
            } else {

                visited.add(visiting);
                visitnext.remove(0);


                //visit top

                if (y - 1 >= 0) {
                    if (!nodevisited(locationmatrices[y - 1][x])) {
                        Location tempo = locationmatrices[y - 1][x];

                        if (tempo.getCost() == 0 || (visiting.getCost() <= tempo.getCost() + 1)) {
                            if (!tempo.getDuvar()) {
                                tempo.setCost(visiting.getCost() + 1);
                                tempo.setShortpath((ArrayList<Location>) visiting.getShortpath().clone());////////////
                                tempo.getShortpath().add(tempo);
                                updatevisitnext(tempo);
                                //System.out.println("top visited");
                            }

                        }
                    }

                }

                //visit right

                if (x + 1 <= 13) {
                    if (!nodevisited(locationmatrices[y][x + 1])) {
                        Location tempo = locationmatrices[y][x + 1];

                        if (tempo.getCost() == 0 || (visiting.getCost() <= tempo.getCost() + 1)) {
                            if (!tempo.getDuvar()) {
                                tempo.setCost(visiting.getCost() + 1);
                                tempo.setShortpath((ArrayList<Location>) visiting.getShortpath().clone());////////////
                                tempo.getShortpath().add(tempo);
                                updatevisitnext(tempo);
                                //System.out.println("right visited");
                            }

                        }
                    }

                }

                //visit bottom

                if (y + 1 <= 10) {
                    if (!nodevisited(locationmatrices[y + 1][x])) {
                        Location tempo = locationmatrices[y + 1][x];

                        if (tempo.getCost() == 0 || (visiting.getCost() <= tempo.getCost() + 1)) {
                            if (!tempo.getDuvar()) {
                                tempo.setCost(visiting.getCost() + 1);
                                tempo.setShortpath((ArrayList<Location>) visiting.getShortpath().clone());////////////
                                tempo.getShortpath().add(tempo);
                                updatevisitnext(tempo);
                                //System.out.println("bottom visited");
                            }

                        }
                    }

                }

                //visit left


                if (x - 1 >= 0) {
                    if (!nodevisited(locationmatrices[y][x - 1])) {

                        Location tempo = locationmatrices[y][x - 1];

                        if (tempo.getCost() == 0 || (visiting.getCost() <= tempo.getCost() + 1)) {
                            if (!tempo.getDuvar()) {
                                tempo.setCost(visiting.getCost() + 1);
                                tempo.setShortpath((ArrayList<Location>) visiting.getShortpath().clone());////////////
                                tempo.getShortpath().add(tempo);
                                updatevisitnext(tempo);
                                //System.out.println("left visited");
                            }
                        }
                    }
                }
                EnKisaYol();
            }
        }


    }

    public void visitnextlist() {
        System.out.println("\n-----------------visit next list");
        for (int i = 0; i < visitnext.size(); i++) {
            System.out.println(visitnext.get(i).getX() + "  " + visitnext.get(i).getY());
        }
        System.out.println("\n-----------------");
    }

    public void kisayolugoster() {
        for (int i = 0; i < this.enkisayol.size(); i++) {
            System.out.println(enkisayol.get(i).getX() + "   " + enkisayol.get(i).getY());
        }
    }


    public Karakter() {
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
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

    public ArrayList<Location> getEnkisayol() {
        return enkisayol;
    }

    public void setEnkisayol(ArrayList<Location> enkisayol) {
        this.enkisayol = enkisayol;
    }

    public Location getInitialLocation() {
        return initialLocation;
    }

    public void setInitialLocation(Location initialLocation) {
        this.initialLocation = initialLocation;
    }

    public void reset() {
        this.setCurrentlocation(initialLocation);
        this.enkisayol.clear();
    }



    @Override
    public String toString() {

        return "Karakter{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", kapi='" + kapi + '\'' +
                ", currentlocation=" + currentlocation +
                ", color='" + color + '\'' +
                ", can=" + can +
                ", stepSize=" + stepSize +
                ", steps=" + steps +
                ", visitnext=" + visitnext +
                ", hedef=" + hedef +
                '}';
    }
}

