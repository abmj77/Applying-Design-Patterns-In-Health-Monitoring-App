package Monitoring_Record;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Monitoring_Record_Window extends JFrame {
    private JTextArea textArea = new JTextArea(20, 20);
    private JButton monitoringRecordButton = new JButton("Monitoring record");
    private JButton saveFileButton = new JButton("Save file");
    private JPanel buttonPanel = new JPanel();
    private JScrollPane scrollPane = new JScrollPane(textArea);
    private JMenuBar menuBar = new JMenuBar();
    
    // Menu items
    private JMenu aboutMenu = new JMenu("About Us");
    private JMenuItem whoAreWeItem = new JMenuItem("Who Is Monitoring Record?");
    
    private JMenu askDoctorMenu = new JMenu("Consult Your Doctor");
    private JMenuItem doctor1 = new JMenuItem("Dr.Omar Alhibshi - Cardiology");
    private JMenuItem doctor2 = new JMenuItem("Dr.Abdullah Ali - Pediatrics");
    private JMenuItem doctor3 = new JMenuItem("Dr.Sara Mohammed - Dermatology");
    private JMenuItem doctor4 = new JMenuItem("Dr.Mashary Almazroi - Hematology");
    private JMenuItem doctor5 = new JMenuItem("Dr.Noor Khalid - Obstetrics and gynecology");
    
    private JMenu accountMenu = new JMenu("My Account"); 
    private JMenuItem profileItem = new JMenuItem("Account");
    private JMenuItem logoutItem = new JMenuItem("Logout");
    private JMenuItem contactItem = new JMenuItem("Contact Us");
    
    private JMenu appearanceMenu = new JMenu("Appearance");   
    private JMenu fontMenu = new JMenu("Font");                
    private JMenuItem dialogFont = new JMenuItem("Dialog");
    private JMenuItem dialogInputFont = new JMenuItem("DialogInput");
    private JMenuItem monospacedFont = new JMenuItem("Monospaced");
    private JMenuItem sansSerifFont = new JMenuItem("SansSerif");
    private JMenuItem serifFont = new JMenuItem("Serif");
    
    private JMenu styleMenu = new JMenu("Style");
    private JRadioButtonMenuItem boldStyle = new JRadioButtonMenuItem("Bold");
    private JRadioButtonMenuItem italicStyle = new JRadioButtonMenuItem("Italic");
    
    private JMenu themeMenu = new JMenu("Themes");
    private JMenuItem lightTheme = new JMenuItem("Light");
    private JMenuItem darkTheme = new JMenuItem("Dark");
    
    private JMenu sizeMenu = new JMenu("Font Size");
    private JMenuItem increaseSize = new JMenuItem("Increase");
    private JMenuItem decreaseSize = new JMenuItem("Decrease");
    
    private JMenuItem colorItem = new JMenuItem("Text Color");
    
    private JMenu hospitalsMenu = new JMenu("Supporting hospitals");
    private JMenuItem hospital1 = new JMenuItem("King Fahad Armed Forces Hospital");
    private JMenuItem hospital2 = new JMenuItem("King Faisal Specialist Hospital & Research Centre");
    private JMenuItem hospital3 = new JMenuItem("Dr.Soliman Fakeeh Hospital");
    private JMenuItem hospital4 = new JMenuItem("King Abdulaziz University Hospital");

    public Monitoring_Record_Window() {
        super.setTitle("Monitoring Record App");
        super.setSize(550, 470);
        super.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        super.setLocationRelativeTo(null);
        
        textArea.setBackground(Color.LIGHT_GRAY);
        textArea.setForeground(Color.RED);
        textArea.setEditable(false);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        
        monitoringRecordButton.addActionListener(new MonitoringRecordListener());
        monitoringRecordButton.setMnemonic(KeyEvent.VK_R);
        monitoringRecordButton.setToolTipText("Check Your Health");
        saveFileButton.addActionListener(new SaveFileListener());
        saveFileButton.setMnemonic(KeyEvent.VK_S);
        saveFileButton.setToolTipText("Save the text to your device");
        colorItem.setMnemonic(KeyEvent.VK_C);
        colorItem.setToolTipText("Change the color of displayed text");
        
        buttonPanel.add(saveFileButton);
        buttonPanel.add(monitoringRecordButton);
        
        textArea.setBackground(Color.WHITE);
        textArea.setForeground(Color.BLACK);
        menuBar.setBackground(Color.LIGHT_GRAY);
        accountMenu.setForeground(Color.BLACK);
        appearanceMenu.setForeground(Color.BLACK);
        hospitalsMenu.setForeground(Color.BLACK); 
        buttonPanel.setBackground(Color.LIGHT_GRAY);
        
        buildMenu();
        super.setJMenuBar(menuBar);
        super.add(scrollPane);
        super.add(buttonPanel, BorderLayout.SOUTH);
        super.setVisible(true);
    }

    public void setTextAreaText(String text) {
        textArea.setText(text);
    }

    private void buildMenu() {
        menuBar.add(appearanceMenu);
        appearanceMenu.add(fontMenu);
        fontMenu.add(dialogFont);
        fontMenu.add(dialogInputFont);
        fontMenu.add(monospacedFont);
        fontMenu.add(sansSerifFont);
        fontMenu.add(serifFont);
        fontMenu.add(styleMenu);
        styleMenu.add(boldStyle);
        styleMenu.add(italicStyle);
        appearanceMenu.addSeparator();
        appearanceMenu.add(sizeMenu);
        sizeMenu.add(increaseSize);
        sizeMenu.add(decreaseSize);
        appearanceMenu.addSeparator();
        appearanceMenu.add(colorItem);
        appearanceMenu.addSeparator();
        appearanceMenu.add(themeMenu);
        themeMenu.add(lightTheme);
        themeMenu.add(darkTheme);
        
        colorItem.addActionListener(new ColorChooserListener());
        lightTheme.addActionListener(new ThemeListener());
        darkTheme.addActionListener(new ThemeListener());
        dialogFont.addActionListener(new FontListener());
        dialogInputFont.addActionListener(new FontListener());
        monospacedFont.addActionListener(new FontListener());
        sansSerifFont.addActionListener(new FontListener());
        serifFont.addActionListener(new FontListener());
        boldStyle.addActionListener(new StyleListener());
        italicStyle.addActionListener(new StyleListener());
        increaseSize.addActionListener(new SizeListener());
        decreaseSize.addActionListener(new SizeListener());

        menuBar.add(hospitalsMenu);
        hospitalsMenu.add(hospital1);
        hospitalsMenu.add(hospital2);
        hospitalsMenu.add(hospital3);
        hospitalsMenu.add(hospital4);
        hospital1.addActionListener(new HospitalListener());
        hospital2.addActionListener(new HospitalListener());
        hospital3.addActionListener(new HospitalListener());
        hospital4.addActionListener(new HospitalListener());

        menuBar.add(askDoctorMenu);
        askDoctorMenu.add(doctor1);
        askDoctorMenu.add(doctor2);
        askDoctorMenu.add(doctor3);
        askDoctorMenu.add(doctor4);
        askDoctorMenu.add(doctor5);
        doctor1.addActionListener(new DoctorListener()); 
        doctor2.addActionListener(new DoctorListener()); 
        doctor3.addActionListener(new DoctorListener()); 
        doctor4.addActionListener(new DoctorListener()); 
        doctor5.addActionListener(new DoctorListener()); 
        
        menuBar.add(accountMenu); 
        accountMenu.add(profileItem);
        accountMenu.add(contactItem);
        accountMenu.add(logoutItem);
        profileItem.addActionListener(new AccountListener());
        contactItem.addActionListener(new AccountListener());
        logoutItem.addActionListener(new AccountListener());
        
        menuBar.add(aboutMenu);
        aboutMenu.add(whoAreWeItem);
        whoAreWeItem.addActionListener(new AboutListener());
    }

    private class AboutListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == whoAreWeItem) {   
                JOptionPane.showMessageDialog(null, 
                    "Monitoring Record is a revolutionary health application that allows patients to track their vital signs " +
                    "and receive medical recommendations based on their inputs. Our mission is to make healthcare more " +
                    "accessible and convenient for everyone.");
            }
        }
    }

    private class DoctorListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(null, 
                "Your consultation request has been successfully sent to the doctor. " +
                "You will receive a response within 24 hours.");
        }
    }

    private class HospitalListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == hospital1) {
                JOptionPane.showMessageDialog(null, 
                    "King Fahad Armed Forces Hospital\n" +
                    "Location: Jeddah\n" +
                    "Specialties: Comprehensive medical services\n" +
                    "Phone: +966 12 123 4567");
            } else if (e.getSource() == hospital2) {
                JOptionPane.showMessageDialog(null, 
                    "King Faisal Specialist Hospital & Research Centre\n" +
                    "Location: Riyadh\n" +
                    "Specialties: Advanced medical research and treatment\n" +
                    "Phone: +966 11 123 4567");
            } else if (e.getSource() == hospital3) {
                JOptionPane.showMessageDialog(null, 
                    "Dr. Soliman Fakeeh Hospital\n" +
                    "Location: Jeddah\n" +
                    "Specialties: Multi-specialty hospital\n" +
                    "Phone: +966 12 765 4321");
            } else if (e.getSource() == hospital4) {
                JOptionPane.showMessageDialog(null, 
                    "King Abdulaziz University Hospital\n" +
                    "Location: Jeddah\n" +
                    "Specialties: Teaching hospital with comprehensive services\n" +
                    "Phone: +966 12 987 6543");
            }
        }
    }

    private class MonitoringRecordListener implements ActionListener { 
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == monitoringRecordButton) {
                new Questionnaire(Monitoring_Record_Window.this);
            }
        }
    }

    private class AccountListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == profileItem) {
                JOptionPane.showMessageDialog(null, 
                    "Patient Profile\n\n" +
                    "Name: [Patient Name]\n" +
                    "MRN: [Medical Record Number]\n" +
                    "Age: [Age]\n" +
                    "Blood Type: [Blood Type]");
            } else if (e.getSource() == contactItem) {
                new Support();
                dispose();
            } else if (e.getSource() == logoutItem) {
                new Check_Logout();
                dispose();
            }
        }
    }

    private class SizeListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == increaseSize) {
                textArea.setFont(new Font(textArea.getFont().getFontName(), 
                    textArea.getFont().getStyle(), textArea.getFont().getSize() + 1));
            } else if (e.getSource() == decreaseSize) {
                textArea.setFont(new Font(textArea.getFont().getFontName(), 
                    textArea.getFont().getStyle(), textArea.getFont().getSize() - 1));
            }
        }
    }

    private class StyleListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int style = Font.PLAIN;
            if (boldStyle.isSelected()) style |= Font.BOLD;
            if (italicStyle.isSelected()) style |= Font.ITALIC;
            textArea.setFont(new Font(textArea.getFont().getFontName(), 
                style, textArea.getFont().getSize()));
        }
    }

    private class FontListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String fontName = "Dialog";
            if (e.getSource() == dialogFont) fontName = "Dialog";
            else if (e.getSource() == dialogInputFont) fontName = "DialogInput";
            else if (e.getSource() == monospacedFont) fontName = "Monospaced";
            else if (e.getSource() == sansSerifFont) fontName = "SansSerif";
            else if (e.getSource() == serifFont) fontName = "Serif";
            
            textArea.setFont(new Font(fontName, 
                textArea.getFont().getStyle(), textArea.getFont().getSize()));
        }
    }

    private class ThemeListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == lightTheme) {
                textArea.setBackground(Color.WHITE);
                textArea.setForeground(Color.BLACK);
                menuBar.setBackground(Color.LIGHT_GRAY);
                buttonPanel.setBackground(Color.LIGHT_GRAY);
            } else if (e.getSource() == darkTheme) {
                Color darkColor = new Color(0x4A4A4A);
                textArea.setBackground(darkColor);
                textArea.setForeground(Color.WHITE);
                menuBar.setBackground(darkColor);
                buttonPanel.setBackground(darkColor);
            }
        }
    }

    private class SaveFileListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JFileChooser fileChooser = new JFileChooser();
            int status = fileChooser.showSaveDialog(null);
            if (status == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();
                try {
                    PrintWriter writer = new PrintWriter(file.getPath());
                    writer.write(textArea.getText());
                    writer.close();
                    JOptionPane.showMessageDialog(null, "Your file has been saved: " + file.getPath());
                } catch (FileNotFoundException ex) {
                    textArea.setText(ex.getMessage());
                }
            }
            textArea.setText(null);
        }
    }

    private class ColorChooserListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Color selected = JColorChooser.showDialog(null, "Select text color", null);
            if (selected != null) {
                textArea.setForeground(selected);        
            }
        }
    }
}