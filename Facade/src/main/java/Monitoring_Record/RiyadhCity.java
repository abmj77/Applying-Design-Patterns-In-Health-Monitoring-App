package Monitoring_Record;

public class RiyadhCity extends Hospital {

    @Override
    public String getName() {
        return "King Faisal Hospital – Riyadh";
    }

    @Override
    public void launchLogin(AppFacade facade) {
        new LoginInRiyadh(facade, this);
    }

    @Override
    public void openMonitoringRecord() {
        new MonitoringRecordRiyadh();
    }
}
