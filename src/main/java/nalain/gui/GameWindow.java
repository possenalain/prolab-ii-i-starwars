package nalain.gui;

import nalain.PortableGameSetup;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GameWindow extends JFrame {
    PortableGameSetup portableGameSetup = PortableGameSetup.getInstance();
    MazePanel mazepane;
    HealthPanel healthpane;
    LogsPanel logsPanel;

    Keys keysIamListeningTo;

    public GameWindow() {

        this.setTitle("STARWARs");
        this.setSize(800, 800);
        this.setLocation(250, 100);
        this.setLayout(null);
        this.setResizable(false);
        this.toFront();
        this.requestFocus();
        keysIamListeningTo=new Keys();
        this.addKeyListener(keysIamListeningTo);
        Container cont = this.getContentPane();

        mazepane = new MazePanel();
        healthpane = new HealthPanel();
        logsPanel = new LogsPanel();

        cont.add(mazepane);


        cont.setBackground(Color.getHSBColor(74, (float) 0.10, (float) 0.12));
        cont.add(healthpane);
        cont.add(logsPanel);


        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public void repaintWindow() {

        healthpane.repaint();
        logsPanel.refleshLogs();
        mazepane.repaint();
        this.repaint();
    }

    public void removeKeyListeners() {;
        this.removeKeyListener(keysIamListeningTo);
    }
    private class Keys implements KeyListener {
        @Override
        public void keyPressed(KeyEvent evt) {
            switch (evt.getKeyCode()) {
                case KeyEvent.VK_DOWN:
                    portableGameSetup.getIyikarakter().moveDown();
                    break;
                case KeyEvent.VK_UP:
                    portableGameSetup.getIyikarakter().moveUp();
                    break;

                case KeyEvent.VK_LEFT:
                    portableGameSetup.getIyikarakter().moveLeft();
                    break;

                case KeyEvent.VK_RIGHT:
                    portableGameSetup.getIyikarakter().moveRight();
                    break;
            }
            portableGameSetup.moveHunters();
            repaintWindow();
        }

        @Override
        public void keyTyped(KeyEvent e) {
        }

        @Override
        public void keyReleased(KeyEvent e) {
        }
    }
}
