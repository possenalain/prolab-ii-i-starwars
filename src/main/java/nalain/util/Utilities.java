package nalain.util;

import nalain.PortableGameSetup;
import nalain.gui.GameWindow;
import nalain.karakterler.Karakter;
import nalain.karakterler.bad.BadCharacter;
import nalain.karakterler.bad.Darthvader;
import nalain.karakterler.bad.Kyloren;
import nalain.karakterler.bad.Stormtrooper;
import nalain.karakterler.good.LukeSkyWalker;
import nalain.karakterler.good.MasterYoda;
import nalain.maze.Location;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Utilities {

    public static PortableGameSetup portableGameSetup = PortableGameSetup.getInstance();
    static ArrayList<String> characters = new ArrayList<String>();
    static ArrayList<String> maze = new ArrayList<String>();
    public static void initializeFromFile() throws IOException {
        BufferedReader filein = null;
        try {
            filein = new BufferedReader(new FileReader(portableGameSetup.getBASE_PATH_RESOURCES() + "Harita.txt"));
            String row;
            while ((row = (String) filein.readLine()) != null) {

                if (row.startsWith("Karakter")) {
                    characters.add(row);
                } else if (row.startsWith("0") || row.startsWith("1")) {
                    maze.add(row);
                } else {
                    System.out.println("the row doesn't follow requested pattern");
                }
            }
        } catch (IOException e) {

            System.err.println("unable to read the document");

        }

        filein.close();
    }
    public static void initializeMazeArray() {
        for (int i = 0; i < maze.size(); i++) {
            String row[] = maze.get(i).split("\\s+");
            for (int j = 0; j < row.length; j++) {
                portableGameSetup.getLabyrinth().mazearray[i][j] = Integer.valueOf(row[j]);
                Location loc = new Location(j, i);
                if (Integer.valueOf(row[j]) == 0)
                    loc.setDuvar(true);
                portableGameSetup.getLabyrinth().mazeArrayWithLocations[i][j] = loc;
            }
        }
    }

    public static void initializeGoodCharacter() {

        Scanner scan = new Scanner(System.in);
        System.out.println("[skywalker:1] [Master yoda:2]:");

        int choice = scan.nextInt();
        ;

        if (choice == 1)
            portableGameSetup.setIyikarakter(new LukeSkyWalker());
        else if (choice == 2)
            portableGameSetup.setIyikarakter(new MasterYoda());

    }

    public static void initializeBadCharacters() {

        for (int i = 0; i < characters.size(); i++) {

            String row = characters.get(i);
            String splittedrow[] = row.split("\\W");

            BadCharacter karacter = null;
            if (splittedrow[1].equalsIgnoreCase("darthvader"))
                karacter = new Darthvader();

            else if (splittedrow[1].equalsIgnoreCase("Stormtrooper"))
                karacter = new Stormtrooper();

            else if (splittedrow[1].equalsIgnoreCase("Kyloren"))
                karacter = new Kyloren();

            if (karacter != null) {
                karacter.setKapi(splittedrow[3]);
                karacter.setInitialLocation(portableGameSetup.getLabyrinth().getDoor(splittedrow[3]));
                karacter.setCurrentlocation(karacter.getInitialLocation());
                portableGameSetup.getKotukarakter().add(karacter);
            }
        }
    }

    public static void InitializeGameWindow() {
        GameWindow gameWindow = new GameWindow();
        portableGameSetup.setGameWindow(gameWindow);
    }

}