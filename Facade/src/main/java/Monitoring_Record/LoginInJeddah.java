package Monitoring_Record;

import javax.swing.*;
import java.awt.*;

public class LoginInJeddah extends JFrame {
    public LoginInJeddah(AppFacade facade, Hospital hospital) {
        setTitle(hospital.getName() + " - Login");
        setSize(350, 180);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(3, 2, 5, 5));

        panel.add(new JLabel("Medical Record Number (MRN):"));
        JTextField mrnField = new JTextField(20);
        panel.add(mrnField);

        panel.add(new JLabel("Password:"));
        JPasswordField passwordField = new JPasswordField(20);
        panel.add(passwordField);

        JButton loginBtn = new JButton("Login");
        loginBtn.addActionListener(e -> {
            // Here, you can add real validation if needed
            dispose();
            facade.openMonitoringRecord();
        });

        panel.add(new JLabel());
        panel.add(loginBtn);

        add(panel);
        setVisible(true);
    }
}
