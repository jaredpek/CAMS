package camp_system.report;

import camp_system.camp.Camp;

public interface IReport {
    public void participant(Camp camp, int choice);
    public void performance(Camp camp);
}
