package Monitoring_Record;


import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

    public class Check_Logout extends JFrame 
    {
        JLabel Label = new JLabel("Are You Sure You Want Exit From This Account" , JLabel.CENTER);
        JButton YesButton = new JButton("Yes");
        JButton CancelButton = new JButton("Cancel");
        JPanel p = new JPanel();
        public Check_Logout()
        {
            super.setTitle("Monitoring Record App");
            //super.setSize(300 , 100);
            super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            super.setLocationRelativeTo(null);
            
            YesButton.addActionListener(new Check());
            CancelButton.addActionListener(new Check());
            
            p.add(YesButton);
            p.add(CancelButton); 
            add(Label , BorderLayout.NORTH);
            add(p);
            pack();
            super.setVisible(true);
        }
        private class Check implements ActionListener
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                if(e.getSource() == YesButton)
                {
                    dispose();
                    Monitoring_Record_Window d = new Monitoring_Record_Window();
                    d.dispose();
                    new Login();
                    dispose();
                }
                if(e.getSource() == CancelButton)
                {
                    dispose();
                }
            }
        }
    }