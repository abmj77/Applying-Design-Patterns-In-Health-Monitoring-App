package Monitoring_Record;

public class YanbuCity extends Hospital {

    @Override
    public String getName() {
        return "National Hospital – Yanbu";
    }

    @Override
    public void launchLogin(AppFacade facade) {
        new LoginInYanbu(facade, this);
    }

    @Override
    public void openMonitoringRecord() {
        new MonitoringRecordYanbu();
    }
}
