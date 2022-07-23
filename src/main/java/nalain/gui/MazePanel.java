package nalain.gui;

import nalain.karakterler.Karakter;
import nalain.maze.LabyrinthSign;
import nalain.maze.Location;

import java.awt.*;
import java.util.ArrayList;

public class MazePanel extends BasePanel {
    private final int FACTOR = 50;
    private final int DIMX;
    private final int DIMY;
    MazePanel() {
        DIMX = portableGameSetup.getLabyrinth().getSizeX();
        DIMY = portableGameSetup.getLabyrinth().getSizeY();
        this.setLocation(0, 0);
        this.setSize((DIMX * FACTOR), (DIMY * FACTOR));
        this.setBackground(Color.white);
    }
    public void paintComponent(Graphics g) {

        super.paintComponent(g);

        g.setColor(Color.black);
        g.setFont(new Font("TimesRoman", Font.BOLD | Font.ITALIC, 20));

        drawTheBoard(g);
        drawSignsOnBoard(g);
        drawCharacters(g);

        if (portableGameSetup.isGameOver()) {
            drawGameOver(g);
        }
    }
    private void drawCharacters(Graphics g) {

        ArrayList<Karakter> characters = new ArrayList<>();
        characters.addAll(portableGameSetup.getKotukarakter());
        characters.add(0, portableGameSetup.getIyikarakter());

        for (Karakter karakter : characters) {

            g.setColor(getColorByAbbr(karakter.getColor()));
            int locx = karakter.getCurrentlocation().getX() * FACTOR;
            int locy = karakter.getCurrentlocation().getY() * FACTOR;

            g.fillRect(locx + 1, locy + 1, (FACTOR - 2), (FACTOR - 2));

            String imageName = karakter.getName().toLowerCase();
            Image karakterimage = this.getToolkit()
                    .getImage(portableGameSetup.getBASE_PATH_RESOURCES() + "images/" + imageName + ".jpg");

            if (karakterimage != null) {
                g.drawImage(karakterimage, (locx + 1), (locy + 1), (FACTOR - 2), (FACTOR - 2), this);
            }
            drawShortestPath(karakter, g);
        }

    }
    private void drawShortestPath(Karakter karakter, Graphics g) {

        String colorAbbr = (String) karakter.getColor();
        g.setColor(getColorByAbbr(colorAbbr));
        for (int j = 0; j < karakter.getEnkisayol().size() - 1; j++) {
            Location loc = karakter.getEnkisayol().get(j);
            int pathx = loc.getX() * FACTOR;
            int pathy = loc.getY() * FACTOR;
            g.fillRect(pathx + 1, pathy + 1, (FACTOR - 2), (FACTOR - 2));
        }
    }
    void drawSignsOnBoard(Graphics g) {
        //signs on boards
        for (LabyrinthSign sign : portableGameSetup.getLabyrinth().getLabyrinthSigns()) {
            int x = (int) (sign.getCoordinates().getX() * FACTOR);
            int y = (int) (sign.getCoordinates().getY() * FACTOR);

            g.setColor(Color.blue);
            g.fillRect(x + 1, y + 1, (FACTOR - 2), (FACTOR - 2));
            g.setColor(Color.white);
            g.drawString(sign.getName(), x + (FACTOR / 2), (int) y + (FACTOR / 2));
        }

    }
    void drawTheBoard(Graphics g) {

        for (int y = 0; y < DIMY * FACTOR; y += FACTOR) {
            int j = y / FACTOR;
            for (int x = 0; x < DIMX * FACTOR; x += FACTOR) {
                int i = x / FACTOR;
                int wallpath = portableGameSetup.getLabyrinth().mazearray[j][i];

                if (wallpath == 1) {//path
                    g.setColor(Color.black);
                    g.drawRect(x + 1, y + 1, (FACTOR - 2), (FACTOR - 2));
                    g.drawString("" + wallpath, x + (FACTOR / 2), (int) y + (FACTOR / 2));
                } else {//wall
                    g.setColor(Color.lightGray);
                    g.drawRect(x + 1, y + 1, (FACTOR - 2), (FACTOR - 2));
                    g.setColor(Color.black);
                    g.drawString("" + wallpath, x + (FACTOR / 2), (int) y + (FACTOR / 2));

                }

            }
        }
    }
    private void drawGameOver(Graphics g) {

        g.setColor(Color.getHSBColor(0, 0, 0));
        g.fillRect(150, 100, 400, 300);
        g.setColor(Color.WHITE);
        g.setFont(new Font("TimesRoman", Font.BOLD, 50));
        g.drawString("YOU WON", 200, 250);


    }
    private Color getColorByAbbr(String colorAbbr) {
        if (colorAbbr.equalsIgnoreCase("R")) {
            return Color.RED;
        } else if (colorAbbr.equalsIgnoreCase("B")) {
            return Color.getHSBColor(240, (float) 0.08, (float) 0.01);
        }
        if (colorAbbr.equalsIgnoreCase("M")) {
            return Color.MAGENTA;
        }
        return Color.ORANGE;
    }
}