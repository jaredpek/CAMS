package enquiry;

import message.Message;
import message.Status;

/** Represent a camp that is available to students */
public class Enquiry extends Message {
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
     * @param student This is the user who created the enquiry
     * @param camp This is the camp that the enquiry is made for
     * @param question This is the question about the camp
     * @param reply This is the reply for the enquiry
     * @param repliedBy This is the name of the person who replied the enquiry
     */
    public Enquiry(Status status, String user, long camp, String message, String reply, String repliedBy) {
        super(status, user, camp, message);
        this.reply = reply;
        this.repliedBy = repliedBy;
    }

    protected void setMessage(String message) { super.setMessage(message); }
    protected void setStatus(Status status) { super.setStatus(status); }

    /**
     * @return The reply of the enquiry 
     */
    public String getReply() { return this.reply; }
    /** 
     * @param reply Set the reply of the enquiry
     */
    protected void setReply(String reply) { this.reply = reply; }

    /**
     * @return The person who replied the enquiry
     */
    public String getRepliedBy() { return repliedBy; }
    /** 
     * @param reply Set person who replied the enquiry
     */
    protected void setRepliedBy(String repliedBy) { this.repliedBy = repliedBy; }
}
