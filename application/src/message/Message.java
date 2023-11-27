package message;

/**
 * Contains the content of the message, and the details of the user making it
 * @author Jared Pek, Gokul Ramesh
 */
public abstract class Message {
    /** The current status of the message */
    private Status status;

    /** The user that sent the message */
	private String user;

    /** The id of the camp */
	private long camp;

    /** The message sent by the user */
	private String message;

    /**
     * Creates a new message object based on given inputs
     * @param user The user id making the message
     * @param camp The camp id of the message
     * @param message The message to be sent
     */
    public Message(String user, long camp, String message) {
        this.status = Status.PROCESSING;
        this.user = user;
        this.camp = camp;
        this.message = message;
    }

    /**
     * Creates a new message object based on given inputs
     * @param status The current status of the message
     * @param user The user id making the message
     * @param camp The camp id of the message
     * @param message The message to be sent
     */
    public Message(Status status, String user, long camp, String message) {
        this.status = status;
        this.user = user;
        this.camp = camp;
        this.message = message;
    }
    
    /**
     * Returns the current status of the suggestion
	 * @return the status of the suggestion
	 */
    public Status getStatus() {
        return status;
    }
    /**
     * Sets the new status of the suggestion
	 * @param status Set the status attribute to this param
	 */
    protected void setStatus(Status status) {
        this.status = status;
    }
    /**
     * Returns the userID of the user making the suggestion
	 * @return the User who made this Suggestion
	 */
    public String getUser() {
        return user;
    }
    /**
     * Returns the id of the camp that the suggestion is for
	 * @return the Camp that the user who made this Suggestion is from
	 */
    public long getCamp() {
        return camp;
    }
    /**
     * Returns the suggestion made by the user
	 * @return the message that the User made
	 */
    public String getMessage() {
        return message;
    }
    /** 
     * Sets a new message to be sent
	 * @param message Set the message attribute to this param
	 */
    protected void setMessage(String message) {
        this.message = message;
    }
    /**
     * Checks whether or not a message has been reviewed
     * @param message The message object to check
     * @return Boolean, true is reviewed, false if not reviewed
     */
    public static Boolean reviewed(Message message) {
		if (message.getStatus() == Status.PROCESSING) return false;
        System.out.printf("This has already been %s\n", message.getStatus());
        return true;
    }
}
