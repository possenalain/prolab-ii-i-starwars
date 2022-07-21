package nalain;

import lombok.Getter;
import lombok.Setter;
import nalain.gui.GameWindow;
import nalain.karakterler.Karakter;
import nalain.maze.Labyrinth;
import java.util.ArrayList;
@Getter
@Setter
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
    public void repaintGameWindow() {
        gameWindow.repaintWindow();
    }
    public Boolean isGameOver() {
        return getIsGameOver();
    }
}
