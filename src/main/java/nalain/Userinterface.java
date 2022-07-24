package nalain;

import nalain.util.Game;

import javax.swing.*;

public class Userinterface {

    Userinterface() {
        Game.newGame();
    }

    public static void main(String args[]) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Userinterface();
            }
        });
    }
}