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

    public class Support extends JFrame
    {
        private final JLabel Label = new JLabel("\n\n WELLCOM TO MOTORING RECORD SUPPORT", JLabel.CENTER);
        private final JLabel Label1 = new JLabel("  YOUTUBE                 @monotiring_recordyoutube", JLabel.LEFT);
        private final JLabel Label2 = new JLabel("  LINKED IN                 @monotiring_recordin", JLabel.LEFT);
        private final JLabel Label3 = new JLabel("  INSTAGRAM             @monotiring_recordinsta", JLabel.LEFT);
        private final JLabel Label4 = new JLabel("  X                                @monotiring_record", JLabel.LEFT);
        private final JLabel Label5 = new JLabel("  EMAIL                       monotiring_record@gmail.com", JLabel.LEFT);
        private final JLabel Label6 = new JLabel("  MEETA                      @monotiring_recordmeeta", JLabel.LEFT);
        
        private final JPanel p1 = new JPanel();
        private final JPanel p2 = new JPanel();
        private final JPanel p3 = new JPanel(new GridLayout(6,0));
        
        private final JButton OKButton = new JButton("OK");
        
        public Support()
        {
            super.setTitle("Support");
            super.setSize(450 , 470);
            super.setLocationRelativeTo(null);
            super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        
            OKButton.addActionListener(new Ok());
            
            OKButton.setBackground(Color.WHITE);
            p1.setBackground(Color.WHITE);
            p2.setBackground(Color.DARK_GRAY);
            p3.setBackground(Color.LIGHT_GRAY);
            
            p1.add(Label);
            p3.add(Label5);
            p3.add(Label4);
            p3.add(Label6);
            p3.add(Label3);
            p3.add(Label2);
            p3.add(Label1);
            p2.add(OKButton);
            
            add(p1, BorderLayout.NORTH);
            add(p3, BorderLayout.CENTER);
            add(p2, BorderLayout.SOUTH);
            super.setVisible(true);
        }
        
        private class Ok implements ActionListener
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                if(e.getSource() == OKButton)
                {
                    dispose();
                    new Login();
                }
            }
        }
    } 