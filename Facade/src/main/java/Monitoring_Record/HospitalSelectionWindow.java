package Monitoring_Record;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class HospitalSelectionWindow extends JFrame {
    private AppFacade facade;

    public HospitalSelectionWindow(AppFacade facade) {
        this.facade = facade;
        setTitle("Select Hospital");
        setSize(300, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 1, 10, 10));

        JLabel label = new JLabel("Choose your hospital:");
        label.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(label);

        JButton jeddahBtn = new JButton("King Fahad Hospital (Jeddah)");
        jeddahBtn.addActionListener((ActionEvent e) -> {
            facade.selectHospital("jeddah");
            dispose();
            facade.login();
        });

        JButton riyadhBtn = new JButton("King Faisal Hospital (Riyadh)");
        riyadhBtn.addActionListener((ActionEvent e) -> {
            facade.selectHospital("riyadh");
            dispose();
            facade.login();
        });

        JButton yanbuBtn = new JButton("National Hospital (Yanbu)");
        yanbuBtn.addActionListener((ActionEvent e) -> {
            facade.selectHospital("yanbu");
            dispose();
            facade.login();
        });

        panel.add(jeddahBtn);
        panel.add(riyadhBtn);
        panel.add(yanbuBtn);

        add(panel);
        setVisible(true);
    }
}
