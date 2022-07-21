package nalain.gui;

import nalain.karakterler.Karakter;
import java.awt.*;

public class ConsolePanel extends BasePanel {
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setFont(new Font("TimesRoman", Font.BOLD, 20));
        int i = 0;
        for (Karakter karakter : portableGameSetup.getKotukarakter()) {
            g.setColor(Color.white);
            if (karakter.getEnkisayol().size() > 0) {
                if (karakter.getName().equalsIgnoreCase("Kyloren")) {
                    int h = (karakter.getEnkisayol().size() / 2);
                    g.drawString(karakter.getName() + " will get there in " + h + " step(s)", i, (i + 1) * 25);
                } else {
                    g.drawString(karakter.getName() + " will get there in " + karakter.getEnkisayol().size() + " step(s)", i, (i + 1) * 25);

                }
            }
            i++;
        }
    }
}