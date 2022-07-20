package nalain;

import nalain.gui.*;
import nalain.util.Utilities;

import java.io.IOException;
import javax.swing.*;

public class Userinterface {

    PortableGameSetup portableGameSetup;
    GameWindow gameWindow;
    Userinterface() {

        portableGameSetup = PortableGameSetup.getInstance();

        try {
            Utilities.initializeFromFile();
            Utilities.initializeMazeArray();
            Utilities.initializeGoodCharacter();
            Utilities.initializeBadCharacters();

            gameWindow = new GameWindow();
            portableGameSetup.setGameWindow(gameWindow);
            
        } catch (IOException e) {
        }


    }

    public static void main(String args[]) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Userinterface();
            }
        });

    }


}