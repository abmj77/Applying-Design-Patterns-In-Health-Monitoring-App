package Monitoring_Record;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Singleton implementation of the login window
 */
public class LoginWithSingleton extends JFrame {
    // Singleton instance
    private static LoginWithSingleton instance;
    
    // UI Components
    private final JTextField MRNField = new JTextField(35);
    private final JPasswordField PasswordField = new JPasswordField(30);
    private final JButton LoginButton = new JButton("Log In");
    private final JButton ForgetButton = new JButton("Forget Password");
    private final JButton ShowButton = new JButton("Show / Hide");
    private final JButton SupportButton = new JButton("Contact Us");
    private final JRadioButton RadionMRN = new JRadioButton("MRN");
    private final JRadioButton RadioID = new JRadioButton("National ID");
    
    // Panels
    private final JPanel p = new JPanel(new GridLayout(2,1));
    private final JPanel p1 = new JPanel(new GridLayout(2,1));
    private final JPanel p2 = new JPanel(new GridLayout(2,1));
    private final JPanel p3 = new JPanel();
    private final JPanel p4 = new JPanel();
    private final JPanel p5 = new JPanel();

    // Private constructor for singleton pattern
    private LoginWithSingleton() {
        super.setTitle("Log In");
        super.setSize(500, 470);
        super.setLocationRelativeTo(null);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        initializeComponents();
        setupLayout();
        setupEventHandlers();
    }

    /**
     * Gets the singleton instance of LoginWithSingleton
     * @return The singleton instance
     */
    public static LoginWithSingleton getInstance() {
        if (instance == null) {
            instance = new LoginWithSingleton();
        }
        return instance;
    }

    private void initializeComponents() {
        ShowButton.setMnemonic(KeyEvent.VK_R);
        ShowButton.setToolTipText("To Hide Or Show Your Password");
        
        ButtonGroup group = new ButtonGroup();
        group.add(RadionMRN);
        group.add(RadioID);
        
        Color myColor = new Color(0xCCCCCC);
        RadionMRN.setBackground(myColor);
        RadioID.setBackground(myColor);
        p1.setBackground(myColor);
        p2.setBackground(myColor);
        p3.setBackground(myColor);
        p5.setBackground(myColor);
        p4.setBackground(Color.DARK_GRAY);
    }

    private void setupLayout() {
        p1.add(new JLabel("MRN / ID:", JLabel.LEFT));
        p5.add(MRNField);
        p5.add(RadionMRN);
        p5.add(RadioID);
        p1.add(p5);
        
        p2.add(new JLabel("Password:", JLabel.LEFT));
        p3.add(PasswordField);
        p3.add(ShowButton);
        p2.add(p3);
        
        p4.add(LoginButton);
        p4.add(ForgetButton);
        p4.add(SupportButton);
        
        p.add(p1);
        p.add(p2);
        
        super.add(p, BorderLayout.CENTER);
        super.add(p4, BorderLayout.SOUTH);
    }

    private void setupEventHandlers() {
        LoginButton.addActionListener(e -> handleLogin());

        ForgetButton.addActionListener(e -> {
            new ForgetPassword();
            dispose();
        });

        SupportButton.addActionListener(e -> {
            new Support();
            dispose();
        });

        ShowButton.addActionListener(e -> {
            if (PasswordField.getEchoChar() != 0) {
                PasswordField.setEchoChar((char)0);
            } else {
                PasswordField.setEchoChar('•');
            }
        });
    }

    private void handleLogin() {
        String username = MRNField.getText();
        String password = new String(PasswordField.getPassword());
        
        if (isValidLogin(username, password)) {
            new Monitoring_Record_Window();
            dispose();
        } else {
            JOptionPane.showMessageDialog(null, 
                "Invalid username or password!", 
                "Warning", 
                JOptionPane.ERROR_MESSAGE);
            PasswordField.setText("");
        }
    }

    private boolean isValidLogin(String username, String password) {
        return (username.equals("12782") || username.equals("1") || 
                username.equals("1234") || username.equals("123456789")) 
                && (password.equals("1234") || password.equals("1"));
    }
}