package nalain.util;

import nalain.PortableGameSetup;
import nalain.karakterler.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Utilities {

    static ArrayList<String> characters = new ArrayList<String>();
    static ArrayList<String> maze = new ArrayList<String>();

    public static PortableGameSetup portableGameSetup = PortableGameSetup.getInstance();

    public static void isGameOVer() {
        if (portableGameSetup.getIyikarakter().getCurrentlocation().getX() == 13
                && portableGameSetup.getIyikarakter().getCurrentlocation().getY() == 9) {
            portableGameSetup.setGameOver(true);
        }
    }

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
            }
        }
    }

    public static void initializeGoodCharacter() {

        Scanner scan = new Scanner(System.in);
        System.out.println("[skywalker:1] [Master yoda:2]:");
        int choice = scan.nextInt();

        if (choice == 1)
            portableGameSetup.setIyikarakter(new LukeSkyWalker());
        else if (choice == 2)
            portableGameSetup.setIyikarakter(new MasterYoda());

    }

    public static void initializeBadCharacters() {

        for (int i = 0; i < characters.size(); i++) {

            String row = characters.get(i);
            String splittedrow[] = row.split("\\W");

            Karakter karacter = null;

            if (splittedrow[1].equalsIgnoreCase("darthvader"))
                karacter = new Darthvader();

            else if (splittedrow[1].equalsIgnoreCase("Stormtrooper"))
                karacter = new Stormtrooper();

            else if (splittedrow[1].equalsIgnoreCase("Kyloren"))
                karacter = new Kyloren();
            if (karacter != null) {
                karacter.setKapi(splittedrow[3]);
                karacter.setCurrentlocation(portableGameSetup.getLabyrinth().getDoor(splittedrow[3]));
                portableGameSetup.getKotukarakter().add(karacter);
            }
        }
    }

    public static void resetTheGame() {
        for (Karakter karakter : portableGameSetup.getKotukarakter()) {
            karakter.reset();
        }
        portableGameSetup.getIyikarakter().reset();
    }

    public static void yolhesapla() {

        for (Karakter karakter : portableGameSetup.getKotukarakter()) {
            if (karakter.getName().equalsIgnoreCase("darthvader"))
                karakter = (Darthvader) karakter;
            else if (karakter.getName().equalsIgnoreCase("Stormtrooper"))
                karakter = (Stormtrooper) karakter;

            else if (karakter.getName().equalsIgnoreCase("Kyloren"))
                karakter = (Kyloren) karakter;

            karakter.setmazematrix(portableGameSetup.getLabyrinth().mazearray);
            karakter.sethedef(portableGameSetup.getIyikarakter().getCurrentlocation());
            karakter.EnKisaYol();
        }
    }


    public static void moveUp() {
        int x = portableGameSetup.getIyikarakter().getCurrentlocation().getX();
        int y = portableGameSetup.getIyikarakter().getCurrentlocation().getY();
        if (!portableGameSetup.getLabyrinth().isObstacle(x, (y - 1)))
            portableGameSetup.getIyikarakter().getCurrentlocation().setY(y - 1);
    }

    public static void moveDown() {
        int x = portableGameSetup.getIyikarakter().getCurrentlocation().getX();
        int y = portableGameSetup.getIyikarakter().getCurrentlocation().getY();
        if (!portableGameSetup.getLabyrinth().isObstacle(x, (y + 1)))
            portableGameSetup.getIyikarakter().getCurrentlocation().setY(y + 1);
    }

    public static void moveLeft() {
        int y = portableGameSetup.getIyikarakter().getCurrentlocation().getY();
        int x = portableGameSetup.getIyikarakter().getCurrentlocation().getX();
        if (!portableGameSetup.getLabyrinth().isObstacle((x - 1), y))
            portableGameSetup.getIyikarakter().getCurrentlocation().setX(x - 1);
    }

    public static void moveRight() {
        int y = portableGameSetup.getIyikarakter().getCurrentlocation().getY();
        int x = portableGameSetup.getIyikarakter().getCurrentlocation().getX();

        if (!portableGameSetup.getLabyrinth().isObstacle((x + 1), y))
            portableGameSetup.getIyikarakter().getCurrentlocation().setX(x + 1);
    }

    public static void Display() {
        for (Karakter karakter : portableGameSetup.getKotukarakter()) {
            System.out.println(karakter.toString());
        }
    }

}
