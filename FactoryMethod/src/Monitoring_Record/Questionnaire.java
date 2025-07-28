package Monitoring_Record;

import java.awt.*;
import java.awt.event.*;
import java.util.Enumeration;
import javax.swing.*;
import javax.swing.border.Border;

public class Questionnaire extends JFrame {
    private Monitoring_Record_Window monitoringWindow;
    private JPanel mainPanel;
    private JButton nextButton;
    private JButton previousButton;
    private JButton doneButton;
    private JComboBox<String> questionSelector;
    private JPanel buttonsPanel;
    
    // Layout managers
    private CardLayout cardLayout;
    private BorderLayout borderLayout;
    private GridLayout gridLayout;
    
    // Question panels (10 questions)
    private JPanel[] questionPanels = new JPanel[10];
    private JLabel[] questionLabels = new JLabel[10];
    private JPanel[] choicePanels = new JPanel[10];
    private JRadioButton[][] choices = new JRadioButton[10][4];
    private ButtonGroup[] buttonGroups = new ButtonGroup[10];
    
    // Critical conditions for hospital visit
    private final String[] criticalConditions = {
        "Above 160/100 mmHg",        // Q1
        "Above 120 bpm",             // Q2
        "Above 38°C",                // Q3
        "Above 20 breaths per minute", // Q4
        "Below 85%",                 // Q5
        "Above 126 mg/dL",           // Q6
        "7-10 (Severe pain)",        // Q7
        "",                          // Q8 (handled specially)
        "",                          // Q9 (handled specially)
        ""                           // Q10 (handled specially)
    };

    public Questionnaire(Monitoring_Record_Window monitoringWindow) {
        this.monitoringWindow = monitoringWindow;
        initializeComponents();
        createAllQuestions();
        setupMainWindow();
    }

    private void initializeComponents() {
        cardLayout = new CardLayout();
        borderLayout = new BorderLayout();
        gridLayout = new GridLayout(4, 1, 0, 0);
        
        mainPanel = new JPanel(cardLayout);
        nextButton = new JButton("Next");
        previousButton = new JButton("Previous");
        doneButton = new JButton("Done");
        
        buttonsPanel = new JPanel();
        buttonsPanel.add(doneButton);
        buttonsPanel.add(nextButton);
        buttonsPanel.add(previousButton);
        
        nextButton.addActionListener(new NavigationListener());
        previousButton.addActionListener(new NavigationListener());
        doneButton.addActionListener(new SubmitListener());
        
        String[] questions = new String[10];
        for (int i = 0; i < 10; i++) {
            questions[i] = "Question" + (i + 1);
        }
        
        questionSelector = new JComboBox<>(questions);
        buttonsPanel.add(questionSelector);
        
        questionSelector.addActionListener(e -> {
            String selectedQuestion = (String) questionSelector.getSelectedItem();
            cardLayout.show(mainPanel, selectedQuestion);
        });
    }

    private void createAllQuestions() {
        // Question 1: Blood Pressure
        createQuestion(0, "What is your blood pressure today?", 
            "Below 120/80 mmHg", 
            "120-139/80-89 mmHg", 
            "140-159/90-99 mmHg", 
            "Above 160/100 mmHg");
        
        // Question 2: Heart Rate
        createQuestion(1, "What is your heart rate (pulse) today?", 
            "60-100 bpm", 
            "Below 60 bpm", 
            "101-120 bpm", 
            "Above 120 bpm");
        
        // Question 3: Body Temperature
        createQuestion(2, "What is your body temperature today?", 
            "36.1°C to 37.2°C", 
            "Below 36.1°C", 
            "37.3°C to 38°C", 
            "Above 38°C");
        
        // Question 4: Respiratory Rate
        createQuestion(3, "What is your respiratory rate today?", 
            "12-16 breaths per minute", 
            "Below 12 breaths per minute", 
            "17-20 breaths per minute", 
            "Above 20 breaths per minute");
        
        // Question 5: Blood Oxygen
        createQuestion(4, "What is your blood oxygen saturation (SpO2) level today?", 
            "95-100%", 
            "91-94%", 
            "86-90%", 
            "Below 85%");
        
        // Question 6: Blood Glucose
        createQuestion(5, "What are your blood glucose levels today?", 
            "70-99 mg/dL", 
            "Below 70 mg/dL", 
            "100-125 mg/dL", 
            "Above 126 mg/dL");
        
        // Question 7: Pain Level
        createQuestion(6, "What is your pain level today? (On a scale of 0-10)", 
            "0 (No pain)", 
            "1-3 (Mild pain)", 
            "4-6 (Moderate pain)", 
            "7-10 (Severe pain)");
        
        // Question 8: Sleep Hours
        createQuestion(7, "How many hours did you sleep last week?", 
            "7-9 hours per day", 
            "More than 9 hours per day", 
            "4-6 hours per day", 
            "Less than 4 hours per day");
        
        // Question 9: Mood
        createQuestion(8, "What is your current mood?", 
            "Happy/Content", 
            "Neutral", 
            "Anxious/Stressed", 
            "Sad/Depressed");
        
        // Question 10: Self-harm Thoughts
        createQuestion(9, "Are you thinking about hurting yourself these days?", 
            "Never", 
            "Rarely", 
            "Sometimes", 
            "A lot");
        
        // Add all question panels to main panel
        for (int i = 0; i < 10; i++) {
            mainPanel.add(questionPanels[i], "Question" + (i + 1));
        }
    }

