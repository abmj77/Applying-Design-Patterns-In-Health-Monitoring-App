package Monitoring_Record;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JOptionPane;

public class PatientLogin implements User {
    private final String[] IDLog = {"    MRN    ","      ID   "};
    private final JLabel MRNLabel = new JLabel(" MRN / ID:" , JLabel.LEFT);
    private final JLabel PasswordLabel = new JLabel(" Password:" , JLabel.LEFT);
    
    private final JTextField MRNField = new JTextField(35);
    private final JPasswordField PasswordField = new JPasswordField(30);
    
    private final JButton LoginButton = new JButton("Log In");
    private final JButton ForgetButton = new JButton("Forget Password");
    private final JButton ShowButton = new JButton("Show / Hide");
    private final JButton SupportButton = new JButton("Contact Us");
    
    JRadioButton RadionMRN = new JRadioButton("MRN");
    JRadioButton RadioID = new JRadioButton("National ID");
    
    private final JPanel p = new JPanel(new GridLayout(2,1));
    private final JPanel p1 = new JPanel(new GridLayout(2,1));
    private final JPanel p2 = new JPanel(new GridLayout(2,1));
    private final JPanel p3 = new JPanel();
    private final JPanel p4 = new JPanel();
    private final JPanel p5 = new JPanel();
    private JFrame frame;

    @Override
    public void showLoginScreen() {
        frame = new JFrame();
        frame.setTitle("Patient Log In");
        frame.setSize(500, 470);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        ShowButton.setMnemonic(KeyEvent.VK_R);
        ShowButton.setToolTipText("To Hide Or Show Your Password");
        
        LoginButton.addActionListener(new Check());
        ForgetButton.addActionListener(new Check());
        ShowButton.addActionListener(new showORhide());
        SupportButton.addActionListener(new Check());
        
        MRNLabel.setForeground(Color.BLACK);
        PasswordLabel.setForeground(Color.BLACK);
        LoginButton.setBackground(Color.WHITE);
        ForgetButton.setBackground(Color.WHITE);
        SupportButton.setBackground(Color.WHITE);
        
        ButtonGroup group = new ButtonGroup();
        group.add(RadionMRN);
        group.add(RadioID);
        
        Color myColor = new Color(0xCCCCCC);
        
        RadionMRN.setBackground(myColor);
        RadioID.setBackground(myColor);
        p1.setBackground(myColor);
        p2.setBackground(myColor);
        p2.setBackground(myColor);
        p3.setBackground(myColor);
        p5.setBackground(myColor);
        
        p4.setBackground(Color.DARK_GRAY);
        
        p1.add(MRNLabel);
        p5.add(MRNField);
        p5.add(RadionMRN);
        p5.add(RadioID);
        p1.add(p5);
        p2.add(PasswordLabel);
        p3.add(PasswordField);
        p3.add(ShowButton);
        p2.add(p3);
        p4.add(LoginButton);
        p4.add(ForgetButton);
        p4.add(SupportButton);
        p.add(p1);
        p.add(p2);
        
        frame.add(p, BorderLayout.CENTER);
        frame.add(p4, BorderLayout.SOUTH);
        
        frame.setVisible(true);
    }

    private class Check implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == LoginButton) {
                String username = MRNField.getText();
                String password = new String(PasswordField.getPassword());
                
                if (username.equals("12782")||username.equals("1")||username.equals("1234")||username.equals("123456789") 
                    && password.equals("1234")||password.equals("1")) {
                    frame.dispose();
                    new Monitoring_Record_Window();
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid username or password!", "Warning", JOptionPane.ERROR_MESSAGE);
                    PasswordField.setText("");
                }
            }

            if (e.getSource() == ForgetButton) {
                new ForgetPassword();
                frame.dispose();
            }
            
            if (e.getSource() == SupportButton) {
                frame.dispose();
                new Support();
            }
        }
    }

    private class showORhide implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ee) {
            if (PasswordField.echoCharIsSet()) 
                PasswordField.setEchoChar((char) 0);
            else 
                PasswordField.setEchoChar((char) 0x2022);
        }
    }
}