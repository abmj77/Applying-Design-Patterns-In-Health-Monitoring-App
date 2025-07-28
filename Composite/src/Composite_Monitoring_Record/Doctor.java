package Composite_Monitoring_Record;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Doctor implements HealthcareComponent {
    private final String name;
    private final String specialty;
    private final String doctorId;

    private final List<HealthcareComponent> components;

    public Doctor(String name, String specialty, String doctorId) {
        this.name = name;
        this.specialty = specialty;
        this.doctorId = doctorId;
        this.components = new ArrayList<>();
    }

    public void addComponent(HealthcareComponent component) {
        if (component != null && !components.contains(component)) {
            components.add(component);
        }
    }

    public void removeComponent(HealthcareComponent component) {
        components.remove(component);
    }

    public List<HealthcareComponent> getComponents() {
        return new ArrayList<>(components);
    }

    @Override
    public String getId() {
        return doctorId;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void displayInfo() {
        System.out.println("Doctor - Name: " + name + ", Specialty: " + specialty + ", ID: " + doctorId);
        for (HealthcareComponent c : components) {
            System.out.print("  ↳ ");
            c.displayInfo();
        }
    }

    @Override
    public String toString() {
        return "Doctor{name='" + name + "', specialty='" + specialty + "', id='" + doctorId + "'}";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Doctor)) return false;
        Doctor d = (Doctor) obj;
        return Objects.equals(this.doctorId, d.doctorId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(doctorId);
    }
}