    private void createQuestion(int index, String questionText, 
                              String choice1, String choice2, 
                              String choice3, String choice4) {
        questionPanels[index] = new JPanel(borderLayout);
        questionLabels[index] = new JLabel(questionText);
        questionLabels[index].setBorder(BorderFactory.createEmptyBorder(0, 0, 5, 0));
        
        choicePanels[index] = new JPanel(gridLayout);
        buttonGroups[index] = new ButtonGroup();
        
        // Create radio buttons
        choices[index][0] = new JRadioButton(choice1);
        choices[index][1] = new JRadioButton(choice2);
        choices[index][2] = new JRadioButton(choice3);
        choices[index][3] = new JRadioButton(choice4);
        
        // Add to button group
        for (int i = 0; i < 4; i++) {
            buttonGroups[index].add(choices[index][i]);
            choicePanels[index].add(choices[index][i]);
        }
        
        // Add components to question panel
        questionPanels[index].add(questionLabels[index], BorderLayout.NORTH);
        questionPanels[index].add(choicePanels[index], BorderLayout.CENTER);
    }

    private void setupMainWindow() {
        add(mainPanel, BorderLayout.CENTER);
        add(buttonsPanel, BorderLayout.SOUTH);
        
        setLocation(600, 200);
        setTitle("Questionnaire");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(600, 300);
        setResizable(true);
        setVisible(true);
    }

    private class NavigationListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == nextButton) {
                cardLayout.next(mainPanel);
            } else if (e.getSource() == previousButton) {
                cardLayout.previous(mainPanel);
            }
        }
    }

    private class SubmitListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == doneButton) {
                StringBuilder results = new StringBuilder("Your vital signs:\n\n");
                boolean needsHospitalVisit = evaluateResponses(results);
                
                monitoringWindow.setTextAreaText(results.toString() + 
                    "---------------------------------------------------\n");
                
                showEvaluationResult(needsHospitalVisit);
                dispose();
            }
        }
        
        private boolean evaluateResponses(StringBuilder results) {
            boolean criticalConditionFound = false;
            
            // Check questions 1-7 for critical conditions
            for (int i = 0; i < 7; i++) {
                criticalConditionFound |= checkQuestionResponse(i, results);
            }
            
            // Check questions 8-10 for combined mental health condition
            boolean sleepIssue = isOptionSelected(7, 3);  // <4 hours sleep
            boolean anxious = isOptionSelected(8, 2) || isOptionSelected(8, 3); // Anxious or depressed
            boolean selfHarm = isOptionSelected(9, 2) || isOptionSelected(9, 3); // Sometimes or a lot
            
            if (sleepIssue && anxious && selfHarm) {
                results.append("\nWarning: Multiple mental health indicators detected\n");
                criticalConditionFound = true;
            }
            
            return criticalConditionFound;
        }
        
        private boolean checkQuestionResponse(int questionIndex, StringBuilder results) {
            Enumeration<AbstractButton> buttons = buttonGroups[questionIndex].getElements();
            while (buttons.hasMoreElements()) {
                AbstractButton button = buttons.nextElement();
                if (button.isSelected()) {
                    results.append(button.getText()).append("\n");
                    return button.getText().equals(criticalConditions[questionIndex]);
                }
            }
            results.append("Not answered\n");
            return false;
        }
        
        private boolean isOptionSelected(int questionIndex, int optionIndex) {
            return choices[questionIndex][optionIndex].isSelected();
        }
        
        private void showEvaluationResult(boolean needsHospital) {
            if (needsHospital) {
                JOptionPane.showMessageDialog(null, 
                    "Based on your responses, we recommend you visit a hospital.\n" +
                    "Some of your vital signs require medical attention.",
                    "Medical Recommendation", JOptionPane.WARNING_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null,
                    "Your vital signs appear to be within normal ranges.\n" +
                    "Continue monitoring and consult a doctor if you notice any changes.",
                    "Medical Recommendation", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }
}