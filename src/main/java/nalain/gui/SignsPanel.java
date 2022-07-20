package nalain.gui;

import javax.swing.*;
import java.awt.*;

public class SignsPanel extends BasePanel {


    Image dooricon;
    int x,y,flag;

    SignsPanel(){

    }
    public SignsPanel(int x, int y, Image Imagename, int flag){

        this.dooricon=Imagename;
        this.x=x;
        this.y=y;
        this.flag=flag;
    }
    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        setBackground(Color.getHSBColor(74,(float) 0.10, (float)0.12));
        if(dooricon!=null) {
            g.drawImage(dooricon, x+1, y+1,48,48, this);
        }
        if(flag==1) {//top panel has 2 doors
            g.drawImage(dooricon, 600, 1,48,48, this);
        }

        if(flag==2) {
            Image trophy=this.getToolkit().getImage(BASE_PATH_RESOURCES+"images/trophy.png");
            g.drawImage(trophy, 0, 450,48,48, this);
        }

    }

}