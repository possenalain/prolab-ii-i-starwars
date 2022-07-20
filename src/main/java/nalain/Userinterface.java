package nalain;

import nalain.gui.*;
import nalain.karakterler.*;
import nalain.util.Utilities;

import java.awt.event.*;
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
            Utilities.initializeBadCharacters();
            Utilities.initializeGoodCharacter();

        } catch (IOException e) {
        }

        gameWindow = new GameWindow();
        portableGameSetup.setGameWindow(gameWindow);
    }

    public static void main(String args[]) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Userinterface();
            }
        });

    }


}