package nalain.gui;

import nalain.PortableGameSetup;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GameWindow extends JFrame {
    PortableGameSetup portableGameSetup = PortableGameSetup.getInstance();
    MazePanel mazePanel;
    HealthPanel healthPanel;
    LogsPanel logsPanel;
    Keys keysIamListeningTo;

    public GameWindow() {

        this.setTitle("STARWARs");
        this.setSize(660, 800);
        this.setResizable(false);
        this.setLayout(new BorderLayout());
        this.setBackground(new Color(2, 3, 0));
        keysIamListeningTo = new Keys();
        this.addKeyListener(keysIamListeningTo);
        Container cont = this.getContentPane();


        mazePanel = new MazePanel(this);
        healthPanel = new HealthPanel();
        logsPanel = new LogsPanel();

        cont.setLayout(new BorderLayout());

        cont.setBackground(Color.getHSBColor(74, (float) 0.10, (float) 0.12));

        cont.add(healthPanel, BorderLayout.NORTH);
        cont.add(mazePanel, BorderLayout.CENTER);
        cont.add(logsPanel, BorderLayout.SOUTH);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public void repaintWindow() {

        healthPanel.repaint();
        logsPanel.refleshLogs();
        mazePanel.repaint();
        this.repaint();
    }

    public void removeKeyListeners() {
        this.removeKeyListener(keysIamListeningTo);
    }

    private class Keys implements KeyListener {
        @Override
        public void keyPressed(KeyEvent evt) {

            if (portableGameSetup.isGameOver())
                return;

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
