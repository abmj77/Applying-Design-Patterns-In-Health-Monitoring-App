package Monitoring_Record;

public class JeddahCity extends Hospital {

    @Override
    public String getName() {
        return "King Fahad Hospital – Jeddah";
    }

    @Override
    public void launchLogin(AppFacade facade) {
        new LoginInJeddah(facade, this);
    }

    @Override
    public void openMonitoringRecord() {
        new MonitoringRecordJeddah();
    }
}
