package nalain.gui;
import lombok.AllArgsConstructor;

import java.awt.*;

@AllArgsConstructor
public class SignsPanel extends BasePanel {
    int x, y;
    Image dooricon;
    int flag;
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
}