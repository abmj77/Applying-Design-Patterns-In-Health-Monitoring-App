package Monitoring_Record;

import javax.swing.*;
import java.awt.*;

public class MonitoringRecordRiyadh extends JFrame {
    public MonitoringRecordRiyadh() {
        setTitle("Monitoring Record - Riyadh");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Simple example content
        JTextArea textArea = new JTextArea("Welcome to Riyadh Monitoring Record System.");
        textArea.setEditable(false);
        add(new JScrollPane(textArea), BorderLayout.CENTER);

        setVisible(true);
    }
}
