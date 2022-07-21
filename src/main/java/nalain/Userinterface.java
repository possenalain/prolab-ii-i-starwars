package nalain;

import nalain.util.Utilities;

import javax.swing.*;
import java.io.IOException;
public class Userinterface {
    PortableGameSetup portableGameSetup;
    Userinterface() {
        portableGameSetup = PortableGameSetup.getInstance();
        try {
            Utilities.initializeFromFile();
            Utilities.initializeMazeArray();
            Utilities.initializeGoodCharacter();
            Utilities.initializeBadCharacters();
            Utilities.InitializeGameWindow();
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