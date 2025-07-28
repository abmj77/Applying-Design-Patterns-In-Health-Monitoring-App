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

public class Support extends JFrame {
    private final JLabel label = new JLabel("\n\n WELCOME TO MONITORING RECORD SUPPORT", JLabel.CENTER);
    private final JLabel label1 = new JLabel("  YOUTUBE                 @monitoring_record_youtube", JLabel.LEFT);
    private final JLabel label2 = new JLabel("  LINKED IN                 @monitoring_record_linkedin", JLabel.LEFT);
    private final JLabel label3 = new JLabel("  INSTAGRAM             @monitoring_record_insta", JLabel.LEFT);
    private final JLabel label4 = new JLabel("  X                                @monitoring_record", JLabel.LEFT);
    private final JLabel label5 = new JLabel("  EMAIL                       monitoring_record@gmail.com", JLabel.LEFT);
    private final JLabel label6 = new JLabel("  MEETUP                      @monitoring_record_meetup", JLabel.LEFT);
    
    private final JPanel topPanel = new JPanel();
    private final JPanel bottomPanel = new JPanel();
    private final JPanel contentPanel = new JPanel(new GridLayout(6, 0));
    
    private final JButton okButton = new JButton("OK");
    
    public Support() {
        super.setTitle("Support");
        super.setSize(450, 470);
        super.setLocationRelativeTo(null);
        super.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    
        okButton.addActionListener(new OkButtonListener());
        
        okButton.setBackground(Color.WHITE);
        topPanel.setBackground(Color.WHITE);
        bottomPanel.setBackground(Color.DARK_GRAY);
        contentPanel.setBackground(Color.LIGHT_GRAY);
        
        topPanel.add(label);
        contentPanel.add(label5);
        contentPanel.add(label4);
        contentPanel.add(label6);
        contentPanel.add(label3);
        contentPanel.add(label2);
        contentPanel.add(label1);
        bottomPanel.add(okButton);
        
        add(topPanel, BorderLayout.NORTH);
        add(contentPanel, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);
        super.setVisible(true);
    }
    
    private class OkButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == okButton) {
                dispose();
                new LoginFactorySelector();
            }
        }
    }
}