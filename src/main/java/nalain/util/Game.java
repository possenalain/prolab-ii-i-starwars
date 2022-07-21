package nalain.util;

import nalain.PortableGameSetup;
import nalain.karakterler.Karakter;

public class Game {

    public static PortableGameSetup portableGameSetup = PortableGameSetup.getInstance();
    public static void resetTheGame() {
        for (Karakter karakter : portableGameSetup.getKotukarakter()) {
            karakter.reset();
        }
        portableGameSetup.getIyikarakter().reset();
    }
    public static void newGame(){}
    public static void newRound() {

    }

}
