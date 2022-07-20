package nalain;

import nalain.gui.*;
import nalain.karakterler.*;
import nalain.maze.*;

import java.awt.event.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.*;
public class Userinterface {
    String BASE_PATH_RESOURCES = "./resources/";
    Karakter iyikarakter;
    ArrayList<String> characters = new ArrayList<String>();
    ArrayList<String> maze = new ArrayList<String>();
    ArrayList<Karakter> kotukarakter = new ArrayList<Karakter>();

    PortableGameSetup portableGameSetup;
    Labyrinth labyrinth;

    Boolean Oyunbitti = false;
    KeyListener keys;
    GameWindow gameWindow;
    Userinterface() {
        try {

            initializeFromFile();
            initializeMazeArray();
            initializeBadCharacters();
            initializeGoodCharacter();


        } catch (IOException e) {
        }

        gameWindow = new GameWindow();
        bindKeylisteners();
    }
    private void bindKeylisteners() {
        KeyListener keys;
        keys = new KeyListener() {

            public void keyPressed(KeyEvent evt) {
                switch (evt.getKeyCode()) {

                    case KeyEvent.VK_DOWN:
                        if (iyikarakter.getCurrentlocation().getY() != 10)
                            moveDown();
                        break;

                    case KeyEvent.VK_UP:
                        if (iyikarakter.getCurrentlocation().getY() != 0)
                            moveUp();
                        break;

                    case KeyEvent.VK_LEFT:
                        if (iyikarakter.getCurrentlocation().getX() != 0)
                            moveLeft();
                        break;

                    case KeyEvent.VK_RIGHT:
                        if (iyikarakter.getCurrentlocation().getX() == 13 && iyikarakter.getCurrentlocation().getY() == 9) {
                            oyunbittimi();
                        }
                        if (iyikarakter.getCurrentlocation().getX() != 13) {
                            moveRight();
                        }
                        break;
                }

                yolhesapla();
                gameWindow.repaintWindow();

            }

            public void keyReleased(KeyEvent e) {
                // TODO  for now it is not needed
            }

            public void keyTyped(KeyEvent e) {
                // not needed
            }
        };
        gameWindow.mazeframe.addKeyListener(keys);
    }
    private void oyunbittimi() {
        if (iyikarakter.getCurrentlocation().getX() == 13 && iyikarakter.getCurrentlocation().getY() == 9) {
            this.Oyunbitti = true;
            gameWindow.repaintWindow();
        }
    }

    public static void main(String args[]) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Userinterface();
            }
        });

    }
    public void initializeFromFile() throws IOException {

        BufferedReader filein = null;
        try {

            filein = new BufferedReader(new FileReader(BASE_PATH_RESOURCES + "Harita.txt"));
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
    private void initializeMazeArray() {

        for (int i = 0; i < maze.size(); i++) {
            String row[] = maze.get(i).split("\\s+");

            for (int j = 0; j < row.length; j++) {
                labyrinth.mazearray[i][j] = Integer.valueOf(row[j]);

            }
        }
    }
    private void initializeGoodCharacter() {

        Scanner scan = new Scanner(System.in);
        System.out.println("[skywalker:1] [Master yoda:2]:");
        int choice = scan.nextInt();

        if (choice == 1)
            iyikarakter = new LukeSkyWalker();
        else if (choice == 2)
            iyikarakter = new MasterYoda();

    }
    private void initializeBadCharacters() {

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
                karacter.setCurrentlocation(labyrinth.getDoor(splittedrow[3]));
                kotukarakter.add(karacter);
            }
        }
    }

    public void resetTheGame() {
        for (Karakter karakter : kotukarakter) {
            karakter.reset();
        }

        iyikarakter.reset();
        gameWindow.repaintWindow();
    }
    private void yolhesapla() {

        for (Karakter karakter : kotukarakter) {

            if (karakter.getName().equalsIgnoreCase("darthvader"))
                karakter = (Darthvader) karakter;
            else if (karakter.getName().equalsIgnoreCase("Stormtrooper"))
                karakter = (Stormtrooper) karakter;

            else if (karakter.getName().equalsIgnoreCase("Kyloren"))
                karakter = (Kyloren) karakter;

            karakter.setmazematrix(labyrinth.mazearray);
            karakter.sethedef(iyikarakter.getCurrentlocation());
            karakter.EnKisaYol();
        }
    }
    private void moveUp() {


        int x = iyikarakter.getCurrentlocation().getX();
        int y = iyikarakter.getCurrentlocation().getY();
        if (!labyrinth.isObstacle(x, (y - 1)))
            iyikarakter.getCurrentlocation().setY(y - 1);
    }
    private void moveDown() {
        int x = iyikarakter.getCurrentlocation().getX();
        int y = iyikarakter.getCurrentlocation().getY();
        if (!labyrinth.isObstacle(x, (y + 1)))
            iyikarakter.getCurrentlocation().setY(y + 1);
    }
    private void moveLeft() {
        int y = iyikarakter.getCurrentlocation().getY();
        int x = iyikarakter.getCurrentlocation().getX();
        if (!labyrinth.isObstacle((x - 1), y))
            iyikarakter.getCurrentlocation().setX(x - 1);
    }
    private void moveRight() {

        int y = iyikarakter.getCurrentlocation().getY();
        int x = iyikarakter.getCurrentlocation().getX();

        if (!labyrinth.isObstacle((x + 1), y))
            iyikarakter.getCurrentlocation().setX(x + 1);
    }
    public void Display() {

        for (Karakter karakter : kotukarakter) {
            System.out.println(karakter.toString());
        }
    }

}