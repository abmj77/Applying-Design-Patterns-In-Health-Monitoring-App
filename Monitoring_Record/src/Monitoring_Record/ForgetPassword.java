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

    public class ForgetPassword extends JFrame
    {
        private final JLabel Phone_NuberLabel = new JLabel(" Phone Number:");
        private final JLabel ID_NumberLabel = new JLabel(" ID Number:");
        private final JLabel MRNLabel = new JLabel(" MRN:");
        
        private final JTextField Phone_NuberText = new JTextField(5);
        private final JTextField IDText = new JTextField(5);
        private final JTextField MRNText = new JTextField(5);
        
        private final JPanel p = new JPanel(new GridLayout(4,0));
        private final JPanel p1 = new JPanel(new GridLayout(2,0));
        private final JPanel p2 = new JPanel(new GridLayout(2,0));
        private final JPanel p3 = new JPanel();
        private final JPanel p4 = new JPanel(new GridLayout(2,0));
        private final JPanel p5 = new JPanel(new GridLayout(2,0));
        
        private final JButton ResetButton = new JButton("Reset:");
        
        public ForgetPassword()
        {
            super.setTitle("Reset Password");
            super.setSize(450 , 470);
            super.setLocationRelativeTo(null);
            super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            
            ResetButton.addActionListener(new ResetNewPassword());
            
            p.setBackground(Color.LIGHT_GRAY);
            p3.setBackground(Color.DARK_GRAY);
            p3.add(ResetButton);

            p1.add(ID_NumberLabel);
            p1.add(IDText);
            p2.add(MRNLabel);
            p2.add(MRNText);
            p4.add(Phone_NuberLabel);
            p4.add(Phone_NuberText);
                       
            p.add(p1);
            p.add(p2);
            p.add(p4);
            p.add(p5);

            super.add(p);
            super.add(p3 , BorderLayout.SOUTH);
            
            super.setVisible(true);
        } 
        
        private class ResetNewPassword implements ActionListener
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                if (e.getSource() == ResetButton) 
                {
                    //String password = new String(PasswordField.getPassword());
                    String Phone_Nuber = Phone_NuberText.getText();
                    String ID = IDText.getText();
                    String MRN = MRNText.getText();
                    Double P,I,M;
                    
                    try
                    {
                        if (Phone_Nuber.equals("") || ID.equals("") || MRN.equals("")) 
                        {
                            JOptionPane.showMessageDialog(null, "Invalid information!", "Warning", JOptionPane.ERROR_MESSAGE);
                            Phone_NuberText.setText("");
                            IDText.setText("");
                            MRNText.setText("");
                        }
                        else
                        {
                            P = Double.parseDouble(Phone_Nuber);
                            I = Double.parseDouble(ID);
                            M = Double.parseDouble(MRN);
                            JOptionPane.showMessageDialog(null, "SMS has been sent to this number " +
                            Phone_NuberText.getText()+" please check the Messages App");
                            dispose();//To close window after click Button
                            new Login();
                        }
                    }
                    catch(NumberFormatException r)
                    {
                        JOptionPane.showMessageDialog(null, "Enter only numbers");
                        Phone_NuberText.setText("");
                        IDText.setText("");
                        MRNText.setText("");
                    }
                }
            }
        }
    }