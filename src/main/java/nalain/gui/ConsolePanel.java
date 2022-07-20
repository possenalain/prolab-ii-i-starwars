package nalain.gui;

import nalain.karakterler.*;
import java.awt.*;
import java.util.ArrayList;

public class ConsolePanel extends BasePanel {
    ArrayList<Karakter> kotukarakter;

    public ConsolePanel(){
        //TODO
        kotukarakter=null;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setFont(new Font ("TimesRoman", Font.BOLD, 20));

        int i=0;
        for(Karakter karakter:kotukarakter) {
            g.setColor(Color.white);
            if(karakter.getEnkisayol().size()>0) {
                if(karakter.getName().equalsIgnoreCase("Kyloren")) {
                    int h=(karakter.getEnkisayol().size()/2);
                    g.drawString(karakter.getName()+" will get there in "+h+" step(s)", i, (i+1)*25);
                }
                else {
                    g.drawString(karakter.getName()+" will get there in "+karakter.getEnkisayol().size()+" step(s)", i, (i+1)*25);

                }
            }
            i++;
        }
    }
}