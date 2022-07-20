package nalain.gui;

import nalain.PortableGameSetup;
import nalain.util.Utilities;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GameWindow {

    PortableGameSetup portableGameSetup=PortableGameSetup.getInstance();
    JPanel mazepane;
    public JFrame mazeframe;
    HealthPanel healthpane;
    ConsolePanel pathpane;
    SignsPanel leftindications,rightindications,bottomindications,topindications ;
    Toolkit toolkit ;
    public GameWindow(){

        mazeframe = new JFrame();
        mazeframe.setTitle("STARWARs");
        mazeframe.setSize(900, 900);
        mazeframe.setLocation(250, 100);
        mazeframe.setLayout(null);
        mazeframe.setResizable(false);
        mazeframe.toFront();
        mazeframe.requestFocus();

        Container cont = mazeframe.getContentPane();

        mazepane = new MazePanel();

        healthpane = new HealthPanel();

        healthpane.setBackground(Color.black);
        pathpane = new ConsolePanel();
        pathpane.setBackground(Color.getHSBColor(112, (float) 0.38, (float) 0.12));

        mazepane.setLocation(100, 150);
        mazepane.setSize(700, 550);
        mazepane.setBackground(Color.white);

        healthpane.setSize(300, 50);
        pathpane.setSize(500, 100);

        healthpane.setLocation(550, 25);
        pathpane.setLocation(100, 750);

        setupSignsPanel();

        cont.add(mazepane);
        cont.setBackground(Color.getHSBColor(74, (float) 0.10, (float) 0.12));
        cont.add(leftindications);
        cont.add(rightindications);
        cont.add(topindications);
        cont.add(bottomindications);
        cont.add(healthpane);
        cont.add(pathpane);

        mazeframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mazeframe.setVisible(true);
    }

    private void setupSignsPanel(){

        toolkit = Toolkit.getDefaultToolkit();

        Image left = toolkit.getImage(portableGameSetup.getBASE_PATH_RESOURCES()+ "images/left.png");
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

        bindKeylisteners();
    }
    private void bindKeylisteners() {
        KeyListener keys;

        GameWindow gameWindow=this;
        keys = new KeyListener() {

            public void keyPressed(KeyEvent evt) {
                switch (evt.getKeyCode()) {

                    case KeyEvent.VK_DOWN:
                        if (portableGameSetup.getIyikarakter().getCurrentlocation().getY() != 10)
                            Utilities.moveDown();
                        break;

                    case KeyEvent.VK_UP:
                        if (portableGameSetup.getIyikarakter().getCurrentlocation().getY() != 0)
                            Utilities.moveUp();
                        break;

                    case KeyEvent.VK_LEFT:
                        if (portableGameSetup.getIyikarakter().getCurrentlocation().getX() != 0)
                            Utilities.moveLeft();
                        break;

                    case KeyEvent.VK_RIGHT:
                        if (portableGameSetup.getIyikarakter().getCurrentlocation().getX() == 13 && portableGameSetup.getIyikarakter().getCurrentlocation().getY() == 9) {
                            Utilities.isGameOVer();
                        }
                        if (portableGameSetup.getIyikarakter().getCurrentlocation().getX() != 13) {
                            Utilities.moveRight();
                        }
                        break;
                }

                Utilities.yolhesapla();
                gameWindow.repaintWindow();
            }
            public void keyReleased(KeyEvent e) {
                // TODO  for now it is not needed
            }
            public void keyTyped(KeyEvent e) {
                // not needed
            }
        };
        gameWindow.mazeframe.addKeyListener(keys);
    }
    public void repaintWindow(){

        healthpane.repaint();
        pathpane.repaint();
        mazepane.repaint();
        mazeframe.repaint();
    }

}
