package nalain.gui;

import nalain.karakterler.*;
import nalain.maze.Labyrinth;

import javax.swing.*;
import java.awt.*;

public class MazePanel extends BasePanel {

    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        g.setColor(Color.black);
        g.setFont(new Font ("TimesRoman", Font.BOLD | Font.ITALIC, 20));

        for(int y=0;y<550;y+=50) {

            int j=y/50;
            for(int x=0;x<700;x+=50) {

                int i=x/50;
                int wallpath=mazearray[j][i];

                if(wallpath==1) {//path
                    g.setColor(Color.black);
                    g.drawRect(x+1, y+1, 48,48);
                    g.drawString(""+wallpath,x+25,y+25);
                }
                else {//wall
                    g.setColor(Color.lightGray);
                    g.fillRect(x+1, y+1, 48, 48);
                    g.setColor(Color.black);
                    g.drawString(""+wallpath,x+25,y+25);

                }
            }
        }
        //kapilar

        g.setColor(Color.blue);
        g.fillRect(1, 251, 48, 48);
        g.fillRect(201, 1, 48, 48);
        g.fillRect(601, 1, 48, 48);
        g.fillRect(651, 251, 48, 48);
        g.fillRect(201,501, 48, 48);
        g.setColor(Color.white);
        g.drawString("A",1+25,251+25);
        g.drawString("B",201+25,1+25);
        g.drawString("C",601+25,1+25);
        g.drawString("D",651+25,251+25);
        g.drawString("E",201+25,501+25);


        //oyuncu
        g.setColor(Color.orange);
        int iyix=iyikarakter.currentlocation.getX()*50;
        int iyiy= iyikarakter.currentlocation.getY()*50;

        g.fillRect(iyix+1,iyiy+1, 48, 48);
        Image karakterimage;
        if(iyikarakter.getName().equalsIgnoreCase("sky")) {
            karakterimage =this.getToolkit().getImage(BASE_PATH_RESOURCES+"images/sky.jpg");
        }
        else {
            karakterimage =this.getToolkit().getImage(BASE_PATH_RESOURCES+"images/masteryoda.jpg");
        }
        if(karakterimage!=null) {
            g.drawImage(karakterimage,(iyix+1), (iyiy+1), 48, 48,this);
        }

        //path gosterisis


        for(int i=0;i<kotukarakter.size();i++) {

            Karakter tempo=kotukarakter.get(i);
            String kkcolor=(String) tempo.color;

            if(kkcolor.equalsIgnoreCase("R")) {
                g.setColor(Color.RED);
            }
            else if(kkcolor.equalsIgnoreCase("B")) {
                g.setColor(Color.getHSBColor(240, (float) 0.08, (float) 0.01));
            }
            if(kkcolor.equalsIgnoreCase("M")) {
                g.setColor(Color.MAGENTA);
            }

            for(int j=0;j<tempo.enkisayol.size()-1;j++) {
                Location loc=tempo.enkisayol.get(j);
                int pathx,pathy;
                pathx=loc.getX()*50;
                pathy=loc.getY()*50;

                g.fillRect(pathx+1,pathy+1, 48, 48);

            }


        }

        //kotu nalain.karakterler

        for(int ki=0;ki<kotukarakter.size();ki++) {

            Karakter gecicikotukarakter=kotukarakter.get(ki);

            int kotux=gecicikotukarakter.currentlocation.getX()*50;
            int kotuy= gecicikotukarakter.currentlocation.getY()*50;
            Image gecicikotukarakterIcon;
            String iconname=gecicikotukarakter.name;
            gecicikotukarakterIcon =this.getToolkit().getImage(BASE_PATH_RESOURCES+"images/"+iconname+".jpg".toString());
            if(gecicikotukarakterIcon!=null) {
                g.drawImage(gecicikotukarakterIcon,kotux+1, kotuy+1, 48, 48,this);
            }
            else {
                System.out.println("empty");
            }

            if(Oyunbitti==true) {
                //KAZANDINIZ

                g.setColor(Color.getHSBColor(0, 0, 0));
                g.fillRect(150, 100, 400,300);
                g.setColor(Color.WHITE);
                g.setFont(new Font ("TimesRoman", Font.BOLD, 50));
                g.drawString("YOU WON",200,250);
                mazeframe.removeKeyListener(keys);
            }

            if(iyix==kotux&&iyiy==kotuy) {
                System.out.println("_>yakaladim seni<_");

                //karakter nextlife;
                if(iyikarakter.getName().equalsIgnoreCase("sky")) {
                    LukeSkyWalker nextlife=(LukeSkyWalker) iyikarakter;
                    nextlife.setCan(nextlife.getCan()-1);
                    healthpane.repaint();
                    if(nextlife.getCan()>=1) {
                        System.out.println("remaining life cycles "+ nextlife.getCan());
                        iyikarakter=nextlife;
                        oyunsifirla();

                    }
                    else {
                        //GAME OVER
                        g.setColor(Color.getHSBColor(0, 0, 0));
                        g.fillRect(150, 100, 400,300);
                        g.setColor(Color.WHITE);
                        g.setFont(new Font ("TimesRoman", Font.BOLD, 50));
                        g.drawString("GAME OVER",200,250);
                        mazeframe.removeKeyListener(keys);
                    }
                }
                else if(iyikarakter.getName().equalsIgnoreCase("masteryoda")){

                    MasterYoda nextlife=(MasterYoda) iyikarakter;
                    nextlife.setCan(nextlife.getCan()-1);
                    healthpane.repaint();

                    if(nextlife.getCan()>=1) {
                        System.out.println("remaining life cycles "+ nextlife.getCan());
                        iyikarakter=nextlife;
                        oyunsifirla();
                    }
                    else {
                        //GAME OVER

                        g.setColor(Color.getHSBColor(0, 0, 0));
                        g.fillRect(150, 100, 400,300);
                        g.setColor(Color.WHITE);
                        g.setFont(new Font ("TimesRoman", Font.BOLD,50));
                        g.drawString("GAME OVER",200,250);
                        mazeframe.removeKeyListener(keys);

                    }

                }

                break;
            }

        }

    }
}