package Monitoring_Record;

import javax.swing.*;

public class AppFacade {
    private Hospital selectedHospital;

    public void start() {
        // Open hospital selection window
        new HospitalSelectionWindow(this);
    }

    public void selectHospital(String name) {
        switch (name.toLowerCase()) {
            case "jeddah":
                selectedHospital = new JeddahCity();
                break;
            case "riyadh":
                selectedHospital = new RiyadhCity();
                break;
            case "yanbu":
                selectedHospital = new YanbuCity();
                break;
            default:
                JOptionPane.showMessageDialog(null, "Unknown hospital selected");
        }
    }

    public void login() {
        if (selectedHospital != null) {
            selectedHospital.launchLogin(this);
        } else {
            JOptionPane.showMessageDialog(null, "Please select a hospital first.");
        }
    }

    public void openMonitoringRecord() {
        if (selectedHospital != null) {
            selectedHospital.openMonitoringRecord();
        }
    }
}
