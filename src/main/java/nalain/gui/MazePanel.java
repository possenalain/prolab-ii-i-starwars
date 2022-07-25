package nalain.gui;

import nalain.karakterler.Karakter;
import nalain.maze.LabyrinthSign;
import nalain.maze.Location;

import java.awt.*;
import java.util.ArrayList;

public class MazePanel extends BasePanel {
    private final int XFACTOR;
    private final int YFACTOR;
    private final int DIMX;
    private final int DIMY;

    MazePanel(GameWindow gameWindow) {

        this.setSize((gameWindow.getWidth()), (gameWindow.getWidth()));
        this.setSize(646, 560);
        this.setBackground(new Color(182, 159, 140));


        DIMX = portableGameSetup.getLabyrinth().getSizeX();
        DIMY = portableGameSetup.getLabyrinth().getSizeY();

        XFACTOR = Math.round(this.getWidth() / DIMX);
        YFACTOR = (int) Math.ceil(this.getHeight() / DIMY);
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
            int locx = karakter.getCurrentlocation().getX() * XFACTOR;
            int locy = karakter.getCurrentlocation().getY() * YFACTOR;

            g.fillRect(locx + 1, locy + 1, (XFACTOR - 2), (YFACTOR - 2));

            String imageName = karakter.getName().toLowerCase();
            Image karakterimage = this.getToolkit()
                    .getImage(portableGameSetup.getBASE_PATH_RESOURCES() + "images/" + imageName + ".jpg");

            if (karakterimage != null) {
                g.drawImage(karakterimage, (locx + 1), (locy + 1), (XFACTOR - 2), (YFACTOR - 2), this);
            }
            drawShortestPath(karakter, g);
        }

    }

    private void drawShortestPath(Karakter karakter, Graphics g) {

        String colorAbbr = karakter.getColor();
        g.setColor(getColorByAbbr(colorAbbr));
        for (int j = 0; j < karakter.getEnkisayol().size() - 1; j++) {
            Location loc = karakter.getEnkisayol().get(j);
            int pathx = loc.getX() * XFACTOR;
            int pathy = loc.getY() * YFACTOR;
            g.fillRect(pathx + 1, pathy + 1, (XFACTOR - 2), (YFACTOR - 2));
        }
    }

    void drawSignsOnBoard(Graphics g) {
        //signs on boards
        for (LabyrinthSign sign : portableGameSetup.getLabyrinth().getLabyrinthSigns()) {
            int x = sign.getCoordinates().getX() * XFACTOR;
            int y = sign.getCoordinates().getY() * YFACTOR;

            g.setColor(Color.blue);
            g.fillRect(x + 1, y + 1, (XFACTOR - 2), (YFACTOR - 2));

            String iconName = sign.getIconName();
            Image iconImage = this.getToolkit()
                    .getImage(portableGameSetup.getBASE_PATH_RESOURCES() + "images/" + iconName + ".png");

            if (iconImage != null) {
                g.drawImage(iconImage, (x + 1), (y + 1), (XFACTOR - 2), (YFACTOR - 2), this);
            }
        }

    }

    void drawTheBoard(Graphics g) {

        for (int y = 0; y < DIMY * YFACTOR; y += YFACTOR) {
            int j = y / YFACTOR;
            for (int x = 0; x < DIMX * XFACTOR; x += XFACTOR) {
                int i = x / XFACTOR;
                int wallpath = portableGameSetup.getLabyrinth().mazearray[j][i];

                if (wallpath == 1) {//path
//                    g.setColor(Color.lightGray);
//                    g.fillRect(x + 1, y + 1, (XFACTOR - 2), (YFACTOR - 2));
                } else {//wall
                    g.setColor(Color.black);
                    g.fillRect(x + 1, y + 1, (XFACTOR - 2), (YFACTOR - 2));
                }

            }
        }
    }

    private void drawGameOver(Graphics g) {

        g.setColor(Color.getHSBColor(0, 0, 0));
        g.fillRect((int) (this.getWidth() * 0.1), (int) (this.getHeight() * 0.1), (int) (this.getWidth() * 0.8), (int) (this.getHeight() * 0.8));
        g.setColor(Color.WHITE);
        g.setFont(new Font("TimesRoman", Font.BOLD, XFACTOR));
        g.drawString((portableGameSetup.getRound() <= portableGameSetup.getIyikarakter().getCan()) ?
                "YOU WON" : "Game Over", (int) ((this.getWidth() * 0.32)), (int) ((this.getHeight() * 0.48)));

    }

    private Color getColorByAbbr(String colorAbbr) {
        if (colorAbbr.equalsIgnoreCase("R")) {
            return Color.RED;
        } else if (colorAbbr.equalsIgnoreCase("B")) {
            return Color.getHSBColor(150, (float) 0.8, (float) 0.61);
        }
        if (colorAbbr.equalsIgnoreCase("M")) {
            return Color.MAGENTA;
        }
        return Color.ORANGE;
    }

}