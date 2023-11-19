package message;

/**
 * Contains the content of the message, and the details of the user making it
 */
public abstract class Message {
    private Status status;
	private String user;
	private long camp;
	private String message;

    public Message(String user, long camp, String message) {
        this.status = Status.PROCESSING;
        this.user = user;
        this.camp = camp;
        this.message = message;
    }

    public Message(Status status, String user, long camp, String message) {
        this.status = status;
        this.user = user;
        this.camp = camp;
        this.message = message;
    }
    
    /**
	 * @return the status of the suggestion
	 */
    public Status getStatus() {
        return status;
    }
    /**
	 * @param status Set the status attribute to this param
	 */
    protected void setStatus(Status status) {
        this.status = status;
    }
    /**
	 * @return the User who made this Suggestion
	 */
    public String getUser() {
        return user;
    }
    /**
	 * @param user Set the user attribute to this param
	 */
    protected void setUser(String user) {
        this.user = user;
    }
    /**
	 * @return the Camp that the user who made this Suggestion is from
	 */
    public long getCamp() {
        return camp;
    }
    /**
	 * @param camp Set the camp attribute to this param
	 */
    protected void setCamp(long camp) {
        this.camp = camp;
    }
    /**
	 * @return the message that the User made
	 */
    public String getMessage() {
        return message;
    }
    /** 
	 * @param message Set the message attribute to this param
	 */
    protected void setMessage(String message) {
        this.message = message;
    }
}
