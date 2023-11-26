package report;

import camp.Camp;
import user.User;

/** 
 * Represents an interface that report must implement
 * @author Rachel Phuar Yi Ling
 */
public interface IReport {
    /**
     * Generates a report of the participants in the camp
     * @param camp The camp to generate report for
     * @param user The user generating the participant report
     */
    public void participant(Camp camp, User user);
    /**
     * Generates a performance report of the committee members in the camp
     * @param camp The camp to generate report for
     * @param user The user generating the performance report
     */
    public void performance(Camp camp, User user);
}
