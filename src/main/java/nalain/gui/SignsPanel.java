package nalain.gui;
import lombok.AllArgsConstructor;

import java.awt.*;

@AllArgsConstructor
public class SignsPanel extends BasePanel {
    int x, y;
    Image dooricon;
    int flag;

    Toolkit toolkit;

    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        setBackground(Color.getHSBColor(74, (float) 0.10, (float) 0.12));
        if (dooricon != null) {
            g.drawImage(dooricon, x + 1, y + 1, 48, 48, this);
        }
        if (flag == 1) {//top panel has 2 doors
            g.drawImage(dooricon, 600, 1, 48, 48, this);
        }
        if (flag == 2) {
            Image trophy = this.getToolkit().getImage(portableGameSetup.getBASE_PATH_RESOURCES() + "images/trophy.png");
            g.drawImage(trophy, 0, 450, 48, 48, this);
        }
    }

    private void setupSignsPanel() {

        toolkit = Toolkit.getDefaultToolkit();

        Image left = toolkit.getImage(portableGameSetup.getBASE_PATH_RESOURCES() + "images/left.png");
        Image right = toolkit.getImage(portableGameSetup.getBASE_PATH_RESOURCES() + "images/right.png");
        Image up = toolkit.getImage(portableGameSetup.getBASE_PATH_RESOURCES() + "images/up.png");
        Image down = toolkit.getImage(portableGameSetup.getBASE_PATH_RESOURCES() + "images/down.png");


//        leftindications = new SignsPanel(0, 250, right, 0);
//        rightindications = new SignsPanel(0, 250, left, 2);
//        bottomindications = new SignsPanel(200, 0, up, 0);
//        topindications = new SignsPanel(200, 0, down, 1);
//
//        leftindications.setLocation(50, 150);
//        rightindications.setLocation(800, 150);
//        topindications.setLocation(100, 100);
//        bottomindications.setLocation(100, 700);
//
//        leftindications.setSize(50, 550);
//        rightindications.setSize(50, 550);
//        topindications.setSize(700, 50);
//        bottomindications.setSize(700, 50);


    }

}