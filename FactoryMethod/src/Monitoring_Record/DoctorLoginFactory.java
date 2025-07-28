package Monitoring_Record;

public class DoctorLoginFactory extends LoginFactory {
    @Override
    public User createUser(String userType) {
        return new DoctorLogin();
    }
}