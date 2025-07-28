//package Monitoring_Record;
//
//import java.awt.BorderLayout;
//import java.awt.CardLayout;
//import java.awt.Color;
//import java.awt.Font;
//import java.awt.GridLayout;
//import java.awt.Image;
//import static java.awt.Image.SCALE_AREA_AVERAGING;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.awt.event.KeyEvent;
//import java.io.File;
//import java.io.FileNotFoundException;
//import java.io.PrintWriter;
//import java.util.Enumeration;
//import javax.swing.AbstractButton;
//import javax.swing.BorderFactory;
//import javax.swing.ButtonGroup;
//import javax.swing.ImageIcon;
//import javax.swing.JButton;
//import javax.swing.JColorChooser;
//import javax.swing.JComboBox;
//import javax.swing.JFileChooser;
//import javax.swing.JFrame;
//import javax.swing.JLabel;
//import javax.swing.JMenu;
//import javax.swing.JMenuBar;
//import javax.swing.JMenuItem;
//import javax.swing.JOptionPane;
//import javax.swing.JPanel;
//import javax.swing.JPasswordField;
//import javax.swing.JRadioButton;
//import javax.swing.JRadioButtonMenuItem;
//import javax.swing.JScrollPane;
//import javax.swing.JTextArea;
//import javax.swing.JTextField;
//import javax.swing.SwingConstants;
//
////////////////////////////////////////////////////////////////////////////////////////////////////////////Log in Window
//public class LoginWindow extends JFrame
//{
//    private final String[] IDLog = {"    MRN    ","      ID   "};
//    private final JLabel MRNLabel = new JLabel(" MRN / ID:" , JLabel.LEFT);
//    private final JLabel PasswordLabel = new JLabel(" Password:" , JLabel.LEFT);
//    
//    private final JTextField MRNField = new JTextField(35);
//    private final JPasswordField PasswordField = new JPasswordField(30);
//    
//    private final JButton LoginButton = new JButton("Log In");
//    private final JButton ForgetButton = new JButton("Forget Password");
//    private final JButton ShowButton = new JButton("Show / Hide");
//    private final JButton SupportButton = new JButton("Contact Us");
//    
//    JRadioButton RadionMRN = new JRadioButton("MRN");
//    JRadioButton RadioID = new JRadioButton("National ID");
//    
//    private final JPanel p = new JPanel(new GridLayout(2,1));
//    private final JPanel p1 = new JPanel(new GridLayout(2,1));
//    private final JPanel p2 = new JPanel(new GridLayout(2,1));
//    private final JPanel p3 = new JPanel();
//    private final JPanel p4 = new JPanel();
//    private final JPanel p5 = new JPanel();
//
//    public LoginWindow()
//    {
//        super.setTitle("Log In");
//        super.setSize(500 , 470);
//        super.setLocationRelativeTo(null);
//        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        
//        ShowButton.setMnemonic(KeyEvent.VK_R);
//        ShowButton.setToolTipText("To Hide Or Show Your Password");
//        
//        LoginButton.addActionListener(new Check());
//        ForgetButton.addActionListener(new Check());
//        ShowButton.addActionListener(new showORhide());
//        SupportButton.addActionListener(new Check());
//        
//        MRNLabel.setForeground(Color.BLACK);
//        PasswordLabel.setForeground(Color.BLACK);
//        LoginButton.setBackground(Color.WHITE);
//        ForgetButton.setBackground(Color.WHITE);
//        SupportButton.setBackground(Color.WHITE);
//        
//        ButtonGroup group = new ButtonGroup();
//        group.add(RadionMRN);
//        group.add(RadioID);
//        
//        Color myColor = new Color(0xCCCCCC);
//        
//        RadionMRN.setBackground(myColor);
//        RadioID.setBackground(myColor);
//        p1.setBackground(myColor);
//        p2.setBackground(myColor);
//        p2.setBackground(myColor);
//        p3.setBackground(myColor);
//        p5.setBackground(myColor);
//        
//        p4.setBackground(Color.DARK_GRAY);
//        
//        p1.add(MRNLabel);
//        p5.add(MRNField);
//        p5.add(RadionMRN);
//        p5.add(RadioID);
//        p1.add(p5);
//        p2.add(PasswordLabel);
//        p3.add(PasswordField);
//        p3.add(ShowButton);
//        p2.add(p3);
//        p4.add(LoginButton);
//        p4.add(ForgetButton);
//        p4.add(SupportButton);
//        p.add(p1);
//        p.add(p2);
//        
//        super.add(p, BorderLayout.CENTER);
//        super.add(p4, BorderLayout.SOUTH);
//        
//        setVisible(true);
//    }
//
//    private class Check implements ActionListener
//    {
//        @Override
//        public void actionPerformed(ActionEvent e) 
//        {
//            if (e.getSource() == LoginButton) 
//            {
//                String username = MRNField.getText();
//                String password = new String(PasswordField.getPassword());
//                
//                if (username.equals("12782")||username.equals("1")||username.equals("1234")||username.equals("123456789") 
//                    && password.equals("1234")||password.equals("1")) 
//                {
//                    dispose();//To close window after click Button
//                    new Monitoring_Record_Window();
//                } 
//                else 
//                {
//                    JOptionPane.showMessageDialog(null, "Invalid username or password!", "Warning", JOptionPane.ERROR_MESSAGE);
//                    PasswordField.setText("");
//                }
//            }
//
//            if (e.getSource() == ForgetButton) 
//            {
//                new ForgetPassword();
//                dispose();
//            }
//            
//            if (e.getSource() == SupportButton)
//            {
//                dispose();
//                new Support();
//            }
//        }
//    }
//        private class showORhide implements ActionListener
//        {
//            @Override
//            public void actionPerformed(ActionEvent ee) 
//            {
//                if (PasswordField.echoCharIsSet()) 
//                    PasswordField.setEchoChar((char) 0);
//                else 
//                    PasswordField.setEchoChar((char) 0x2022);
//            }
//        }
//    
////////////////////////////////////////////////////////////////////////////////////////////////////////////Reset Password Window
//    public class ForgetPassword extends JFrame
//    {
//        private final JLabel Phone_NuberLabel = new JLabel(" Phone Number:");
//        private final JLabel ID_NumberLabel = new JLabel(" ID Number:");
//        private final JLabel MRNLabel = new JLabel(" MRN:");
//        
//        private final JTextField Phone_NuberText = new JTextField(5);
//        private final JTextField IDText = new JTextField(5);
//        private final JTextField MRNText = new JTextField(5);
//        
//        private final JPanel p = new JPanel(new GridLayout(4,0));
//        private final JPanel p1 = new JPanel(new GridLayout(2,0));
//        private final JPanel p2 = new JPanel(new GridLayout(2,0));
//        private final JPanel p3 = new JPanel();
//        private final JPanel p4 = new JPanel(new GridLayout(2,0));
//        private final JPanel p5 = new JPanel(new GridLayout(2,0));
//        
//        private final JButton ResetButton = new JButton("Reset:");
//        
//        public ForgetPassword()
//        {
//            super.setTitle("Reset Password");
//            super.setSize(450 , 470);
//            super.setLocationRelativeTo(null);
//            super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//            
//            ResetButton.addActionListener(new ResetNewPassword());
//            
//            p.setBackground(Color.LIGHT_GRAY);
//            p3.setBackground(Color.DARK_GRAY);
//            p3.add(ResetButton);
//
//            p1.add(ID_NumberLabel);
//            p1.add(IDText);
//            p2.add(MRNLabel);
//            p2.add(MRNText);
//            p4.add(Phone_NuberLabel);
//            p4.add(Phone_NuberText);
//                       
//            p.add(p1);
//            p.add(p2);
//            p.add(p4);
//            p.add(p5);
//
//            super.add(p);
//            super.add(p3 , BorderLayout.SOUTH);
//            
//            super.setVisible(true);
//        } 
//        
//        private class ResetNewPassword implements ActionListener
//        {
//            @Override
//            public void actionPerformed(ActionEvent e) 
//            {
//                if (e.getSource() == ResetButton) 
//                {
//                    //String password = new String(PasswordField.getPassword());
//                    String Phone_Nuber = Phone_NuberText.getText();
//                    String ID = IDText.getText();
//                    String MRN = MRNText.getText();
//                    Double P,I,M;
//                    
//                    try
//                    {
//                        if (Phone_Nuber.equals("") || ID.equals("") || MRN.equals("")) 
//                        {
//                            JOptionPane.showMessageDialog(null, "Invalid information!", "Warning", JOptionPane.ERROR_MESSAGE);
//                            Phone_NuberText.setText("");
//                            IDText.setText("");
//                            MRNText.setText("");
//                        }
//                        else
//                        {
//                            P = Double.parseDouble(Phone_Nuber);
//                            I = Double.parseDouble(ID);
//                            M = Double.parseDouble(MRN);
//                            JOptionPane.showMessageDialog(null, "SMS has been sent to this number " +
//                            Phone_NuberText.getText()+" please check the Messages App");
//                            dispose();//To close window after click Button
//                            new LoginWindow();
//                        }
//                    }
//                    catch(NumberFormatException r)
//                    {
//                        JOptionPane.showMessageDialog(null, "Enter only numbers");
//                        Phone_NuberText.setText("");
//                        IDText.setText("");
//                        MRNText.setText("");
//                    }
//                }
//            }
//        }
//    }
////////////////////////////////////////////////////////////////////////////////////////////////////////////Support Window
//    public class Support extends JFrame
//    {
//        private final JLabel Label = new JLabel("\n\n WELLCOM TO MOTORING RECORD SUPPORT", JLabel.CENTER);
//        private final JLabel Label1 = new JLabel("  YOUTUBE                 @monotiring_recordyoutube", JLabel.LEFT);
//        private final JLabel Label2 = new JLabel("  LINKED IN                 @monotiring_recordin", JLabel.LEFT);
//        private final JLabel Label3 = new JLabel("  INSTAGRAM             @monotiring_recordinsta", JLabel.LEFT);
//        private final JLabel Label4 = new JLabel("  X                                @monotiring_record", JLabel.LEFT);
//        private final JLabel Label5 = new JLabel("  EMAIL                       monotiring_record@gmail.com", JLabel.LEFT);
//        private final JLabel Label6 = new JLabel("  MEETA                      @monotiring_recordmeeta", JLabel.LEFT);
//        
//        private final JPanel p1 = new JPanel();
//        private final JPanel p2 = new JPanel();
//        private final JPanel p3 = new JPanel(new GridLayout(6,0));
//        
//        private final JButton OKButton = new JButton("OK");
//        
//        public Support()
//        {
//            super.setTitle("Support");
//            super.setSize(450 , 470);
//            super.setLocationRelativeTo(null);
//            super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//                        
//            OKButton.addActionListener(new Ok());
//            
//            OKButton.setBackground(Color.WHITE);
//            p1.setBackground(Color.WHITE);
//            p2.setBackground(Color.DARK_GRAY);
//            p3.setBackground(Color.LIGHT_GRAY);
//            
//            p1.add(Label);
//            p3.add(Label5);
//            p3.add(Label4);
//            p3.add(Label6);
//            p3.add(Label3);
//            p3.add(Label2);
//            p3.add(Label1);
//            p2.add(OKButton);
//            
//            add(p1, BorderLayout.NORTH);
//            add(p3, BorderLayout.CENTER);
//            add(p2, BorderLayout.SOUTH);
//            super.setVisible(true);
//        }
//        
//        private class Ok implements ActionListener
//        {
//            @Override
//            public void actionPerformed(ActionEvent e) 
//            {
//                if(e.getSource() == OKButton)
//                {
//                    dispose();
//                    new LoginWindow();
//                }
//            }
//        }
//    } 
//    
////////////////////////////////////////////////////////////////////////////////////////////////////////////Check Logout Window
//    public class Check_Logout extends JFrame 
//    {
//        JLabel Label = new JLabel("Are You Sure You Want Exit From This Account" , JLabel.CENTER);
//        JButton YesButton = new JButton("Yes");
//        JButton CancelButton = new JButton("Cancel");
//        JPanel p = new JPanel();
//        public Check_Logout()
//        {
//            super.setTitle("Monitoring Record App");
//            //super.setSize(300 , 100);
//            super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//            super.setLocationRelativeTo(null);
//            
//            YesButton.addActionListener(new Check());
//            CancelButton.addActionListener(new Check());
//            
//            p.add(YesButton);
//            p.add(CancelButton); 
//            add(Label , BorderLayout.NORTH);
//            add(p);
//            pack();
//            super.setVisible(true);
//        }
//        private class Check implements ActionListener
//        {
//            @Override
//            public void actionPerformed(ActionEvent e) 
//            {
//                if(e.getSource() == YesButton)
//                {
//                    dispose();
//                    Monitoring_Record_Window d = new Monitoring_Record_Window();
//                    d.dispose();
//                    new LoginWindow();
//                    dispose();
//                }
//                if(e.getSource() == CancelButton)
//                {
//                    dispose();
//                }
//            }
//        }
//    }
////////////////////////////////////////////////////////////////////////////////////////////////////////////Questionnaire
//    JTextArea TextArea = new JTextArea(20 , 20);
//    
//    public class Questionnaire extends JFrame 
//    {
//        private JPanel mainPanel;
//        private JButton nextButton;
//        private JButton previousButton;
//        private JButton done;
//        String[] questions;
//        private JComboBox<String> questionSelector;
//        private JPanel buttonsPanel;
//
////    Main panel Layout is cardLayout
//
//        private CardLayout cardLayout;
//
////    Questions Panels layout is BorderLayout
//
//        private BorderLayout borderLayout;
//
////    choices Panels is GridLayout(4,1)
//
//        private GridLayout gridLayout;
//
////    First question
//
//        private JPanel mainQuestionPanel1;
//        private JLabel label1;  // label1 refers to question 1
//        private JPanel multipleChoicePanel1;
//        private JRadioButton q1Choice1;
//        private JRadioButton q1Choice2;
//        private JRadioButton q1Choice3;
//        private JRadioButton q1Choice4;
//        ButtonGroup buttonGroup1;
//
////    Second Panel
//
//        private JPanel mainQuestionPanel2;
//        private JLabel label2;  // label2 refers to question 2
//        private JPanel multipleChoicePanel2;
//        private JRadioButton q2Choice1;
//        private JRadioButton q2Choice2;
//        private JRadioButton q2Choice3;
//        private JRadioButton q2Choice4;
//        private ButtonGroup buttonGroup2;
//
//        //    Third Question
//        private JPanel mainQuestionPanel3;
//        private JLabel label3;  // label3 refers to question 3
//        private JPanel multipleChoicePanel3;
//        private JRadioButton q3Choice1;
//        private JRadioButton q3Choice2;
//        private JRadioButton q3Choice3;
//        private JRadioButton q3Choice4;
//        private ButtonGroup buttonGroup3;
//
////    Fourth Question
//
//        private JPanel mainQuestionPanel4;
//        private JLabel label4;  // label4 refers to question 4
//        private JPanel multipleChoicePanel4;
//        private JRadioButton q4Choice1;
//        private JRadioButton q4Choice2;
//        private JRadioButton q4Choice3;
//        private JRadioButton q4Choice4;
//        private ButtonGroup buttonGroup4;
//
////    Fifth question
//
//        private JPanel mainQuestionPanel5;
//        private JLabel label5;  // label5 refers to question 5
//        private JPanel multipleChoicePanel5;
//        private JRadioButton q5Choice1;
//        private JRadioButton q5Choice2;
//        private JRadioButton q5Choice3;
//        private JRadioButton q5Choice4;
//        private ButtonGroup buttonGroup5;
//
////    sixth question
//
//        private JPanel mainQuestionPanel6;
//        private JLabel label6;  // label6 refers to question 6
//        private JPanel multipleChoicePanel6;
//        private JRadioButton q6Choice1;
//        private JRadioButton q6Choice2;
//        private JRadioButton q6Choice3;
//        private JRadioButton q6Choice4;
//        private ButtonGroup buttonGroup6;
//
////    seventh question
//
//        private JPanel mainQuestionPanel7;
//        private JLabel label7;  // label7 refers to question 7
//        private JPanel multipleChoicePanel7;
//        private JRadioButton q7Choice1;
//        private JRadioButton q7Choice2;
//        private JRadioButton q7Choice3;
//        private JRadioButton q7Choice4;
//        private ButtonGroup buttonGroup7;
//
////    eighth question
//
//        private JPanel mainQuestionPanel8;
//        private JLabel label8;  // label8 refers to question 8
//        private JPanel multipleChoicePanel8;
//        private JRadioButton q8Choice1;
//        private JRadioButton q8Choice2;
//        private JRadioButton q8Choice3;
//        private JRadioButton q8Choice4;
//        private ButtonGroup buttonGroup8;
//
//        //    ninth question
//
//        private JPanel mainQuestionPanel9;
//        private JLabel label9;  // label9 refers to question 9
//        private JPanel multipleChoicePanel9;
//        private JRadioButton q9Choice1;
//        private JRadioButton q9Choice2;
//        private JRadioButton q9Choice3;
//        private JRadioButton q9Choice4;
//        private ButtonGroup buttonGroup9;
//
//        //    Tenth question
//
//        private JPanel mainQuestionPanel10;
//        private JLabel label10;  // label10 refers to question 10
//        private JPanel multipleChoicePanel10;
//        private JRadioButton q10Choice1;
//        private JRadioButton q10Choice2;
//        private JRadioButton q10Choice3;
//        private JRadioButton q10Choice4;
//        private ButtonGroup buttonGroup10;
//
//
//        /**
//         * An empty constructor
//         */
//
//        public Questionnaire() {
//
//            //calling methods
//            BasicComponent();
//            createQuestion1();
//            createQuestion2();
//            createQuestion3();
//            createQuestion4();
//            createQuestion5();
//            createQuestion6();
//            createQuestion7();
//            createQuestion8();
//            createQuestion9();
//            createQuestion10();
//
//            //adding to the "mainPaenl:
//            mainPanel.add(mainQuestionPanel1, "Question1");
//            mainPanel.add(mainQuestionPanel2, "Question2");
//            mainPanel.add(mainQuestionPanel3, "Question3");
//            mainPanel.add(mainQuestionPanel4, "Question4");
//            mainPanel.add(mainQuestionPanel5, "Question5");
//            mainPanel.add(mainQuestionPanel6, "Question6");
//            mainPanel.add(mainQuestionPanel7, "Question7");
//            mainPanel.add(mainQuestionPanel8, "Question8");
//            mainPanel.add(mainQuestionPanel9, "Question9");
//            mainPanel.add(mainQuestionPanel10, "Question10");
//
//
//            // add  to the frame
//            add(mainPanel, BorderLayout.CENTER);
//            add(buttonsPanel, BorderLayout.SOUTH);
//
//
////        set the frame characteristics
////        setLocationRelativeTo(null);
//            setLocation(600, 200);
//            setTitle("Questionnaire");
//            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//            setSize(600, 300);
//            setResizable(true);
//            setVisible(true);
////        pack();System.out.println(getSize()+"\n"+getLocation());
//
//        }
//
//        /**
//         * This method to initialize basic components
//         */
//        public void BasicComponent() {
//
//            cardLayout = new CardLayout();
//            borderLayout = new BorderLayout();
//            gridLayout = new GridLayout(4, 1, 0, 0);
//
//            mainPanel = new JPanel(cardLayout);
//
//            nextButton = new JButton("Next");
//            previousButton = new JButton("previous");
//            done = new JButton("Done");
//
//            buttonsPanel = new JPanel();
//
//            buttonsPanel.add(done);
//            buttonsPanel.add(nextButton);
//            buttonsPanel.add(previousButton);
//
//            ButtonsAction nextAction = new ButtonsAction();
//            ButtonsAction previousAction = new ButtonsAction();
//
//            nextButton.addActionListener(nextAction);
//            previousButton.addActionListener(previousAction);
//            done.addActionListener(new radioButtonsAction());
//
//            // Initialize the questionSelector and add it to the buttonsPanel
//            questions = new String[]{"Question1", "Question2", "Question3", "Question4", "Question5",
//                    "Question6", "Question7", "Question8", "Question9", "Question10"};
//
//            questionSelector = new JComboBox<>(questions);
//            buttonsPanel.add(questionSelector);
//
//            questionSelector.addActionListener(new ActionListener() {
//                @Override
//                public void actionPerformed(ActionEvent e) {
//                    JComboBox comboBoxb = (JComboBox) e.getSource();
//                    String questionName = (String) comboBoxb.getSelectedItem();
//                    cardLayout.show(mainPanel, questionName);
//
//                }
//            });
//
//        }
//
//        public void createQuestion1() 
//        {
//            mainQuestionPanel1 = new JPanel(new BorderLayout());
//
//            ImageIcon pressureImage = new ImageIcon("C:\\Users\\Abdulmajed\\Documents\\NetBeansProjects\\EDUORO\\pressure_blodo.png");
//            ImageIcon finalPressureImage = resizeImage(pressureImage);
//            label1 = new JLabel("Question 1: What is your blood pressure today?\n");
//            label1.setIcon(finalPressureImage);
//            label1.setHorizontalTextPosition(SwingConstants.RIGHT);
//            label1.setIconTextGap(7);
//            label1.setBorder(BorderFactory.createEmptyBorder(0, 0, 5, 0));
//
//            multipleChoicePanel1 = new JPanel(gridLayout);
//
//            Color color = new Color(0x4A4A4A);
//            buttonsPanel.setBackground(color);
//                    
//            q1Choice1 = new JRadioButton("Below 120/80 mmHg");
//            q1Choice2 = new JRadioButton("120-139/80-89 mmHg");
//            q1Choice3 = new JRadioButton("140-159/90-99 mmHg");
//            q1Choice4 = new JRadioButton("Above 160/100 mmHg");
//
//            buttonGroup1 = new ButtonGroup();
//            buttonGroup1.add(q1Choice1);
//            buttonGroup1.add(q1Choice2);
//            buttonGroup1.add(q1Choice3);
//            buttonGroup1.add(q1Choice4);
//
//            multipleChoicePanel1.add(q1Choice1);
//            multipleChoicePanel1.add(q1Choice2);
//            multipleChoicePanel1.add(q1Choice3);
//            multipleChoicePanel1.add(q1Choice4);
//
//            mainQuestionPanel1.add(label1, BorderLayout.NORTH);
//            mainQuestionPanel1.add(multipleChoicePanel1, BorderLayout.CENTER);
//        }
//
//        public void createQuestion2() 
//        {
//            mainQuestionPanel2 = new JPanel(new BorderLayout());
//
//            ImageIcon heartRateImage = new ImageIcon("C:\\Users\\Abdulmajed\\Documents\\NetBeansProjects\\EDUORO\\heart_rate_image.png");
//            ImageIcon finalHeartRateImage = resizeImage(heartRateImage);
//            label2 = new JLabel("Question 2: What is your heart rate (pulse) today?");
//            label2.setIcon(finalHeartRateImage);
//            label2.setHorizontalTextPosition(SwingConstants.RIGHT);
//            label2.setIconTextGap(7);
//            label2.setBorder(BorderFactory.createEmptyBorder(0, 0, 5, 0));
//
//            multipleChoicePanel2 = new JPanel(gridLayout);
//
//            q2Choice1 = new JRadioButton("60-100 bpm");
//            q2Choice2 = new JRadioButton("Below 60 bpm");
//            q2Choice3 = new JRadioButton(" 101-120 bpm");
//            q2Choice4 = new JRadioButton(" Above 120 bpm");
//
//            buttonGroup2 = new ButtonGroup();
//            buttonGroup2.add(q2Choice1);
//            buttonGroup2.add(q2Choice2);
//            buttonGroup2.add(q2Choice3);
//            buttonGroup2.add(q2Choice4);
//
//            multipleChoicePanel2.add(q2Choice1);
//            multipleChoicePanel2.add(q2Choice2);
//            multipleChoicePanel2.add(q2Choice3);
//            multipleChoicePanel2.add(q2Choice4);
//
//            mainQuestionPanel2.add(label2, BorderLayout.NORTH);
//            mainQuestionPanel2.add(multipleChoicePanel2, BorderLayout.CENTER);
//
//        }
//
//        public void createQuestion3() {
//
//            mainQuestionPanel3 = new JPanel(new BorderLayout());
//
//            ImageIcon thermometerImage = new ImageIcon("C:\\Users\\Abdulmajed\\Documents\\NetBeansProjects\\EDUORO\\thermometer.png");
//            ImageIcon finalThermometerImage = resizeImage(thermometerImage);
//            label3 = new JLabel("Question 3: What is your body temperature today?");
//            label3.setIcon(finalThermometerImage);
//            label3.setHorizontalTextPosition(SwingConstants.RIGHT);
//            label3.setIconTextGap(7);
//            label3.setBorder(BorderFactory.createEmptyBorder(0, 0, 5, 0));
//
//            multipleChoicePanel3 = new JPanel(gridLayout);
//
//            q3Choice1 = new JRadioButton("36.1°C to 37.2°C");
//            q3Choice2 = new JRadioButton("Below 36.1°C");
//            q3Choice3 = new JRadioButton("37.3°C to 38°C");
//            q3Choice4 = new JRadioButton("Above 38°C");
//
//            buttonGroup3 = new ButtonGroup();
//            buttonGroup3.add(q3Choice1);
//            buttonGroup3.add(q3Choice2);
//            buttonGroup3.add(q3Choice3);
//            buttonGroup3.add(q3Choice4);
//
//            multipleChoicePanel3.add(q3Choice1);
//            multipleChoicePanel3.add(q3Choice2);
//            multipleChoicePanel3.add(q3Choice3);
//            multipleChoicePanel3.add(q3Choice4);
//
//            mainQuestionPanel3.add(label3, BorderLayout.NORTH);
//            mainQuestionPanel3.add(multipleChoicePanel3, BorderLayout.CENTER);
//
//        }
//
//        public void createQuestion4() {
//
//            mainQuestionPanel4 = new JPanel(new BorderLayout());
//
//            ImageIcon respiratoryRateImage = new ImageIcon("C:\\Users\\Abdulmajed\\Documents\\NetBeansProjects\\EDUORO\\respiratory_rate.png");
//            ImageIcon finalRespiratoryRateImage = resizeImage(respiratoryRateImage);
//            label4 = new JLabel("Question 4: What is your respiratory rate today?");
//            label4.setIcon(finalRespiratoryRateImage);
//            label4.setHorizontalTextPosition(SwingConstants.RIGHT);
//            label4.setIconTextGap(7);
//            label4.setBorder(BorderFactory.createEmptyBorder(0, 0, 5, 0));
//
//            multipleChoicePanel4 = new JPanel(gridLayout);
//
//            q4Choice1 = new JRadioButton("12-16 breaths per minute");
//            q4Choice2 = new JRadioButton("Below 12 breaths per minute");
//            q4Choice3 = new JRadioButton("17-20 breaths per minute");
//            q4Choice4 = new JRadioButton("Above 20 breaths per minute");
//
//            buttonGroup4 = new ButtonGroup();
//            buttonGroup4.add(q4Choice1);
//            buttonGroup4.add(q4Choice2);
//            buttonGroup4.add(q4Choice3);
//            buttonGroup4.add(q4Choice4);
//
//            multipleChoicePanel4.add(q4Choice1);
//            multipleChoicePanel4.add(q4Choice2);
//            multipleChoicePanel4.add(q4Choice3);
//            multipleChoicePanel4.add(q4Choice4);
//
//            mainQuestionPanel4.add(label4, BorderLayout.NORTH);
//            mainQuestionPanel4.add(multipleChoicePanel4, BorderLayout.CENTER);
//
//        }
//
//        public void createQuestion5() {
//
//            mainQuestionPanel5 = new JPanel(new BorderLayout());
//
//            ImageIcon pulseOximeterIImage = new ImageIcon("C:\\Users\\Abdulmajed\\Documents\\NetBeansProjects\\EDUORO\\pulse_Oximeter.png");
//            ImageIcon finalPulseOximeterIImage = resizeImage(pulseOximeterIImage);
//            label5 = new JLabel("Question 5: What is your blood oxygen saturation (SpO2) level today?");
//            label5.setIcon(finalPulseOximeterIImage);
//            label5.setHorizontalTextPosition(SwingConstants.RIGHT);
//            label5.setIconTextGap(7);
//            label5.setBorder(BorderFactory.createEmptyBorder(0, 0, 5, 0));
//
//            multipleChoicePanel5 = new JPanel(gridLayout);
//
//            q5Choice1 = new JRadioButton("95-100%");
//            q5Choice2 = new JRadioButton("91-94%");
//            q5Choice3 = new JRadioButton("86-90%");
//            q5Choice4 = new JRadioButton("Below 85%");
//
//            buttonGroup5 = new ButtonGroup();
//            buttonGroup5.add(q5Choice1);
//            buttonGroup5.add(q5Choice2);
//            buttonGroup5.add(q5Choice3);
//            buttonGroup5.add(q5Choice4);
//
//            multipleChoicePanel5.add(q5Choice1);
//            multipleChoicePanel5.add(q5Choice2);
//            multipleChoicePanel5.add(q5Choice3);
//            multipleChoicePanel5.add(q5Choice4);
//
//            mainQuestionPanel5.add(label5, BorderLayout.NORTH);
//            mainQuestionPanel5.add(multipleChoicePanel5, BorderLayout.CENTER);
//        }
//
//        public void createQuestion6() {
//
//            mainQuestionPanel6 = new JPanel(new BorderLayout());
//            
//            ImageIcon bloodGlucoseImage = new ImageIcon("C:\\Users\\Abdulmajed\\Documents\\NetBeansProjects\\EDUORO\\digital_glucometer.png");
//            ImageIcon finalBloodGlucoseImage = resizeImage(bloodGlucoseImage);
//            label6 = new JLabel("Question 6: What are your blood glucose levels today?");
//            label6.setIcon(finalBloodGlucoseImage);
//            label6.setHorizontalTextPosition(SwingConstants.RIGHT);
//            label6.setIconTextGap(7);
//            label6.setBorder(BorderFactory.createEmptyBorder(0, 0, 5, 0));
//
//            multipleChoicePanel6 = new JPanel(gridLayout);
//
//            q6Choice1 = new JRadioButton("70-99 mg/dL");
//            q6Choice2 = new JRadioButton("Below 70 mg/dL");
//            q6Choice3 = new JRadioButton(" 100-125 mg/dL");
//            q6Choice4 = new JRadioButton("Above 126 mg/dL");
//
//            buttonGroup6 = new ButtonGroup();
//            buttonGroup6.add(q6Choice1);
//            buttonGroup6.add(q6Choice2);
//            buttonGroup6.add(q6Choice3);
//            buttonGroup6.add(q6Choice4);
//
//            multipleChoicePanel6.add(q6Choice1);
//            multipleChoicePanel6.add(q6Choice2);
//            multipleChoicePanel6.add(q6Choice3);
//            multipleChoicePanel6.add(q6Choice4);
//
//            mainQuestionPanel6.add(label6, BorderLayout.NORTH);
//            mainQuestionPanel6.add(multipleChoicePanel6, BorderLayout.CENTER);
//        }
//
//        public void createQuestion7() {
//
//            mainQuestionPanel7 = new JPanel(new BorderLayout());
//
//            ImageIcon painImage = new ImageIcon("C:\\Users\\Abdulmajed\\Documents\\NetBeansProjects\\EDUORO\\pain_image_.png");
//            ImageIcon finalPainImage = resizeImage(painImage);
//            label7 = new JLabel("Question 7: What is your pain level today? (On a scale of 0-10)");
//            label7.setIcon(finalPainImage);
//            label7.setHorizontalTextPosition(SwingConstants.RIGHT);
//            label7.setIconTextGap(7);
//            label7.setBorder(BorderFactory.createEmptyBorder(0, 0, 5, 0));
//
//            multipleChoicePanel7 = new JPanel(gridLayout);
//
//            q7Choice1 = new JRadioButton("0 (No pain)");
//            q7Choice2 = new JRadioButton("1-3 (Mild pain)");
//            q7Choice3 = new JRadioButton("4-6 (Moderate pain)");
//            q7Choice4 = new JRadioButton("7-10 (Severe pain)");
//
//            buttonGroup7 = new ButtonGroup();
//            buttonGroup7.add(q7Choice1);
//            buttonGroup7.add(q7Choice2);
//            buttonGroup7.add(q7Choice3);
//            buttonGroup7.add(q7Choice4);
//
//            multipleChoicePanel7.add(q7Choice1);
//            multipleChoicePanel7.add(q7Choice2);
//            multipleChoicePanel7.add(q7Choice3);
//            multipleChoicePanel7.add(q7Choice4);
//
//            mainQuestionPanel7.add(label7, BorderLayout.NORTH);
//            mainQuestionPanel7.add(multipleChoicePanel7, BorderLayout.CENTER);
//        }
//
//        public void createQuestion8() {
//
//            mainQuestionPanel8 = new JPanel(new BorderLayout());
//
//            ImageIcon sleepImage = new ImageIcon("C:\\Users\\Abdulmajed\\Documents\\NetBeansProjects\\EDUORO\\sleep_image.png");
//            ImageIcon finalSleepImage = resizeImage(sleepImage);
//            label8 = new JLabel("Question 8: How many hours did you sleep last week?");
//            label8.setIcon(finalSleepImage);
//            label8.setHorizontalTextPosition(SwingConstants.RIGHT);
//            label8.setIconTextGap(7);
//            label8.setBorder(BorderFactory.createEmptyBorder(0, 0, 5, 0));
//
//            multipleChoicePanel8 = new JPanel(gridLayout);
//
//            q8Choice1 = new JRadioButton("7-9 hours per day");
//            q8Choice2 = new JRadioButton("More than 9 hours per day");
//            q8Choice3 = new JRadioButton(" 4-6 hours per day");
//            q8Choice4 = new JRadioButton("Less than 4 hours per day");
//
//            buttonGroup8 = new ButtonGroup();
//            buttonGroup8.add(q8Choice1);
//            buttonGroup8.add(q8Choice2);
//            buttonGroup8.add(q8Choice3);
//            buttonGroup8.add(q8Choice4);
//
//            multipleChoicePanel8.add(q8Choice1);
//            multipleChoicePanel8.add(q8Choice2);
//            multipleChoicePanel8.add(q8Choice3);
//            multipleChoicePanel8.add(q8Choice4);
//
//            mainQuestionPanel8.add(label8, BorderLayout.NORTH);
//            mainQuestionPanel8.add(multipleChoicePanel8, BorderLayout.CENTER);
//        }
//
//        public void createQuestion9() {
//
//            mainQuestionPanel9 = new JPanel(new BorderLayout());
//
//            ImageIcon moodImage = new ImageIcon("C:\\Users\\Abdulmajed\\Documents\\NetBeansProjects\\EDUORO\\mood_image.png");
//            ImageIcon finalMoodImage = resizeImage(moodImage);
//            label9 = new JLabel("Question 9: What is your current mood?");
//            label9.setIcon(finalMoodImage);
//            label9.setHorizontalTextPosition(SwingConstants.RIGHT);
//            label9.setIconTextGap(7);
//            label9.setBorder(BorderFactory.createEmptyBorder(0, 0, 5, 0));
//
//            multipleChoicePanel9 = new JPanel(gridLayout);
//
//            q9Choice1 = new JRadioButton("Happy/Content");
//            q9Choice2 = new JRadioButton(" Neutral");
//            q9Choice3 = new JRadioButton("Anxious/Stressed");
//            q9Choice4 = new JRadioButton(" Sad/Depressed");
//
//            buttonGroup9 = new ButtonGroup();
//            buttonGroup9.add(q9Choice1);
//            buttonGroup9.add(q9Choice2);
//            buttonGroup9.add(q9Choice3);
//            buttonGroup9.add(q9Choice4);
//
//            multipleChoicePanel9.add(q9Choice1);
//            multipleChoicePanel9.add(q9Choice2);
//            multipleChoicePanel9.add(q9Choice3);
//            multipleChoicePanel9.add(q9Choice4);
//            mainQuestionPanel9.add(label9, BorderLayout.NORTH);
//            mainQuestionPanel9.add(multipleChoicePanel9, BorderLayout.CENTER);
//        }
//
//        public void createQuestion10() 
//        {
//            mainQuestionPanel10 = new JPanel(new BorderLayout());
//
//            ImageIcon hurtImage = new ImageIcon("C:\\Users\\Abdulmajed\\Documents\\NetBeansProjects\\EDUORO\\spot_blood.png");
//            ImageIcon finalHurtImage = resizeImage(hurtImage);
//            label10 = new JLabel("Question 10: Are you thinking about hurt yourself these days?");
//            label10.setIcon(finalHurtImage);
//            label10.setHorizontalTextPosition(SwingConstants.RIGHT);
//            label10.setIconTextGap(7);
//            label10.setBorder(BorderFactory.createEmptyBorder(0, 0, 5, 0));
//
//            multipleChoicePanel10 = new JPanel(gridLayout);
//
//            q10Choice1 = new JRadioButton("never");
//            q10Choice2 = new JRadioButton("rarely");
//            q10Choice3 = new JRadioButton("sometimes");
//            q10Choice4 = new JRadioButton("a lot of");
//
//            buttonGroup10 = new ButtonGroup();
//            buttonGroup10.add(q10Choice1);
//            buttonGroup10.add(q10Choice2);
//            buttonGroup10.add(q10Choice3);
//            buttonGroup10.add(q10Choice4);
//
//            multipleChoicePanel10.add(q10Choice1);
//            multipleChoicePanel10.add(q10Choice2);
//            multipleChoicePanel10.add(q10Choice3);
//            multipleChoicePanel10.add(q10Choice4);
//
//            mainQuestionPanel10.add(label10, BorderLayout.NORTH);
//            mainQuestionPanel10.add(multipleChoicePanel10, BorderLayout.CENTER);
//        }
//
//        public ImageIcon resizeImage(ImageIcon image) {
//            Image reimage = image.getImage();
//            Image newImage = reimage.getScaledInstance(50, 50, SCALE_AREA_AVERAGING);
//            ImageIcon finalImage = new ImageIcon(newImage);
//            return finalImage;
//        }// End of the resizeImage
//
//        private class ButtonsAction implements ActionListener {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                if (e.getSource() == nextButton)
//                    cardLayout.next(mainPanel);
//
//                else if (e.getSource() == previousButton)
//                    cardLayout.previous(mainPanel);
//
//            }
//        }
//
//        private class radioButtonsAction implements ActionListener 
//        {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                if (e.getSource() == done) {
//                    TextArea.setText("Your vital signs:\n");
//                    StringBuilder allSelectedOptions = new StringBuilder();
//                    boolean needsHospitalVisit = false;
//
//                    // For each question, check which radio button is selected and append its text
//                    needsHospitalVisit |= checkAndAppend(buttonGroup1, allSelectedOptions, q1Choice4.getText());
//                    needsHospitalVisit |= checkAndAppend(buttonGroup2, allSelectedOptions, q2Choice4.getText());
//                    needsHospitalVisit |= checkAndAppend(buttonGroup3, allSelectedOptions, q3Choice4.getText());
//                    needsHospitalVisit |= checkAndAppend(buttonGroup4, allSelectedOptions, q4Choice4.getText());
//                    needsHospitalVisit |= checkAndAppend(buttonGroup5, allSelectedOptions, q5Choice4.getText());
//                    needsHospitalVisit |= checkAndAppend(buttonGroup6, allSelectedOptions, q6Choice4.getText());
//                    needsHospitalVisit |= checkAndAppend(buttonGroup7, allSelectedOptions, q7Choice4.getText());
//                    needsHospitalVisit |= checkAndAppend(buttonGroup8, allSelectedOptions, "");
//                    needsHospitalVisit |= checkAndAppend(buttonGroup9, allSelectedOptions, "");
//                    needsHospitalVisit |= checkAndAppend(buttonGroup10, allSelectedOptions, "");
//
//                    needsHospitalVisit |= multiSymptoms(buttonGroup8) &&
//                            multiSymptoms(buttonGroup9) &&
//                            multiSymptoms(buttonGroup10);
//                    // Set the text to TextArea
//                    TextArea.setText("Your vital signs:\n\n" + allSelectedOptions.toString() +
//                            " ---------------------------------------------------\n");
//                    if (needsHospitalVisit)
//                        JOptionPane.showMessageDialog(null, "You need to go to the hospital");
//
//                    else JOptionPane.showMessageDialog(null, "Your vital signs are good " +
//                            "so you do not need to go to a hospital\n" +
//                            "Notes that in the below choices " +
//                            "if the difference is high you need to go to a hospital");
//                    dispose();
//                }
//            }
//
//            private boolean checkAndAppend(ButtonGroup buttonGroup, StringBuilder builder, String criticalCondition) 
//            {
//                Enumeration<AbstractButton> buttons = buttonGroup.getElements();
//                while (buttons.hasMoreElements()) {
//                    AbstractButton button = buttons.nextElement();
//                    if (button.isSelected()) {
//                        builder.append(button.getText()).append("\n");
//                        if (button.getText().equals(criticalCondition)) {
//                            return true; // The critical condition is met
//                        }
//                        break;
//                    }
//                }
//                return false; // The critical condition is not met
//            }
//
//
//            private boolean multiSymptoms(ButtonGroup buttonGroup) {
//                Enumeration<AbstractButton> buttons = buttonGroup.getElements();
//                int index = 0;
//                while (buttons.hasMoreElements()) {
//                    AbstractButton button = buttons.nextElement();
//                    if (button.isSelected() && index == 3)  // Check if the fourth radio button is selected
//                        return true;
//                    index++;
//                }
//                return false;
//
//            }
//        }
//    }
//    
////////////////////////////////////////////////////////////////////////////////////////////////////////////Menu
//    public class Monitoring_Record_Window extends JFrame 
//    {
//        JButton Monitoring_Record = new JButton("Monitoring record");
//        JButton SaveFileButton = new JButton("Save file");
//        
//        JPanel Panel = new JPanel();
//        JScrollPane ScrolPane = new JScrollPane(TextArea);
//
//        JMenuBar MenuBar = new JMenuBar();
//        
//        JMenu About = new JMenu("About Us");
//        JMenuItem WhoAreUs = new JMenuItem("Who Is Monitoring Record?");
//        
//        JMenu AskDoctor = new JMenu("Consult Your Doctor");
//        JMenuItem doctor1 = new JMenuItem("Dr.Omar Alhibshi - Cardiology");
//        JMenuItem doctor2 = new JMenuItem("Dr.Abdullah Ali - Pediatrics");
//        JMenuItem doctor3 = new JMenuItem("Dr.Sara Mohammed - Dermatology");
//        JMenuItem doctor4 = new JMenuItem("Dr.Mashary Almazroi - Hematology ");
//        JMenuItem doctor5 = new JMenuItem("Dr.Noor Khalid - Obstetrics and gynecology");
//        
//        JMenu AccountMenu = new JMenu("My Account"); 
//        JMenuItem ProfiletmItem = new JMenuItem("Account");
//        JMenuItem LogoutmItem = new JMenuItem("Logout");
//        JMenuItem ContacttmItem = new JMenuItem("Contact Us");
//        
//        JMenu AppearanceMenu = new JMenu("Appearance");   
//        
//        JMenu FontMenu = new JMenu("Font");                
//        JMenuItem fmItem1 = new JMenuItem("Dialog");
//        JMenuItem fmItem2 = new JMenuItem("DialogInput");
//        JMenuItem fmItem3 = new JMenuItem("Monospaced");
//        JMenuItem fmItem4 = new JMenuItem("SansSerif");
//        JMenuItem fmItem5 = new JMenuItem("Serif");
//        
//        JMenu StyleMenu = new JMenu("Style");
//        JRadioButtonMenuItem RadioBoldMenuItem = new JRadioButtonMenuItem("Bold");
//        JRadioButtonMenuItem RadioItalicMenuItem = new JRadioButtonMenuItem("Italic");
//        
//        JMenu backgroundColorMenu = new JMenu("Themes");
//        JMenuItem mItemWhite = new JMenuItem("Light");
//        JMenuItem mItemBlack = new JMenuItem("Dark");
//        
//        JMenu sizeMenu = new JMenu("Font Size");
//        JMenuItem mItemIncrease = new JMenuItem("Increase");
//        JMenuItem mItemDecrease = new JMenuItem("Decrease");
//        
//        JMenuItem ColorItem = new JMenuItem("Text Color");
//        
//        JMenu Hospitals = new JMenu("Supporting hospitals");
//        JMenuItem h1 = new JMenuItem("King Fahad Armed Forced Hospital");
//        JMenuItem h2 = new JMenuItem("King Faisal Specialist Hospital & Research Centre");
//        JMenuItem h3 = new JMenuItem("Dr.Soliman Fakehh Hospital ");
//        JMenuItem h4 = new JMenuItem("King Abdulaziz University Hospital");
//   
//        public Monitoring_Record_Window() 
//        {
//            super.setTitle("Monitoring Record App");
//            super.setSize(550 , 470);
//            super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//            super.setLocationRelativeTo(null);
//            
//            TextArea.setBackground(Color.LIGHT_GRAY);
//            TextArea.setForeground(Color.red);
//            TextArea.setEditable(false);
//    
//            ScrolPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
//            ScrolPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
//            
//            Monitoring_Record.addActionListener(new MRListener());
//            Monitoring_Record.setMnemonic(KeyEvent.VK_R);
//            Monitoring_Record.setToolTipText("Check For Your Health");
//            SaveFileButton.addActionListener(new SaveFileAction());
//            SaveFileButton.setMnemonic(KeyEvent.VK_S);
//            SaveFileButton.setToolTipText("save the text to your device");
//            ColorItem.setMnemonic(KeyEvent.VK_C);
//            ColorItem.setToolTipText("change the color of displayed text");
//            
//            Panel.add(SaveFileButton);
//            Panel.add(Monitoring_Record);
//            
//            TextArea.setBackground(Color.WHITE);
//            TextArea.setForeground(Color.BLACK);
//            MenuBar.setBackground(Color.LIGHT_GRAY);
//            AccountMenu.setForeground(Color.BLACK);
//            AppearanceMenu.setForeground(Color.BLACK);
//            Hospitals.setForeground(Color.BLACK); 
//            Panel.setBackground(Color.LIGHT_GRAY);
//            
//            buildMenu();
//            super.setJMenuBar(MenuBar);
//
//            super.add(ScrolPane);
//            super.add(Panel, BorderLayout.SOUTH);
//
//            super.setVisible(true);
//        }
//
//        public void buildMenu()
//        { 
//            
//            MenuBar.add(AppearanceMenu);//The bar must put in order
//            AppearanceMenu.add(FontMenu);
//            FontMenu.add(fmItem1);
//            FontMenu.add(fmItem2);
//            FontMenu.add(fmItem3);
//            FontMenu.add(fmItem4);
//            FontMenu.add(fmItem5);
//
//            FontMenu.add(StyleMenu);
//            StyleMenu.add(RadioBoldMenuItem);
//            StyleMenu.add(RadioItalicMenuItem);
//            
//            AppearanceMenu.addSeparator();//TO add separator line in the menu
//            
//            AppearanceMenu.add(sizeMenu);
//            sizeMenu.add(mItemIncrease);
//            sizeMenu.add(mItemDecrease);
//            
//            AppearanceMenu.addSeparator();//TO add separator line in the menu
//            
//            AppearanceMenu.add(ColorItem);
//            
//            AppearanceMenu.addSeparator();//TO add separator line in the menu
//            
//            AppearanceMenu.add(backgroundColorMenu);
//            backgroundColorMenu.add(mItemWhite);
//            backgroundColorMenu.add(mItemBlack);
//            
//            ColorItem.addActionListener(new ColorChooserAction());
//            
//            mItemWhite.addActionListener(new BackGroundColorAction());
//            mItemBlack.addActionListener(new BackGroundColorAction());
//
//            fmItem1.addActionListener(new FontNameAction());
//            fmItem2.addActionListener(new FontNameAction());
//            fmItem3.addActionListener(new FontNameAction());
//            fmItem4.addActionListener(new FontNameAction());
//            fmItem5.addActionListener(new FontNameAction());
//
//            RadioBoldMenuItem.addActionListener(new FontStyleAction());
//            RadioItalicMenuItem.addActionListener(new FontStyleAction());
//
//            mItemIncrease.addActionListener(new FontSizeAction());
//            mItemDecrease.addActionListener(new FontSizeAction());
//
//            MenuBar.add(Hospitals);
//            Hospitals.add(h1);
//            Hospitals.add(h2);
//            Hospitals.add(h3);
//            Hospitals.add(h4);
//            h1.addActionListener(new hlistener());
//            h2.addActionListener(new hlistener());
//            h3.addActionListener(new hlistener());
//            h4.addActionListener(new hlistener());
//
//            
//            MenuBar.add(AskDoctor);
//            AskDoctor.add(doctor1);
//            AskDoctor.add(doctor2);
//            AskDoctor.add(doctor3);
//            AskDoctor.add(doctor4);
//            AskDoctor.add(doctor5);
//            doctor1.addActionListener(new DoctorMenu()); 
//            doctor2.addActionListener(new DoctorMenu()); 
//            doctor3.addActionListener(new DoctorMenu()); 
//            doctor4.addActionListener(new DoctorMenu()); 
//            doctor5.addActionListener(new DoctorMenu()); 
//            
//            MenuBar.add(AccountMenu); 
//            AccountMenu.add(ProfiletmItem);
//            AccountMenu.add(ContacttmItem);
//            AccountMenu.add(LogoutmItem);
//            
//            ProfiletmItem.addActionListener(new AccountAction());
//            ContacttmItem.addActionListener(new AccountAction());
//            LogoutmItem.addActionListener(new AccountAction());
//            
//            MenuBar.add(About);
//            About.add(WhoAreUs);
//            WhoAreUs.addActionListener(new AboutusAct());
//        }
//        
//        private class AboutusAct implements ActionListener
//            {
//                @Override
//                public void actionPerformed(ActionEvent e) 
//                {
//                    if(e.getSource()== WhoAreUs )
//                    {   
//                        JOptionPane.showMessageDialog(null, "It is a revolutionary health "
//                        + "application that transforms the traditional healthcare follow-up\n"
//                        + "process into a convenient digital experience\n. In today's healthcare landscape"
//                        + "patients often face the hassle of making appointments and attending unnecessary\n follow-up"
//                        + "visits after the initial consultation with the doctor.\n Although these visits are intended to "
//                        + "monitor the health progress of... \nAccess to the patient’s health data, whether health insurance, "
//                        + "file numbers, personal information, etc.\n This application enables patients to conduct follow-up health "
//                        + "assessments from their homes.\nThe application allows direct communication with healthcare providers, who can\n"
//                        + "request specific home tests. These tests are designed to be easy to use and do not require any professional assistance.\n"
//                        + "When reviewing test results healthcare providers can take Informed decisions about the need \nfor in-person follow-up appointments."
//                        + "\n" +"By optimizing the utilization of healthcare resources and saving valuable \ntime for both patients and doctors the app reduces "
//                        + "stress and enhances patient care.\n The app's technology-driven approach ensures that follow-up visits are \nscheduled only when medically necessary, "
//                        + "thus improving the overall efficiency of the healthcare system." );
//                    }
//                }
//            }
//        
//            private class DoctorMenu implements ActionListener
//            {
//                @Override
//                public void actionPerformed(ActionEvent e) 
//                {
//                    if(e.getSource()== doctor1 || e.getSource()== doctor2 ||e.getSource()== doctor3 ||e.getSource()== doctor4 ||e.getSource()== doctor5 )
//                        JOptionPane.showMessageDialog(null, "Your request has been successfully sent to the doctor yoe selected ,We will be contacted as soon as possible" );
//                }
//            }
//            private class hlistener implements ActionListener
//            {
//                @Override
//                public void actionPerformed(ActionEvent e) 
//                {
//                    if(e.getSource() == h1)
//                    {
//                        JOptionPane.showMessageDialog(null, " Hospital Name: King Fahad Armed Forced Hospital\n\n"
//                        + " Hospital Location: Jeddah,AL Andalus\n\n For contact please Call 943" );
//                    }
//
//                    if(e.getSource() == h2)
//                    {
//                       JOptionPane.showMessageDialog(null, " Hospital Name: King Faisal Specialist Hospital & Research Centre\n\n"
//                       + " Hospital Location: Jeddah,AL Rawdah\n\n For contact please Call 199019" );
//                    }
//
//                    if(e.getSource() == h3)
//                    {
//                        JOptionPane.showMessageDialog(null, " Hospital Name: Dr.Soliman Fakehh Hospital\n\n"
//                       + " Hospital Location: Jeddah,Palestein Road\n\n For contact please Call 9200 12777" );
//                    }
//
//                    if(e.getSource() == h4)
//                    {
//                        JOptionPane.showMessageDialog(null, " Hospital Name: King Abdulaziz University Hospital\n\n"
//                        + " Hospital Location: Jeddah, Al Sulaymaniyah\n\n For contact please Call 012 640 8222" );
//                    }
//                }
//            }
//
//            private class MRListener implements ActionListener
//            { 
//                @Override
//                public void actionPerformed(ActionEvent e)
//                {
//                    if(e.getSource() == Monitoring_Record)
//                    {
//                        new Questionnaire();
//                    }
//                }
//            }
//
//        private class AccountAction implements ActionListener
//        {
//           @Override
//           public void actionPerformed(ActionEvent e) 
//            {
//                if(e.getSource() == ProfiletmItem)
//                {
//                    JOptionPane.showMessageDialog(null, "Name : Abdulmajeed Abdullah\nID : 123456789\nNationality : SAUDI\n"
//                    + "MRN : 12782\nInsurance : Bupa\nAdress : Jeddah" );
//                }
//                if(e.getSource() == ContacttmItem)
//                {   
//                    JOptionPane.showMessageDialog(null, "YOUTUBE :  @monotiring_recordyoutube\n"
//                    +"LINKED IN :   @monotiring_recordin\n" + "INSTAGRAM :  @monotiring_recordinsta\n"
//                    +"X :   @monotiring_record\n" + "EMAIL :    monotiring_record@gmail.com\n" + "MEETA :   @monotiring_recordmeeta");
//                }
//                if(e.getSource() == LogoutmItem)
//                {              
//                    new Check_Logout();
//                }
//            }
//        }
//
//        private class FontSizeAction implements ActionListener
//        {
//            @Override
//            public void actionPerformed(ActionEvent e) 
//            {
//                if(e.getSource() == mItemIncrease)
//                {
//                    TextArea.setFont(new Font(TextArea.getFont().getFontName(), TextArea.getFont().getStyle(), TextArea.getFont().getSize()+1));
//                }
//                else if(e.getSource() == mItemDecrease)
//                {
//                    TextArea.setFont(new Font(TextArea.getFont().getFontName(), TextArea.getFont().getStyle(), TextArea.getFont().getSize()-1));
//                }
//            }
//        }
//
//        private class FontStyleAction implements ActionListener
//        {
//            @Override
//            public void actionPerformed(ActionEvent e) 
//            {
//                if(!RadioBoldMenuItem.isSelected() && !RadioItalicMenuItem.isSelected())
//                {
//                    TextArea.setFont(new Font(TextArea.getFont().getFontName(), Font.PLAIN , TextArea.getFont().getSize()));
//                }
//
//                if(RadioBoldMenuItem.isSelected())
//                {
//                    TextArea.setFont(new Font(TextArea.getFont().getFontName(), Font.BOLD , TextArea.getFont().getSize()));
//                }
//
//                if(RadioItalicMenuItem.isSelected())
//                {
//                    TextArea.setFont(new Font(TextArea.getFont().getFontName(), Font.ITALIC , TextArea.getFont().getSize()));
//                }
//
//                if(RadioBoldMenuItem.isSelected() && RadioItalicMenuItem.isSelected())
//                {
//                    TextArea.setFont(new Font(TextArea.getFont().getFontName(), Font.BOLD + Font.ITALIC, TextArea.getFont().getSize()));
//                }
//            }
//        }
//
//        private class FontNameAction implements ActionListener
//        {
//            @Override
//            public void actionPerformed(ActionEvent e) 
//            {
//                if(e.getSource() == fmItem1)
//                {
//                    Font f =  new Font("Dialog", TextArea.getFont().getStyle(), TextArea.getFont().getSize());
//                    TextArea.setFont(f);
//                }
//
//                else if(e.getSource() == fmItem2)
//                {
//                    TextArea.setFont(new Font("DialogInput", TextArea.getFont().getStyle(), TextArea.getFont().getSize()));
//                }
//
//                else if(e.getSource() == fmItem3)
//                {
//                    TextArea.setFont(new Font("Monospaced", TextArea.getFont().getStyle(), TextArea.getFont().getSize()));
//                }
//                else if(e.getSource() == fmItem4)
//                {
//                    TextArea.setFont(new Font("SansSerif", TextArea.getFont().getStyle(), TextArea.getFont().getSize()));
//                }
//
//                else if(e.getSource() == fmItem5)
//                {
//                    TextArea.setFont(new Font("Serif", TextArea.getFont().getStyle(), TextArea.getFont().getSize()));
//                }
//            }
//        }
//
//        private class BackGroundColorAction implements ActionListener
//        {
//            @Override
//            public void actionPerformed(ActionEvent e) 
//            {
//                if(e.getSource() == mItemWhite)
//                {
//                    TextArea.setBackground(Color.WHITE);
//                    TextArea.setForeground(Color.BLACK);
//                    MenuBar.setBackground(Color.LIGHT_GRAY);
//                    AccountMenu.setForeground(Color.BLACK);
//                    AppearanceMenu.setForeground(Color.BLACK);
//                    Hospitals.setForeground(Color.BLACK);
//                    AskDoctor.setForeground(Color.BLACK);
//                    Panel.setBackground(Color.LIGHT_GRAY);
//                }
//                else if(e.getSource() == mItemBlack)
//                {
//                    Color color = new Color(0x4A4A4A);
//                    TextArea.setBackground(color);
//                    TextArea.setForeground(Color.WHITE);
//                    MenuBar.setBackground(color);
//                    AccountMenu.setForeground(Color.WHITE);
//                    AppearanceMenu.setForeground(Color.WHITE);
//                    Hospitals.setForeground(Color.WHITE);
//                    AskDoctor.setForeground(Color.WHITE);
//                    Panel.setBackground(color);
//                }
//            }
//        }
//
//        private class SaveFileAction implements ActionListener 
//        {
//
//            @Override
//            public void actionPerformed(ActionEvent e) 
//            {
//                JFileChooser fc = new JFileChooser();
//                int status = fc.showSaveDialog(null);
//                if (status == JFileChooser.APPROVE_OPTION)//APPROVE_OPTION = 0
//                {
//                    File f = fc.getSelectedFile();
//                    try 
//                    {
//                        PrintWriter pt = new PrintWriter(f.getPath());
//                        pt.write(TextArea.getText());
//                        pt.close();
//                        JOptionPane.showMessageDialog(null, "your file is saved: " + f.getPath());
//                    } 
//                    catch (FileNotFoundException ex) 
//                    {
//                        TextArea.setText(ex.getMessage());
//                    }
//                }
//                TextArea.setText(null);
//            }
//        }
//        private class ColorChooserAction implements ActionListener 
//       {
//            @Override
//            public void actionPerformed(ActionEvent e) 
//            {
//                Color selected = JColorChooser.showDialog(null, "Select text color", null);
//                TextArea.setForeground(selected);        
//            }
//        }
//    }
////////////////////////////////////////////////////////////////////////////////////////////////////////////Main
//    public static void main(String[] args) 
//    {
//        new LoginWindow();
//    }
//}