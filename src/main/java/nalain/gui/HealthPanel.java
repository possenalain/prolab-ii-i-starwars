package nalain.gui;

import javax.swing.*;
import java.awt.*;

public class HealthPanel extends BasePanel {
    JProgressBar lifeProgressBar;

    HealthPanel() {
        this.setLocation(550, 25);
        this.setSize(300, 30);
        this.setBackground(Color.black);

        JLabel lifeLabel = new JLabel("Life");
        lifeLabel.setForeground(Color.ORANGE);
        this.add(lifeLabel);

        lifeProgressBar = new JProgressBar();
        lifeProgressBar.setForeground(Color.red);
        lifeProgressBar.setMaximum(0);
        lifeProgressBar.setMaximum(portableGameSetup.getIyikarakter().getCan());

        this.add(lifeProgressBar);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        lifeProgressBar.setValue((1 + portableGameSetup.getIyikarakter().getCan() - portableGameSetup.getRound()));
    }
}