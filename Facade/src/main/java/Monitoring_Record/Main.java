package Monitoring_Record;

/**
 *
 * @author Abdulmajeed Abdullah
 */

public class Main {
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            AppFacade facade = new AppFacade();
            facade.start();
        });
    }
}
