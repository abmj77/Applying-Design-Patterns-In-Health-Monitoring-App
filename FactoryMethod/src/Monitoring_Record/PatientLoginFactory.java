package Monitoring_Record;

public class PatientLoginFactory extends LoginFactory {
    @Override
    public User createUser(String userType) {
        return new PatientLogin();
    }
}