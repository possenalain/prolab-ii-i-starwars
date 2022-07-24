package nalain.util;

import nalain.PortableGameSetup;
import nalain.karakterler.Karakter;

import java.io.IOException;

public class Game {

    public static PortableGameSetup portableGameSetup;

    public static void resetTheGame() {
        for (Karakter karakter : portableGameSetup.getKotukarakter()) {
            karakter.reset();
        }
        portableGameSetup.getIyikarakter().reset();
    }

    public static void newGame() {

        portableGameSetup = PortableGameSetup.getInstance();
        try {
            Utilities.initializeFromFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Utilities.initializeMazeArray();
        Utilities.initializeGoodCharacter();
        Utilities.initializeBadCharacters();
        Utilities.InitializeGameWindow();

        newRound();
    }

    public static void newRound() {
        if (portableGameSetup.getRound() < portableGameSetup.getIyikarakter().getCan()) {
            portableGameSetup.setRound(portableGameSetup.getRound() + 1);
            resetTheGame();
        } else {
            portableGameSetup.setRound(portableGameSetup.getRound() + 1);
            portableGameSetup.setIsGameOver(true);
            portableGameSetup.getGameWindow().removeKeyListeners();
        }
    }
}
