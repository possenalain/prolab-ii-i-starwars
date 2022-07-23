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
    SignsPanel leftindications, rightindications, bottomindications, topindications;
    Toolkit toolkit;

    public GameWindow() {

        this.setTitle("STARWARs");
        this.setSize(800, 800);
        this.setLocation(250, 100);
        this.setLayout(null);
        this.setResizable(false);
        this.toFront();
        this.requestFocus();
        this.addKeyListener(new Keys());

        Container cont = this.getContentPane();

        mazepane = new MazePanel();
        healthpane = new HealthPanel();
        logsPanel = new LogsPanel();

        setupSignsPanel();

        cont.add(mazepane);


        cont.setBackground(Color.getHSBColor(74, (float) 0.10, (float) 0.12));
        cont.add(leftindications);
        cont.add(rightindications);
        cont.add(topindications);
        cont.add(bottomindications);

        cont.add(healthpane);
        cont.add(logsPanel);


        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    private void setupSignsPanel() {

        toolkit = Toolkit.getDefaultToolkit();

        Image left = toolkit.getImage(portableGameSetup.getBASE_PATH_RESOURCES() + "images/left.png");
        Image right = toolkit.getImage(portableGameSetup.getBASE_PATH_RESOURCES() + "images/right.png");
        Image up = toolkit.getImage(portableGameSetup.getBASE_PATH_RESOURCES() + "images/up.png");
        Image down = toolkit.getImage(portableGameSetup.getBASE_PATH_RESOURCES() + "images/down.png");


        leftindications = new SignsPanel(0, 250, right, 0);
        rightindications = new SignsPanel(0, 250, left, 2);
        bottomindications = new SignsPanel(200, 0, up, 0);
        topindications = new SignsPanel(200, 0, down, 1);

        leftindications.setLocation(50, 150);
        rightindications.setLocation(800, 150);
        topindications.setLocation(100, 100);
        bottomindications.setLocation(100, 700);

        leftindications.setSize(50, 550);
        rightindications.setSize(50, 550);
        topindications.setSize(700, 50);
        bottomindications.setSize(700, 50);


    }

    public void repaintWindow() {

        healthpane.repaint();
        logsPanel.refleshLogs();
        mazepane.repaint();
        this.repaint();
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
