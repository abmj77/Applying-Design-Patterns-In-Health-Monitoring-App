package Monitoring_Record;

import javax.swing.*;

public class MonitoringRecordJeddah extends JFrame {
    public MonitoringRecordJeddah() {
        setTitle("Monitoring Record - Jeddah");
        setSize(400, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JLabel label = new JLabel("Welcome to Jeddah Hospital Monitoring Records");
        label.setHorizontalAlignment(SwingConstants.CENTER);
        add(label);

        setVisible(true);
    }
}
