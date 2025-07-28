package Composite_Monitoring_Record;

import javax.swing.*;
import java.awt.*;
import java.util.*;

public class Monitoring_Record_Window extends JFrame {
    private final JTextArea outputArea;
    private final JButton showStructureButton;
    private final JTextField docNameField;
    private final JTextField docSpecField;
    private final JTextField docIdField;
    private final JTextField patNameField;
    private final JTextField patIdField;
    private final JComboBox<String> doctorComboBox;
    private final JComboBox<String> assignToComboBox;
    private final JButton addDoctorBtn;
    private final JButton addPatientBtn;
    private final JButton assignBtn;

    private final Map<String, Doctor> doctors = new HashMap<>();
    private final Map<String, Patient> patients = new HashMap<>();

    public Monitoring_Record_Window() {
        super("Health System with Composite Pattern");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel(new BorderLayout());
        outputArea = new JTextArea(20, 50);
        outputArea.setEditable(false);
        mainPanel.add(new JScrollPane(outputArea), BorderLayout.CENTER);

        // Control Panel
        JPanel controlPanel = new JPanel(new GridLayout(3, 1));

        // Doctor Panel
        JPanel docPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        docNameField = new JTextField(10);
        docSpecField = new JTextField(10);
        docIdField = new JTextField(8);
        addDoctorBtn = new JButton("Add Doctor");
        docPanel.add(new JLabel("Name:")); docPanel.add(docNameField);
        docPanel.add(new JLabel("Specialty:")); docPanel.add(docSpecField);
        docPanel.add(new JLabel("ID:")); docPanel.add(docIdField);
        docPanel.add(addDoctorBtn);
        controlPanel.add(docPanel);

        // Patient Panel
        JPanel patPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        patNameField = new JTextField(10);
        patIdField = new JTextField(8);
        addPatientBtn = new JButton("Add Patient");
        patPanel.add(new JLabel("Name:")); patPanel.add(patNameField);
        patPanel.add(new JLabel("ID:")); patPanel.add(patIdField);
        patPanel.add(addPatientBtn);
        controlPanel.add(patPanel);

        // Assignment Panel
        JPanel assignPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        doctorComboBox = new JComboBox<>();
        assignToComboBox = new JComboBox<>();
        assignBtn = new JButton("Assign To Doctor");
        assignPanel.add(new JLabel("Entity:")); assignPanel.add(doctorComboBox);
        assignPanel.add(new JLabel("Assign To:")); assignPanel.add(assignToComboBox);
        assignPanel.add(assignBtn);
        controlPanel.add(assignPanel);

        mainPanel.add(controlPanel, BorderLayout.NORTH);

        // Bottom show button
        showStructureButton = new JButton("Show Structure");
        mainPanel.add(showStructureButton, BorderLayout.SOUTH);

        add(mainPanel);
        setVisible(true);

        setupListeners();
    }

    private void setupListeners() {
        addDoctorBtn.addActionListener(e -> {
            String name = docNameField.getText().trim();
            String spec = docSpecField.getText().trim();
            String id = docIdField.getText().trim();
            if (!name.isEmpty() && !spec.isEmpty() && !id.isEmpty()) {
                Doctor doc = new Doctor(name, spec, id);
                doctors.put(id, doc);
                doctorComboBox.addItem("Dr: " + name + " [" + id + "]");
                assignToComboBox.addItem("Dr: " + name + " [" + id + "]");
                clearDoctorFields();
            } else {
                JOptionPane.showMessageDialog(this, "Fill all doctor fields.");
            }
        });

        addPatientBtn.addActionListener(e -> {
            String name = patNameField.getText().trim();
            String id = patIdField.getText().trim();
            if (!name.isEmpty() && !id.isEmpty()) {
                Patient pat = new Patient(name, id);
                patients.put(id, pat);
                doctorComboBox.addItem("Pt: " + name + " [" + id + "]");
                clearPatientFields();
            } else {
                JOptionPane.showMessageDialog(this, "Fill all patient fields.");
            }
        });

        assignBtn.addActionListener(e -> {
            String entityItem = (String) doctorComboBox.getSelectedItem();
            String toItem = (String) assignToComboBox.getSelectedItem();
            if (entityItem == null || toItem == null || entityItem.equals(toItem)) {
                JOptionPane.showMessageDialog(this, "Invalid assignment.");
                return;
            }

            String entityId = extractId(entityItem);
            String toId = extractId(toItem);
            HealthcareComponent entity = doctors.get(entityId);
            if (entity == null) entity = patients.get(entityId);
            Doctor manager = doctors.get(toId);

            if (manager != null && entity != null && !manager.equals(entity)) {
                manager.addComponent(entity);
                outputArea.append("Assigned " + entity.getName() + " to " + manager.getName() + "\n");
            } else {
                JOptionPane.showMessageDialog(this, "Assignment failed.");
            }
        });

        showStructureButton.addActionListener(e -> {
            outputArea.setText("");
            for (Doctor doc : doctors.values()) {
                if (!isManaged(doc)) {
                    printStructure(doc, "");
                }
            }
        });
    }

    private void printStructure(HealthcareComponent component, String indent) {
        outputArea.append(indent + "- " + component.getName() + " (" + component.getClass().getSimpleName() + ")\n");
        if (component instanceof Doctor) {
            for (HealthcareComponent child : ((Doctor) component).getComponents()) {
                printStructure(child, indent + "    ");
            }
        }
    }

    private boolean isManaged(Doctor doc) {
        for (Doctor d : doctors.values()) {
            if (d.getComponents().contains(doc)) return true;
        }
        return false;
    }

    private String extractId(String item) {
        return item.substring(item.indexOf('[') + 1, item.indexOf(']'));
    }

    private void clearDoctorFields() {
        docNameField.setText("");
        docSpecField.setText("");
        docIdField.setText("");
    }

    private void clearPatientFields() {
        patNameField.setText("");
        patIdField.setText("");
    }
}
