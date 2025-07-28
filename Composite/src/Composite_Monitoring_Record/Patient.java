package Composite_Monitoring_Record;

public class Patient implements HealthcareComponent {
    private String name;
    private String patientId;

    public Patient(String name, String patientId) {
        this.name = name;
        this.patientId = patientId;
    }

    @Override
    public String getId() {
        return patientId;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void displayInfo() {
        System.out.println("Patient - Name: " + name + ", ID: " + patientId);
    }

    @Override
    public String toString() {
        return "Patient{name='" + name + "', id='" + patientId + "'}";
    }
}