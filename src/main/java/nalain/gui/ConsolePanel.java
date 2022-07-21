package nalain.gui;

import java.awt.*;
public class ConsolePanel extends BasePanel {
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setFont(new Font("TimesRoman", Font.BOLD, 20));


        //TODO
        // might need to use something like a text box and append to it all the time
        g.drawString(portableGameSetup.getLogger().getLogs(), 1, (1 + 1) * 25);
    }
}