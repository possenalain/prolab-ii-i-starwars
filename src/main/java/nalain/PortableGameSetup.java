package nalain;

import nalain.gui.GameWindow;
import nalain.karakterler.Karakter;
import nalain.maze.Labyrinth;

import java.util.ArrayList;

public class PortableGameSetup {
    String BASE_PATH_RESOURCES = "./resources/";
    Karakter iyikarakter;
    ArrayList<Karakter> kotukarakter;
    Labyrinth labyrinth;
    Boolean isGameOver;
    GameWindow gameWindow;

    private static PortableGameSetup portableGameSetup = null;

    private PortableGameSetup() {
        kotukarakter = new ArrayList<Karakter>();
        labyrinth = new Labyrinth();
        isGameOver = false;
    }

    public static PortableGameSetup getInstance() {
        if (portableGameSetup == null) {
            portableGameSetup = new PortableGameSetup();
        }
        return portableGameSetup;
    }

    public void repaintGameWindow(){
        gameWindow.repaintWindow();
    }
    public Karakter getIyikarakter() {
        return iyikarakter;
    }
    public void setIyikarakter(Karakter iyikarakter) {
        this.iyikarakter = iyikarakter;
    }

    public ArrayList<Karakter> getKotukarakter() {
        return kotukarakter;
    }

    public void setKotukarakter(ArrayList<Karakter> kotukarakter) {
        this.kotukarakter = kotukarakter;
    }

    public GameWindow getGameWindow() {
        return gameWindow;
    }

    public void setGameWindow(GameWindow gameWindow) {
        this.gameWindow = gameWindow;
    }

    public Labyrinth getLabyrinth() {
        return labyrinth;
    }

    public void setLabyrinth(Labyrinth labyrinth) {
        this.labyrinth = labyrinth;
    }

    public String getBASE_PATH_RESOURCES() {
        return BASE_PATH_RESOURCES;
    }

    public void setBASE_PATH_RESOURCES(String BASE_PATH_RESOURCES) {
        this.BASE_PATH_RESOURCES = BASE_PATH_RESOURCES;
    }

    public static PortableGameSetup getPortableGameSetup() {
        return portableGameSetup;
    }

    public static void setPortableGameSetup(PortableGameSetup portableGameSetup) {
        PortableGameSetup.portableGameSetup = portableGameSetup;
    }

    public Boolean isGameOver() {
        return isGameOver;
    }

    public void setGameOver(Boolean gameOver) {
        isGameOver = gameOver;
    }


}
