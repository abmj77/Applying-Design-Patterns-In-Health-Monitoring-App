package Monitoring_Record;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import static java.awt.Image.SCALE_AREA_AVERAGING;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;
import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;

public class Questionnaire extends JFrame {
    private Monitoring_Record_Window monitoringWindow;
    private JPanel mainPanel;
    private JButton nextButton;
    private JButton previousButton;
    private JButton done;
    String[] questions;
    private JComboBox<String> questionSelector;
    private JPanel buttonsPanel;

    private CardLayout cardLayout;
    private BorderLayout borderLayout;
    private GridLayout gridLayout;

    // Question panels
    private JPanel mainQuestionPanel1;
    private JLabel label1;
    private JPanel multipleChoicePanel1;
    private JRadioButton q1Choice1;
    private JRadioButton q1Choice2;
    private JRadioButton q1Choice3;
    private JRadioButton q1Choice4;
    ButtonGroup buttonGroup1;

    private JPanel mainQuestionPanel2;
    private JLabel label2;
    private JPanel multipleChoicePanel2;
    private JRadioButton q2Choice1;
    private JRadioButton q2Choice2;
    private JRadioButton q2Choice3;
    private JRadioButton q2Choice4;
    private ButtonGroup buttonGroup2;

    private JPanel mainQuestionPanel3;
    private JLabel label3;
    private JPanel multipleChoicePanel3;
    private JRadioButton q3Choice1;
    private JRadioButton q3Choice2;
    private JRadioButton q3Choice3;
    private JRadioButton q3Choice4;
    private ButtonGroup buttonGroup3;

    private JPanel mainQuestionPanel4;
    private JLabel label4;
    private JPanel multipleChoicePanel4;
    private JRadioButton q4Choice1;
    private JRadioButton q4Choice2;
    private JRadioButton q4Choice3;
    private JRadioButton q4Choice4;
    private ButtonGroup buttonGroup4;

    private JPanel mainQuestionPanel5;
    private JLabel label5;
    private JPanel multipleChoicePanel5;
    private JRadioButton q5Choice1;
    private JRadioButton q5Choice2;
    private JRadioButton q5Choice3;
    private JRadioButton q5Choice4;
    private ButtonGroup buttonGroup5;

    private JPanel mainQuestionPanel6;
    private JLabel label6;
    private JPanel multipleChoicePanel6;
    private JRadioButton q6Choice1;
    private JRadioButton q6Choice2;
    private JRadioButton q6Choice3;
    private JRadioButton q6Choice4;
    private ButtonGroup buttonGroup6;

    private JPanel mainQuestionPanel7;
    private JLabel label7;
    private JPanel multipleChoicePanel7;
    private JRadioButton q7Choice1;
    private JRadioButton q7Choice2;
    private JRadioButton q7Choice3;
    private JRadioButton q7Choice4;
    private ButtonGroup buttonGroup7;

    private JPanel mainQuestionPanel8;
    private JLabel label8;
    private JPanel multipleChoicePanel8;
    private JRadioButton q8Choice1;
    private JRadioButton q8Choice2;
    private JRadioButton q8Choice3;
    private JRadioButton q8Choice4;
    private ButtonGroup buttonGroup8;

    private JPanel mainQuestionPanel9;
    private JLabel label9;
    private JPanel multipleChoicePanel9;
    private JRadioButton q9Choice1;
    private JRadioButton q9Choice2;
    private JRadioButton q9Choice3;
    private JRadioButton q9Choice4;
    private ButtonGroup buttonGroup9;

    private JPanel mainQuestionPanel10;
    private JLabel label10;
    private JPanel multipleChoicePanel10;
    private JRadioButton q10Choice1;
    private JRadioButton q10Choice2;
    private JRadioButton q10Choice3;
    private JRadioButton q10Choice4;
    private ButtonGroup buttonGroup10;

