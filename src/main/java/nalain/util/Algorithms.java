package nalain.util;

import nalain.PortableGameSetup;
import nalain.maze.Labyrinth;
import nalain.maze.Location;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class Algorithms {
    static PortableGameSetup portableGameSetup = PortableGameSetup.getInstance();

    public static ArrayList<Location> getShortestPathTo(Location from, Location destination) {
        return DiJkStra(from, destination);
    }

    public static ArrayList<Location> DiJkStra(Location from, Location destination) {

        ArrayList<Location> shortestPath = new ArrayList();


        Labyrinth labyrinthClone = null;

        try {
            labyrinthClone = (Labyrinth) portableGameSetup.getLabyrinth().clone();
        } catch (CloneNotSupportedException e) {
            System.out.println("couldn't clone labyrith");
            throw new RuntimeException(e);
        }

        boolean[][] visited = new boolean[labyrinthClone.getSizeY()][labyrinthClone.getSizeX()];

        Location visiting;

        PriorityQueue<Location> visitNext = new PriorityQueue<Location>();


        int[] directionX = {0, 1, 0, -1};
        int[] directionY = {-1, 0, 1, 0};

        visitNext.offer(from);

        while (!visitNext.isEmpty()) {

            visiting = visitNext.poll();

            int currentX = visiting.getX();
            int currentY = visiting.getY();

            if (currentX == destination.getX() && currentY == destination.getY()) {
                shortestPath = (ArrayList<Location>) visiting.getShortpath().clone();
                visiting.getShortpath().removeAll(visiting.getShortpath());

                visitNext.removeAll(visitNext);

                return shortestPath;
            } else {
                visited[currentY][currentX] = true;

                for (int d = 0; d < directionX.length; d++) {

                    int newY = currentY + directionY[d];
                    int newX = currentX + directionX[d];

                    if (newX >= 0
                            && newX < labyrinthClone.getSizeX()
                            && newY >= 0
                            && newY < labyrinthClone.getSizeY()
                    ) {
                        // if not visited add it to visit next
                        if (!visited[newY][newX]) {
                            Location neighbour = labyrinthClone.getMazeArrayWithLocations()[newY][newX];
                            if (neighbour.getCost() == 0 || (visiting.getCost() <= neighbour.getCost() + 1)) {
                                if (!neighbour.getDuvar()) {
                                    neighbour.setCost(visiting.getCost() + 1);
                                    neighbour.setShortpath((ArrayList<Location>) visiting.getShortpath().clone());
                                    neighbour.getShortpath().add(neighbour);
                                    visitNext.offer(neighbour);
                                }
                            }
                        }
                    }
                }
            }
        }
        return shortestPath;
    }

    public static ArrayList<Location> BFS(Location from, Location destination) {
        return null;
    }

    public static ArrayList<Location> DFS(Location from, Location destination) {
        return null;
    }
}
