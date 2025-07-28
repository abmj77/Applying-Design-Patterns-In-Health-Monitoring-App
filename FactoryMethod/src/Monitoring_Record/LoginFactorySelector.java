package Monitoring_Record;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class LoginFactorySelector extends JFrame {
    public LoginFactorySelector() {
        setTitle("Select Login Type");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JPanel panel = new JPanel(new GridLayout(4, 1));
        JLabel label = new JLabel("Select your login type:", JLabel.CENTER);
        JButton patientBtn = new JButton("Patient Login");
        JButton doctorBtn = new JButton("Doctor Login");
        JButton adminBtn = new JButton("Admin Login");
        
        patientBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                LoginFactory factory = new PatientLoginFactory();
                factory.showLoginScreen("patient");
            }
        });
        
        doctorBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                LoginFactory factory = new DoctorLoginFactory();
                factory.showLoginScreen("doctor");
            }
        });
        
        adminBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                LoginFactory factory = new AdminLoginFactory();
                factory.showLoginScreen("admin");
            }
        });
        
        panel.add(label);
        panel.add(patientBtn);
        panel.add(doctorBtn);
        panel.add(adminBtn);
        
        add(panel, BorderLayout.CENTER);
        setVisible(true);
    }
    
    public static void main(String[] args) {
        new LoginFactorySelector();
    }
}