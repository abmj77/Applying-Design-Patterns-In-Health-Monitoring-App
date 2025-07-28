package Monitoring_Record;

import javax.swing.JFrame;

public abstract class LoginFactory extends JFrame {
    public abstract User createUser(String userType);
    
    public void showLoginScreen(String userType) {
        User user = createUser(userType);
        user.showLoginScreen();
    }
}