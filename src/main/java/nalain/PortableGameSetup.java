package nalain;

import lombok.Getter;
import lombok.Setter;
import nalain.gui.GameWindow;
import nalain.karakterler.Karakter;
import nalain.karakterler.bad.BadCharacter;
import nalain.karakterler.good.GoodCharacter;
import nalain.maze.Labyrinth;
import nalain.util.Logger;

import java.util.ArrayList;
@Getter
@Setter
public class PortableGameSetup {

    String BASE_PATH_RESOURCES = "./resources/";

    GoodCharacter iyikarakter;
    ArrayList<BadCharacter> kotukarakter;
    Labyrinth labyrinth;
    Boolean isGameOver;
    Logger logger=null;
    GameWindow gameWindow;
    private static PortableGameSetup portableGameSetup = null;
    private PortableGameSetup() {
        kotukarakter = new ArrayList<BadCharacter>();
        labyrinth = new Labyrinth();
        logger.getInstance();
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
    public void moveHunters(){
        for(BadCharacter hunter: this.getKotukarakter())
            hunter.moveAutomatically();
    }
}
