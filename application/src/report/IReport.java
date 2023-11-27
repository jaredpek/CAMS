package report;

import camp.Camp;
import enquiry.EnquiryScore;
import suggestion.SuggestionScore;
import user.User;

/** 
 * Represents an interface that report must implement
 * @author Rachel Phuar Yi Ling
 */
public interface IReport {
    /** An EnquiryScore object */
    public EnquiryScore enquiryScore = new EnquiryScore();
    /** A SuggestionScore object */
    public SuggestionScore suggestionScore = new SuggestionScore();
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
