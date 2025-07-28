package Monitoring_Record;

import javax.swing.*;
import java.awt.*;

public class MonitoringRecordYanbu extends JFrame {
    public MonitoringRecordYanbu() {
        setTitle("Monitoring Record - Yanbu");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Simple example content
        JTextArea textArea = new JTextArea("Welcome to Yanbu Monitoring Record System.");
        textArea.setEditable(false);
        add(new JScrollPane(textArea), BorderLayout.CENTER);

        setVisible(true);
    }
}
