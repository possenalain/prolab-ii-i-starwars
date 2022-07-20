package nalain.gui;

import nalain.karakterler.*;

import javax.swing.*;
import java.awt.*;

public class HealthPanel extends BasePanel {
    public HealthPanel(){

    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setFont(new Font ("TimesRoman", Font.BOLD,30));
        g.setColor(Color.WHITE);
        g.drawString("CANLAR", 10, 30);

        if(iyikarakter.getName().equalsIgnoreCase("sky")) {
            int life=iyikarakter.getCan();
            int x=50;
            int y=2;
            Image lifeicon=this.getToolkit().getImage(BASE_PATH_RESOURCES+"images/fulllife.png");
            for(int i=life;i>0;i--) {
                g.drawImage(lifeicon,150+x*(3-i)-1,y-1,48,48,this);
            }

        }
        else if(iyikarakter.getName().equalsIgnoreCase("masteryoda")) {

            int life=iyikarakter.getCan();
            int x=50;
            int y=2;
            Image lifeicon;
            if(life%2==1) {
                int here=(life/2)+1;
                lifeicon=this.getToolkit().getImage(BASE_PATH_RESOURCES+"images/halflife.png");
                g.drawImage(lifeicon,150+x*(3-here)-1,y-1,48,48,this);
                life-=1;
            }

            lifeicon=this.getToolkit().getImage(BASE_PATH_RESOURCES+"images/fulllife.png");
            for(int i=life;i>1;i-=2) {
                g.drawImage(lifeicon,150+x*((6-i)/2)-1,y-1,48,48,this);
            }

        }
    }
}