package nalain;

import lombok.Getter;
import lombok.Setter;
import nalain.gui.GameWindow;
import nalain.karakterler.Karakter;
import nalain.karakterler.good.GoodCharacter;
import nalain.maze.Labyrinth;
import nalain.util.Game;
import nalain.util.Logger;

import java.util.ArrayList;

@Getter
@Setter
public class PortableGameSetup {

    private static PortableGameSetup portableGameSetup = null;
    String BASE_PATH_RESOURCES = "./resources/";
    GoodCharacter iyikarakter;
    ArrayList<Karakter> kotukarakter;
    Labyrinth labyrinth;
    Integer round = 0;
    Boolean isGameOver;
    Logger logger = null;
    GameWindow gameWindow;

    private PortableGameSetup() {
        kotukarakter = new ArrayList<Karakter>();
        logger = Logger.getInstance();
        isGameOver = false;
    }

    public static PortableGameSetup getInstance() {
        if (portableGameSetup == null) {
            portableGameSetup = new PortableGameSetup();
        }
        return portableGameSetup;
    }

    public Boolean isGameOver() {
        return getIsGameOver();
    }

    public void moveHunters() {
        for (Karakter hunter : this.getKotukarakter()) {
            hunter.move();
            if (hunter.destinationReached()) {
                portableGameSetup.getLogger().addLog("\n\n " + hunter.getName() + " wins--");
                Game.newRound();
                break;
            }
        }

    }
}
