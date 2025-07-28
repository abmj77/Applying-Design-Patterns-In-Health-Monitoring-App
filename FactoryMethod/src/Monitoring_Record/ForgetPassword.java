package Monitoring_Record;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ForgetPassword extends JFrame {
    private final JLabel phoneNumberLabel = new JLabel(" Phone Number:");
    private final JLabel idNumberLabel = new JLabel(" ID Number:");
    private final JLabel mrnLabel = new JLabel(" MRN:");
    
    private final JTextField phoneNumberField = new JTextField(5);
    private final JTextField idField = new JTextField(5);
    private final JTextField mrnField = new JTextField(5);
    
    private final JPanel mainPanel = new JPanel(new GridLayout(4, 0));
    private final JPanel idPanel = new JPanel(new GridLayout(2, 0));
    private final JPanel mrnPanel = new JPanel(new GridLayout(2, 0));
    private final JPanel buttonPanel = new JPanel();
    private final JPanel phonePanel = new JPanel(new GridLayout(2, 0));
    private final JPanel emptyPanel = new JPanel(new GridLayout(2, 0));
    
    private final JButton resetButton = new JButton("Reset");
    
    public ForgetPassword() {
        super.setTitle("Reset Password");
        super.setSize(450, 470);
        super.setLocationRelativeTo(null);
        super.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        resetButton.addActionListener(new ResetButtonListener());
        
        mainPanel.setBackground(Color.LIGHT_GRAY);
        buttonPanel.setBackground(Color.DARK_GRAY);
        buttonPanel.add(resetButton);

        idPanel.add(idNumberLabel);
        idPanel.add(idField);
        mrnPanel.add(mrnLabel);
        mrnPanel.add(mrnField);
        phonePanel.add(phoneNumberLabel);
        phonePanel.add(phoneNumberField);
                       
        mainPanel.add(idPanel);
        mainPanel.add(mrnPanel);
        mainPanel.add(phonePanel);
        mainPanel.add(emptyPanel);

        super.add(mainPanel);
        super.add(buttonPanel, BorderLayout.SOUTH);
        
        super.setVisible(true);
    }
    
    private class ResetButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == resetButton) {
                String phoneNumber = phoneNumberField.getText();
                String id = idField.getText();
                String mrn = mrnField.getText();
                Double p, i, m;
                
                try {
                    if (phoneNumber.equals("") || id.equals("") || mrn.equals("")) {
                        JOptionPane.showMessageDialog(null, "Invalid information!", "Warning", JOptionPane.ERROR_MESSAGE);
                        phoneNumberField.setText("");
                        idField.setText("");
                        mrnField.setText("");
                    } else {
                        p = Double.parseDouble(phoneNumber);
                        i = Double.parseDouble(id);
                        m = Double.parseDouble(mrn);
                        JOptionPane.showMessageDialog(null, "SMS has been sent to this number " +
                                phoneNumberField.getText() + " please check the Messages App");
                        dispose();
                        new LoginFactorySelector();
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Enter only numbers");
                    phoneNumberField.setText("");
                    idField.setText("");
                    mrnField.setText("");
                }
            }
        }
    }
}