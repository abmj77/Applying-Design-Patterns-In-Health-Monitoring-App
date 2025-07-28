// Monitoring_Record_Window.java
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
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
    JTextArea TextArea = new JTextArea(20, 20);
    JButton Monitoring_Record = new JButton("Monitoring record");
    JButton SaveFileButton = new JButton("Save file");
    JPanel Panel = new JPanel();
    JScrollPane ScrolPane = new JScrollPane(TextArea);
    JMenuBar MenuBar = new JMenuBar();

    // Menu items
    JMenu About = new JMenu("About Us");
    JMenuItem WhoAreUs = new JMenuItem("Who Is Monitoring Record?");
    JMenu AskDoctor = new JMenu("Consult Your Doctor");
    JMenuItem doctor1 = new JMenuItem("Dr.Omar Alhibshi - Cardiology");
    JMenuItem doctor2 = new JMenuItem("Dr.Abdullah Ali - Pediatrics");
    JMenuItem doctor3 = new JMenuItem("Dr.Sara Mohammed - Dermatology");
    JMenuItem doctor4 = new JMenuItem("Dr.Mashary Almazroi - Hematology ");
    JMenuItem doctor5 = new JMenuItem("Dr.Noor Khalid - Obstetrics and gynecology");

    JMenu AccountMenu = new JMenu("My Account");
    JMenuItem ProfiletmItem = new JMenuItem("Account");
    JMenuItem LogoutmItem = new JMenuItem("Logout");
    JMenuItem ContacttmItem = new JMenuItem("Contact Us");

    JMenu AppearanceMenu = new JMenu("Appearance");
    JMenu FontMenu = new JMenu("Font");
    JMenuItem fmItem1 = new JMenuItem("Dialog");
    JMenuItem fmItem2 = new JMenuItem("DialogInput");
    JMenuItem fmItem3 = new JMenuItem("Monospaced");
    JMenuItem fmItem4 = new JMenuItem("SansSerif");
    JMenuItem fmItem5 = new JMenuItem("Serif");

    JMenu StyleMenu = new JMenu("Style");
    JRadioButtonMenuItem RadioBoldMenuItem = new JRadioButtonMenuItem("Bold");
    JRadioButtonMenuItem RadioItalicMenuItem = new JRadioButtonMenuItem("Italic");

    JMenu backgroundColorMenu = new JMenu("Themes");
    JMenuItem mItemWhite = new JMenuItem("Light");
    JMenuItem mItemBlack = new JMenuItem("Dark");

    JMenu sizeMenu = new JMenu("Font Size");
    JMenuItem mItemIncrease = new JMenuItem("Increase");
    JMenuItem mItemDecrease = new JMenuItem("Decrease");

    JMenuItem ColorItem = new JMenuItem("Text Color");

    JMenu Hospitals = new JMenu("Supporting hospitals");
    JMenuItem h1 = new JMenuItem("King Fahad Armed Forces Hospital");
    JMenuItem h2 = new JMenuItem("King Faisal Specialist Hospital & Research Centre");
    JMenuItem h3 = new JMenuItem("Dr.Soliman Fakeeh Hospital");
    JMenuItem h4 = new JMenuItem("King Abdulaziz University Hospital");

    // MEMENTO PATTERN
    private final JButton undoButton = new JButton("Undo");
    private final JButton redoButton = new JButton("Redo");
    private final Originator originator = new Originator();
    private final Caretaker caretaker = new Caretaker();

    public Monitoring_Record_Window() {
        super.setTitle("Monitoring Record App");
        super.setSize(550, 470);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setLocationRelativeTo(null);

        TextArea.setBackground(Color.WHITE);
        TextArea.setForeground(Color.BLACK);
        TextArea.setEditable(false);

        ScrolPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        ScrolPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        Monitoring_Record.addActionListener(new MRListener());
        Monitoring_Record.setMnemonic(KeyEvent.VK_R);
        Monitoring_Record.setToolTipText("Check For Your Health");

        SaveFileButton.addActionListener(new SaveFileAction());
        SaveFileButton.setMnemonic(KeyEvent.VK_S);
        SaveFileButton.setToolTipText("Save the text to your device");

        ColorItem.setMnemonic(KeyEvent.VK_C);
        ColorItem.setToolTipText("Change the color of displayed text");

        // Add Undo & Redo Buttons
        Panel.add(undoButton);
        Panel.add(redoButton);
        Panel.add(SaveFileButton);
        Panel.add(Monitoring_Record);

        Panel.setBackground(Color.LIGHT_GRAY);
        buildMenu();
        super.setJMenuBar(MenuBar);
        super.add(ScrolPane);
        super.add(Panel, BorderLayout.SOUTH);

        // Initialize undo/redo
        updateUndoRedoButtons();

        super.setVisible(true);
    }

    // Append new entry with timestamp
    public void appendToTextArea(String entry) {
        String timestamp = getTimeStamp();
        String fullEntry = "[" + timestamp + "] " + entry;
        String current = TextArea.getText().trim();
        String newText = current.isEmpty() ? fullEntry : current + "\n" + fullEntry;
        setTextAreaText(newText);
    }

    public void setTextAreaText(String text) {
    originator.set(TextArea.getText()); // Save current state
    caretaker.addMemento(originator.storeInMemento());
    TextArea.setText(text); // Set new state
    updateUndoRedoButtons();
}
    private void updateUndoRedoButtons() {
        undoButton.setEnabled(caretaker.canUndo());
        redoButton.setEnabled(caretaker.canRedo());
    }

    private String getTimeStamp() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
    }

    private void buildMenu() {
        MenuBar.add(AppearanceMenu);
        AppearanceMenu.add(FontMenu);
        FontMenu.add(fmItem1); FontMenu.add(fmItem2); FontMenu.add(fmItem3);
        FontMenu.add(fmItem4); FontMenu.add(fmItem5);
        AppearanceMenu.add(StyleMenu);
        StyleMenu.add(RadioBoldMenuItem); StyleMenu.add(RadioItalicMenuItem);
        AppearanceMenu.addSeparator();
        AppearanceMenu.add(sizeMenu);
        sizeMenu.add(mItemIncrease); sizeMenu.add(mItemDecrease);
        AppearanceMenu.addSeparator();
        AppearanceMenu.add(ColorItem);
        AppearanceMenu.addSeparator();
        AppearanceMenu.add(backgroundColorMenu);
        backgroundColorMenu.add(mItemWhite); backgroundColorMenu.add(mItemBlack);

        ColorItem.addActionListener(new ColorChooserAction());
        mItemWhite.addActionListener(new BackGroundColorAction());
        mItemBlack.addActionListener(new BackGroundColorAction());
        fmItem1.addActionListener(new FontNameAction());
        fmItem2.addActionListener(new FontNameAction());
        fmItem3.addActionListener(new FontNameAction());
        fmItem4.addActionListener(new FontNameAction());
        fmItem5.addActionListener(new FontNameAction());
        RadioBoldMenuItem.addActionListener(new FontStyleAction());
        RadioItalicMenuItem.addActionListener(new FontStyleAction());
        mItemIncrease.addActionListener(new FontSizeAction());
        mItemDecrease.addActionListener(new FontSizeAction());

        MenuBar.add(Hospitals);
        Hospitals.add(h1); Hospitals.add(h2); Hospitals.add(h3); Hospitals.add(h4);
        h1.addActionListener(new hlistener());
        h2.addActionListener(new hlistener());
        h3.addActionListener(new hlistener());
        h4.addActionListener(new hlistener());

        MenuBar.add(AskDoctor);
        AskDoctor.add(doctor1); AskDoctor.add(doctor2); AskDoctor.add(doctor3);
        AskDoctor.add(doctor4); AskDoctor.add(doctor5);
        doctor1.addActionListener(new DoctorMenu());
        doctor2.addActionListener(new DoctorMenu());
        doctor3.addActionListener(new DoctorMenu());
        doctor4.addActionListener(new DoctorMenu());
        doctor5.addActionListener(new DoctorMenu());

        MenuBar.add(AccountMenu);
        AccountMenu.add(ProfiletmItem);
        AccountMenu.add(ContacttmItem);
        AccountMenu.add(LogoutmItem);
        ProfiletmItem.addActionListener(new AccountAction());
        ContacttmItem.addActionListener(new AccountAction());
        LogoutmItem.addActionListener(new AccountAction());

        MenuBar.add(About);
        About.add(WhoAreUs);
        WhoAreUs.addActionListener(new AboutusAct());

        // Undo & Redo Listeners
        // Undo Button Listener
undoButton.addActionListener(e -> {
    Memento m = caretaker.undo();
    if (m != null) {
        String prev = originator.restoreFromMemento(m);
        TextArea.setText(prev);
        updateUndoRedoButtons();
    }
});

// Redo Button Listener
redoButton.addActionListener(e -> {
    Memento m = caretaker.redo();
    if (m != null) {
        String next = originator.restoreFromMemento(m);
        TextArea.setText(next);
        updateUndoRedoButtons();
    }
});
    }

    private class AboutusAct implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            appendToTextArea("Viewed: Who Is Monitoring Record?");
            JOptionPane.showMessageDialog(null, "It is a revolutionary health application designed to monitor vital signs and provide timely medical guidance.");
        }
    }

    private class DoctorMenu implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        String doctorName = ((JMenuItem) e.getSource()).getText();
        String entry = "[" + getTimeStamp() + "] Consultation request sent to: " + doctorName;

        String current = TextArea.getText();
        if (current.isEmpty()) current = "Monitoring Record History\n" + "=".repeat(50);

        setTextAreaText(current + "\n" + entry);
        JOptionPane.showMessageDialog(null, "Your request has been successfully sent to " + doctorName);
    }
}
    private class hlistener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        String hospitalName = "";
        if (e.getSource() == h1) hospitalName = "King Fahad Armed Forces Hospital";
        else if (e.getSource() == h2) hospitalName = "King Faisal Specialist Hospital & Research Centre";
        else if (e.getSource() == h3) hospitalName = "Dr.Soliman Fakeeh Hospital";
        else if (e.getSource() == h4) hospitalName = "King Abdulaziz University Hospital";

        String entry = "[" + getTimeStamp() + "] Viewed hospital details: " + hospitalName;

        String current = TextArea.getText();
        if (current.isEmpty()) current = "Monitoring Record History\n" + "=".repeat(50);

        setTextAreaText(current + "\n" + entry);
        JOptionPane.showMessageDialog(null, "Hospital Name: " + hospitalName + "\nLocation: Jeddah, Saudi Arabia\nRating: 4.8★\nServices: Emergency, ICU, Surgery, Pediatrics");
    }
}

    private class MRListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            appendToTextArea("Opened vital signs questionnaire");
            new Questionnaire(Monitoring_Record_Window.this);
        }
    }

    private class AccountAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == ProfiletmItem) {
                appendToTextArea("Viewed profile");
                JOptionPane.showMessageDialog(null, "Name : Abdulmajeed Abdullah...\nAge : 21\nGender : Male\nMRN : 12782");
            } else if (e.getSource() == ContacttmItem) {
                appendToTextArea("Opened support");
                new Support();
            } else if (e.getSource() == LogoutmItem) {
                appendToTextArea("Logged out");
                new Check_Logout();
            }
        }
    }

    private class FontSizeAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == mItemIncrease) {
                TextArea.setFont(new Font(TextArea.getFont().getFontName(),
                        TextArea.getFont().getStyle(), TextArea.getFont().getSize() + 1));
            } else if (e.getSource() == mItemDecrease) {
                TextArea.setFont(new Font(TextArea.getFont().getFontName(),
                        TextArea.getFont().getStyle(), TextArea.getFont().getSize() - 1));
            }
        }
    }

    private class FontStyleAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int style = Font.PLAIN;
            if (RadioBoldMenuItem.isSelected()) style |= Font.BOLD;
            if (RadioItalicMenuItem.isSelected()) style |= Font.ITALIC;
            TextArea.setFont(new Font(TextArea.getFont().getFontName(),
                    style, TextArea.getFont().getSize()));
        }
    }

    private class FontNameAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String fontName = "Dialog";
            if (e.getSource() == fmItem1) fontName = "Dialog";
            else if (e.getSource() == fmItem2) fontName = "DialogInput";
            else if (e.getSource() == fmItem3) fontName = "Monospaced";
            else if (e.getSource() == fmItem4) fontName = "SansSerif";
            else if (e.getSource() == fmItem5) fontName = "Serif";
            TextArea.setFont(new Font(fontName,
                    TextArea.getFont().getStyle(), TextArea.getFont().getSize()));
        }
    }

    private class BackGroundColorAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == mItemWhite) {
                TextArea.setBackground(Color.WHITE);
                TextArea.setForeground(Color.BLACK);
                MenuBar.setBackground(Color.LIGHT_GRAY);
                Panel.setBackground(Color.LIGHT_GRAY);
            } else if (e.getSource() == mItemBlack) {
                Color color = new Color(0x4A4A4A);
                TextArea.setBackground(color);
                TextArea.setForeground(Color.WHITE);
                MenuBar.setBackground(color);
                Panel.setBackground(color);
            }
        }
    }

    private class SaveFileAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JFileChooser fc = new JFileChooser();
            int status = fc.showSaveDialog(null);
            if (status == JFileChooser.APPROVE_OPTION) {
                File f = fc.getSelectedFile();
                try {
                    PrintWriter pt = new PrintWriter(f.getPath());
                    pt.write(TextArea.getText());
                    pt.close();
                    appendToTextArea("Saved file: " + f.getPath());
                    JOptionPane.showMessageDialog(null, "Your file is saved: " + f.getPath());
                } catch (FileNotFoundException ex) {
                    appendToTextArea("Error saving file: " + ex.getMessage());
                    JOptionPane.showMessageDialog(null, "Error saving file: " + ex.getMessage());
                }
            }
        }
    }

    private class ColorChooserAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Color selected = JColorChooser.showDialog(null, "Select text color", TextArea.getForeground());
            if (selected != null) {
                TextArea.setForeground(selected);
                appendToTextArea("Changed text color");
            }
        }
    }
}