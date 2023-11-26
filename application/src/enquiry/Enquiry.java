package enquiry;

import message.Message;
import message.Status;

/** 
 * Represent a camp that is available to students
 * @author Tan Yoong Ken
 */
public class Enquiry extends Message {
    /** The reply to the enquiry */
    private String reply;

    /** The person who replied the enquiry */
    private String repliedBy;

    /** 
     * Creates a new Enquiry object with the relevant information
     * @param user This is the user who created the enquiry
     * @param camp This is the camp that the enquiry is made for
     * @param message This is the question about the camp
     */
    public Enquiry(String user, long camp, String message) {
        super(user, camp, message);
        this.reply = "-"; //default no replies
        this.repliedBy = "-"; //default
    }

    /** 
     * Creates a new Enquiry object with the relevant information
     * @param status This is the status of the enquiry
     * @param user This is the user who created the enquiry
     * @param camp This is the camp that the enquiry is made for
     * @param message This is the question about the camp
     * @param reply This is the reply for the enquiry
     * @param repliedBy This is the name of the person who replied the enquiry
     */
    public Enquiry(Status status, String user, long camp, String message, String reply, String repliedBy) {
        super(status, user, camp, message);
        this.reply = reply;
        this.repliedBy = repliedBy;
    }

    /**
     * Sets a new message for the enquiry
     * @param message This is the new message to set
     */
    protected void setMessage(String message) { super.setMessage(message); }

    /**
     * Sets a new status for the enquiry
     * @param status This is the new status to set
     */
    protected void setStatus(Status status) { super.setStatus(status); }

    /**
     * Returns the reply to the enquiry
     * @return The reply of the enquiry 
     */
    public String getReply() { return this.reply; }
    /** 
     * Sets a new reply for the enquiry
     * @param reply Set the reply of the enquiry
     */
    protected void setReply(String reply) { this.reply = reply; }

    /**
     * Returns the user who replied to the enquiry
     * @return The person who replied the enquiry
     */
    public String getRepliedBy() { return repliedBy; }
    /** 
     * Sets the user who replied to the enquiry
     * @param repliedBy Set person who replied the enquiry
     */
    protected void setRepliedBy(String repliedBy) { this.repliedBy = repliedBy; }
}