    public Questionnaire(Monitoring_Record_Window monitoringWindow) {
        this.monitoringWindow = monitoringWindow;
        BasicComponent();
        createQuestion1();
        createQuestion2();
        createQuestion3();
        createQuestion4();
        createQuestion5();
        createQuestion6();
        createQuestion7();
        createQuestion8();
        createQuestion9();
        createQuestion10();

        mainPanel.add(mainQuestionPanel1, "Question1");
        mainPanel.add(mainQuestionPanel2, "Question2");
        mainPanel.add(mainQuestionPanel3, "Question3");
        mainPanel.add(mainQuestionPanel4, "Question4");
        mainPanel.add(mainQuestionPanel5, "Question5");
        mainPanel.add(mainQuestionPanel6, "Question6");
        mainPanel.add(mainQuestionPanel7, "Question7");
        mainPanel.add(mainQuestionPanel8, "Question8");
        mainPanel.add(mainQuestionPanel9, "Question9");
        mainPanel.add(mainQuestionPanel10, "Question10");

        add(mainPanel, BorderLayout.CENTER);
        add(buttonsPanel, BorderLayout.SOUTH);

        setLocation(600, 200);
        setTitle("Questionnaire");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(600, 300);
        setResizable(true);
        setVisible(true);
    }

    public void BasicComponent() {
        cardLayout = new CardLayout();
        borderLayout = new BorderLayout();
        gridLayout = new GridLayout(4, 1, 0, 0);

        mainPanel = new JPanel(cardLayout);
        nextButton = new JButton("Next");
        previousButton = new JButton("Previous");
        done = new JButton("Done");

        buttonsPanel = new JPanel();
        buttonsPanel.add(done);
        buttonsPanel.add(nextButton);
        buttonsPanel.add(previousButton);

        nextButton.addActionListener(new ButtonsAction());
        previousButton.addActionListener(new ButtonsAction());
        done.addActionListener(new radioButtonsAction());

        questions = new String[]{"Question1", "Question2", "Question3", "Question4", "Question5",
                "Question6", "Question7", "Question8", "Question9", "Question10"};

        questionSelector = new JComboBox<>(questions);
        buttonsPanel.add(questionSelector);

        questionSelector.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String questionName = (String) questionSelector.getSelectedItem();
                cardLayout.show(mainPanel, questionName);
            }
        });
    }

    public void createQuestion1() {
        mainQuestionPanel1 = new JPanel(new BorderLayout());
        label1 = new JLabel("Question 1: What is your blood pressure today?");
        label1.setBorder(BorderFactory.createEmptyBorder(0, 0, 5, 0));

        multipleChoicePanel1 = new JPanel(gridLayout);
        Color color = new Color(0x4A4A4A);
        buttonsPanel.setBackground(color);
                
        q1Choice1 = new JRadioButton("Below 120/80 mmHg");
        q1Choice2 = new JRadioButton("120-139/80-89 mmHg");
        q1Choice3 = new JRadioButton("140-159/90-99 mmHg");
        q1Choice4 = new JRadioButton("Above 160/100 mmHg");

        buttonGroup1 = new ButtonGroup();
        buttonGroup1.add(q1Choice1);
        buttonGroup1.add(q1Choice2);
        buttonGroup1.add(q1Choice3);
        buttonGroup1.add(q1Choice4);

        multipleChoicePanel1.add(q1Choice1);
        multipleChoicePanel1.add(q1Choice2);
        multipleChoicePanel1.add(q1Choice3);
        multipleChoicePanel1.add(q1Choice4);

        mainQuestionPanel1.add(label1, BorderLayout.NORTH);
        mainQuestionPanel1.add(multipleChoicePanel1, BorderLayout.CENTER);
    }

    public void createQuestion2() {
        mainQuestionPanel2 = new JPanel(new BorderLayout());
        label2 = new JLabel("Question 2: What is your heart rate (pulse) today?");
        label2.setBorder(BorderFactory.createEmptyBorder(0, 0, 5, 0));

        multipleChoicePanel2 = new JPanel(gridLayout);

        q2Choice1 = new JRadioButton("60-100 bpm");
        q2Choice2 = new JRadioButton("Below 60 bpm");
        q2Choice3 = new JRadioButton("101-120 bpm");
        q2Choice4 = new JRadioButton("Above 120 bpm");

        buttonGroup2 = new ButtonGroup();
        buttonGroup2.add(q2Choice1);
        buttonGroup2.add(q2Choice2);
        buttonGroup2.add(q2Choice3);
        buttonGroup2.add(q2Choice4);

        multipleChoicePanel2.add(q2Choice1);
        multipleChoicePanel2.add(q2Choice2);
        multipleChoicePanel2.add(q2Choice3);
        multipleChoicePanel2.add(q2Choice4);

        mainQuestionPanel2.add(label2, BorderLayout.NORTH);
        mainQuestionPanel2.add(multipleChoicePanel2, BorderLayout.CENTER);
    }

    public void createQuestion3() {
        mainQuestionPanel3 = new JPanel(new BorderLayout());
        label3 = new JLabel("Question 3: What is your body temperature today?");
        label3.setBorder(BorderFactory.createEmptyBorder(0, 0, 5, 0));

        multipleChoicePanel3 = new JPanel(gridLayout);

        q3Choice1 = new JRadioButton("36.1°C to 37.2°C");
        q3Choice2 = new JRadioButton("Below 36.1°C");
        q3Choice3 = new JRadioButton("37.3°C to 38°C");
        q3Choice4 = new JRadioButton("Above 38°C");

        buttonGroup3 = new ButtonGroup();
        buttonGroup3.add(q3Choice1);
        buttonGroup3.add(q3Choice2);
        buttonGroup3.add(q3Choice3);
        buttonGroup3.add(q3Choice4);

        multipleChoicePanel3.add(q3Choice1);
        multipleChoicePanel3.add(q3Choice2);
        multipleChoicePanel3.add(q3Choice3);
        multipleChoicePanel3.add(q3Choice4);

        mainQuestionPanel3.add(label3, BorderLayout.NORTH);
        mainQuestionPanel3.add(multipleChoicePanel3, BorderLayout.CENTER);
    }

    public void createQuestion4() {
        mainQuestionPanel4 = new JPanel(new BorderLayout());
        label4 = new JLabel("Question 4: What is your respiratory rate today?");
        label4.setBorder(BorderFactory.createEmptyBorder(0, 0, 5, 0));

        multipleChoicePanel4 = new JPanel(gridLayout);

        q4Choice1 = new JRadioButton("12-16 breaths per minute");
        q4Choice2 = new JRadioButton("Below 12 breaths per minute");
        q4Choice3 = new JRadioButton("17-20 breaths per minute");
        q4Choice4 = new JRadioButton("Above 20 breaths per minute");

        buttonGroup4 = new ButtonGroup();
        buttonGroup4.add(q4Choice1);
        buttonGroup4.add(q4Choice2);
        buttonGroup4.add(q4Choice3);
        buttonGroup4.add(q4Choice4);

        multipleChoicePanel4.add(q4Choice1);
        multipleChoicePanel4.add(q4Choice2);
        multipleChoicePanel4.add(q4Choice3);
        multipleChoicePanel4.add(q4Choice4);

        mainQuestionPanel4.add(label4, BorderLayout.NORTH);
        mainQuestionPanel4.add(multipleChoicePanel4, BorderLayout.CENTER);
    }

    public void createQuestion5() {
        mainQuestionPanel5 = new JPanel(new BorderLayout());
        label5 = new JLabel("Question 5: What is your blood oxygen saturation (SpO2) level today?");
        label5.setBorder(BorderFactory.createEmptyBorder(0, 0, 5, 0));

        multipleChoicePanel5 = new JPanel(gridLayout);

        q5Choice1 = new JRadioButton("95-100%");
        q5Choice2 = new JRadioButton("91-94%");
        q5Choice3 = new JRadioButton("86-90%");
        q5Choice4 = new JRadioButton("Below 85%");

        buttonGroup5 = new ButtonGroup();
        buttonGroup5.add(q5Choice1);
        buttonGroup5.add(q5Choice2);
        buttonGroup5.add(q5Choice3);
        buttonGroup5.add(q5Choice4);

        multipleChoicePanel5.add(q5Choice1);
        multipleChoicePanel5.add(q5Choice2);
        multipleChoicePanel5.add(q5Choice3);
        multipleChoicePanel5.add(q5Choice4);

        mainQuestionPanel5.add(label5, BorderLayout.NORTH);
        mainQuestionPanel5.add(multipleChoicePanel5, BorderLayout.CENTER);
    }

    public void createQuestion6() {
        mainQuestionPanel6 = new JPanel(new BorderLayout());
        label6 = new JLabel("Question 6: What are your blood glucose levels today?");
        label6.setBorder(BorderFactory.createEmptyBorder(0, 0, 5, 0));

        multipleChoicePanel6 = new JPanel(gridLayout);

        q6Choice1 = new JRadioButton("70-99 mg/dL");
        q6Choice2 = new JRadioButton("Below 70 mg/dL");
        q6Choice3 = new JRadioButton("100-125 mg/dL");
        q6Choice4 = new JRadioButton("Above 126 mg/dL");

        buttonGroup6 = new ButtonGroup();
        buttonGroup6.add(q6Choice1);
        buttonGroup6.add(q6Choice2);
        buttonGroup6.add(q6Choice3);
        buttonGroup6.add(q6Choice4);

        multipleChoicePanel6.add(q6Choice1);
        multipleChoicePanel6.add(q6Choice2);
        multipleChoicePanel6.add(q6Choice3);
        multipleChoicePanel6.add(q6Choice4);

        mainQuestionPanel6.add(label6, BorderLayout.NORTH);
        mainQuestionPanel6.add(multipleChoicePanel6, BorderLayout.CENTER);
    }

    public void createQuestion7() {
        mainQuestionPanel7 = new JPanel(new BorderLayout());
        label7 = new JLabel("Question 7: What is your pain level today? (On a scale of 0-10)");
        label7.setBorder(BorderFactory.createEmptyBorder(0, 0, 5, 0));

        multipleChoicePanel7 = new JPanel(gridLayout);

        q7Choice1 = new JRadioButton("0 (No pain)");
        q7Choice2 = new JRadioButton("1-3 (Mild pain)");
        q7Choice3 = new JRadioButton("4-6 (Moderate pain)");
        q7Choice4 = new JRadioButton("7-10 (Severe pain)");

        buttonGroup7 = new ButtonGroup();
        buttonGroup7.add(q7Choice1);
        buttonGroup7.add(q7Choice2);
        buttonGroup7.add(q7Choice3);
        buttonGroup7.add(q7Choice4);

        multipleChoicePanel7.add(q7Choice1);
        multipleChoicePanel7.add(q7Choice2);
        multipleChoicePanel7.add(q7Choice3);
        multipleChoicePanel7.add(q7Choice4);

        mainQuestionPanel7.add(label7, BorderLayout.NORTH);
        mainQuestionPanel7.add(multipleChoicePanel7, BorderLayout.CENTER);
    }

    public void createQuestion8() {
        mainQuestionPanel8 = new JPanel(new BorderLayout());
        label8 = new JLabel("Question 8: How many hours did you sleep last week?");
        label8.setBorder(BorderFactory.createEmptyBorder(0, 0, 5, 0));

        multipleChoicePanel8 = new JPanel(gridLayout);

        q8Choice1 = new JRadioButton("7-9 hours per day");
        q8Choice2 = new JRadioButton("More than 9 hours per day");
        q8Choice3 = new JRadioButton("4-6 hours per day");
        q8Choice4 = new JRadioButton("Less than 4 hours per day");

        buttonGroup8 = new ButtonGroup();
        buttonGroup8.add(q8Choice1);
        buttonGroup8.add(q8Choice2);
        buttonGroup8.add(q8Choice3);
        buttonGroup8.add(q8Choice4);

        multipleChoicePanel8.add(q8Choice1);
        multipleChoicePanel8.add(q8Choice2);
        multipleChoicePanel8.add(q8Choice3);
        multipleChoicePanel8.add(q8Choice4);

        mainQuestionPanel8.add(label8, BorderLayout.NORTH);
        mainQuestionPanel8.add(multipleChoicePanel8, BorderLayout.CENTER);
    }

    public void createQuestion9() {
        mainQuestionPanel9 = new JPanel(new BorderLayout());
        label9 = new JLabel("Question 9: What is your current mood?");
        label9.setBorder(BorderFactory.createEmptyBorder(0, 0, 5, 0));

        multipleChoicePanel9 = new JPanel(gridLayout);

        q9Choice1 = new JRadioButton("Happy/Content");
        q9Choice2 = new JRadioButton("Neutral");
        q9Choice3 = new JRadioButton("Anxious/Stressed");
        q9Choice4 = new JRadioButton("Sad/Depressed");

        buttonGroup9 = new ButtonGroup();
        buttonGroup9.add(q9Choice1);
        buttonGroup9.add(q9Choice2);
        buttonGroup9.add(q9Choice3);
        buttonGroup9.add(q9Choice4);

        multipleChoicePanel9.add(q9Choice1);
        multipleChoicePanel9.add(q9Choice2);
        multipleChoicePanel9.add(q9Choice3);
        multipleChoicePanel9.add(q9Choice4);

        mainQuestionPanel9.add(label9, BorderLayout.NORTH);
        mainQuestionPanel9.add(multipleChoicePanel9, BorderLayout.CENTER);
    }

    public void createQuestion10() {
        mainQuestionPanel10 = new JPanel(new BorderLayout());
        label10 = new JLabel("Question 10: Are you thinking about hurting yourself these days?");
        label10.setBorder(BorderFactory.createEmptyBorder(0, 0, 5, 0));

        multipleChoicePanel10 = new JPanel(gridLayout);

        q10Choice1 = new JRadioButton("Never");
        q10Choice2 = new JRadioButton("Rarely");
        q10Choice3 = new JRadioButton("Sometimes");
        q10Choice4 = new JRadioButton("A lot");

        buttonGroup10 = new ButtonGroup();
        buttonGroup10.add(q10Choice1);
        buttonGroup10.add(q10Choice2);
        buttonGroup10.add(q10Choice3);
        buttonGroup10.add(q10Choice4);

        multipleChoicePanel10.add(q10Choice1);
        multipleChoicePanel10.add(q10Choice2);
        multipleChoicePanel10.add(q10Choice3);
        multipleChoicePanel10.add(q10Choice4);

        mainQuestionPanel10.add(label10, BorderLayout.NORTH);
        mainQuestionPanel10.add(multipleChoicePanel10, BorderLayout.CENTER);
    }

    private class ButtonsAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == nextButton)
                cardLayout.next(mainPanel);
            else if (e.getSource() == previousButton)
                cardLayout.previous(mainPanel);
        }
    }

    private class radioButtonsAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == done) {
                StringBuilder allSelectedOptions = new StringBuilder("Your vital signs:\n\n");
                boolean needsHospitalVisit = false;

                needsHospitalVisit |= checkAndAppend(buttonGroup1, allSelectedOptions, q1Choice4.getText());
                needsHospitalVisit |= checkAndAppend(buttonGroup2, allSelectedOptions, q2Choice4.getText());
                needsHospitalVisit |= checkAndAppend(buttonGroup3, allSelectedOptions, q3Choice4.getText());
                needsHospitalVisit |= checkAndAppend(buttonGroup4, allSelectedOptions, q4Choice4.getText());
                needsHospitalVisit |= checkAndAppend(buttonGroup5, allSelectedOptions, q5Choice4.getText());
                needsHospitalVisit |= checkAndAppend(buttonGroup6, allSelectedOptions, q6Choice4.getText());
                needsHospitalVisit |= checkAndAppend(buttonGroup7, allSelectedOptions, q7Choice4.getText());
                needsHospitalVisit |= checkAndAppend(buttonGroup8, allSelectedOptions, "");
                needsHospitalVisit |= checkAndAppend(buttonGroup9, allSelectedOptions, "");
                needsHospitalVisit |= checkAndAppend(buttonGroup10, allSelectedOptions, "");

                needsHospitalVisit |= multiSymptoms(buttonGroup8) &&
                        multiSymptoms(buttonGroup9) &&
                        multiSymptoms(buttonGroup10);
                
                monitoringWindow.setTextAreaText(allSelectedOptions.toString() +
                        " ---------------------------------------------------\n");
                
                if (needsHospitalVisit) {
                    JOptionPane.showMessageDialog(null, "You need to go to the hospital");
                } else {
                    JOptionPane.showMessageDialog(null, "Your vital signs are good " +
                            "so you do not need to go to a hospital\n" +
                            "Notes that in the below choices " +
                            "if the difference is high you need to go to a hospital");
                }
                dispose();
            }
        }

        private boolean checkAndAppend(ButtonGroup buttonGroup, StringBuilder builder, String criticalCondition) {
            Enumeration<AbstractButton> buttons = buttonGroup.getElements();
            while (buttons.hasMoreElements()) {
                AbstractButton button = buttons.nextElement();
                if (button.isSelected()) {
                    builder.append(button.getText()).append("\n");
                    if (button.getText().equals(criticalCondition)) {
                        return true;
                    }
                    break;
                }
            }
            return false;
        }

        private boolean multiSymptoms(ButtonGroup buttonGroup) {
            Enumeration<AbstractButton> buttons = buttonGroup.getElements();
            int index = 0;
            while (buttons.hasMoreElements()) {
                AbstractButton button = buttons.nextElement();
                if (button.isSelected() && index == 3)
                    return true;
                index++;
            }
            return false;
        }
    }
}