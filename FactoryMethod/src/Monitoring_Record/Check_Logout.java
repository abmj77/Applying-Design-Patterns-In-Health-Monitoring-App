package Monitoring_Record;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Check_Logout extends JFrame {
    private JLabel confirmationLabel;
    private JButton yesButton;
    private JButton cancelButton;
    private JPanel buttonPanel;
    private JPanel mainPanel;

    public Check_Logout() {
        initializeComponents();
        setupMainWindow();
    }

    private void initializeComponents() {
        confirmationLabel = new JLabel("Are you sure you want to exit from this account?", JLabel.CENTER);
        yesButton = new JButton("Yes");
        cancelButton = new JButton("Cancel");
        buttonPanel = new JPanel();
        mainPanel = new JPanel(new BorderLayout());

        // Set up button actions
        yesButton.addActionListener(new LogoutListener());
        cancelButton.addActionListener(new CancelListener());

        // Configure components
        confirmationLabel.setFont(new Font("Dialog", Font.PLAIN, 14));
        confirmationLabel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
        buttonPanel.add(yesButton);
        buttonPanel.add(cancelButton);
        
        mainPanel.add(confirmationLabel, BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);
    }

    private void setupMainWindow() {
        setTitle("Monitoring Record App - Confirm Logout");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());
        add(mainPanel, BorderLayout.CENTER);
        
        // Set window properties
        setSize(350, 150);
        setLocationRelativeTo(null); // Center on screen
        setResizable(false);
        setVisible(true);
    }

    private class LogoutListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Close all windows and return to login
            dispose();
            Window[] windows = Window.getWindows();
            for (Window window : windows) {
                window.dispose();
            }
            new LoginFactorySelector();
        }
    }

    private class CancelListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            dispose(); // Just close the confirmation dialog
        }
    }

    // Helper method to find and close Monitoring_Record_Window if open
    private void closeMonitoringWindow() {
        for (Window window : Window.getWindows()) {
            if (window instanceof Monitoring_Record_Window) {
                window.dispose();
                break;
            }
        }
    }
}