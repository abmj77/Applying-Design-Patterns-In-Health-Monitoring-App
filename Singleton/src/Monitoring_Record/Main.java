package Monitoring_Record;

/**
 *
 * @author Abdulmajeed Abdullah
 */

public class Main {
    public static void main(String[] args) {
        // Get the singleton instance of LoginWithSingleton
        LoginWithSingleton loginWindow = LoginWithSingleton.getInstance();
        loginWindow.setVisible(true); // Make the window visible
    }
}