package Monitoring_Record;

public class AdminLoginFactory extends LoginFactory {
    @Override
    public User createUser(String userType) {
        return new AdminLogin();
    }
}