package nalain.gui;

import javax.swing.*;
import java.awt.*;

public class LogsPanel extends ScrollableBasePanel {
    JTextArea logsTextArea;

    LogsPanel() {

        logsTextArea = new JTextArea();
        this.setForeground(new Color(203, 203, 203));
        this.setBackground(new Color(0, 0, 0, 255));
        this.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        this.setBackground(Color.getHSBColor(112, (float) 0.38, (float) 0.14));


        this.setSize(900, 150);
        this.setLocation(0, 550);

        logsTextArea.setBackground(new Color(0, 0, 0, 255));
        logsTextArea.setForeground(new Color(222, 222, 222));
        logsTextArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
        logsTextArea.setAlignmentY(CENTER_ALIGNMENT);
        logsTextArea.setColumns(20);
        logsTextArea.setRows(5);
        logsTextArea.setEditable(false);
        logsTextArea.setEnabled(false);
        logsTextArea.setLineWrap(true);
        logsTextArea.setWrapStyleWord(true);
        refleshLogs();
        this.setViewportView(logsTextArea);
    }

    void refleshLogs() {
        logsTextArea.append("\n" +
                "\n" + portableGameSetup.getLogger().getLogs());
        portableGameSetup.getLogger().clearLogs();
    }
}