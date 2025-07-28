package Monitoring_Record;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JOptionPane;

public class DoctorLogin implements User {
    private final JLabel usernameLabel = new JLabel("Doctor ID:", JLabel.LEFT);
    private final JLabel passwordLabel = new JLabel("Password:", JLabel.LEFT);
    private final JTextField usernameField = new JTextField(35);
    private final JPasswordField passwordField = new JPasswordField(30);
    private final JButton loginButton = new JButton("Log In");
    private final JButton backButton = new JButton("Back");
    private JFrame frame;

    @Override
    public void showLoginScreen() {
        frame = new JFrame();
        frame.setTitle("Doctor Log In");
        frame.setSize(500, 300);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JPanel mainPanel = new JPanel(new GridLayout(3, 1));
        JPanel usernamePanel = new JPanel();
        JPanel passwordPanel = new JPanel();
        JPanel buttonPanel = new JPanel();
        
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());
                
                if (username.equals("doc123") && password.equals("docpass")) {
                    frame.dispose();
                    // Open doctor dashboard
                    JOptionPane.showMessageDialog(null, "Doctor dashboard would open here");
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid credentials", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new LoginFactorySelector();
            }
        });
        
        usernamePanel.add(usernameLabel);
        usernamePanel.add(usernameField);
        passwordPanel.add(passwordLabel);
        passwordPanel.add(passwordField);
        buttonPanel.add(loginButton);
        buttonPanel.add(backButton);
        
        mainPanel.add(usernamePanel);
        mainPanel.add(passwordPanel);
        mainPanel.add(buttonPanel);
        
        frame.add(mainPanel, BorderLayout.CENTER);
        frame.setVisible(true);
    }
}