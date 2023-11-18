package camp_system.message;

/**
 * Contains the content of the message, and the details of the user making it
 */
public abstract class Message {
    private Status status;
	private String user;
	private long camp;
	private String message;

    
    public void print(){
        System.out.println(this.message); // print the message of the suggestion
    }
    /**
	 * @return the status of the suggestion
	 */
    protected Status accessStatus() {
        return status;
    }
    /**
	 * @param status Set the status attribute to this param
	 */
    protected void modifyStatus(Status status) {
        this.status = status;
    }
    /**
	 * @return the User who made this Suggestion
	 */
    protected String accessUser() {
        return user;
    }
    /**
	 * @param user Set the user attribute to this param
	 */
    protected void modifyUser(String user) {
        this.user = user;
    }
    /**
	 * @return the Camp that the user who made this Suggestion is from
	 */
    protected long accessCamp() {
        return camp;
    }
    /**
	 * @param camp Set the camp attribute to this param
	 */
    protected void modifyCamp(long camp) {
        this.camp = camp;
    }
    /**
	 * @return the message that the User made
	 */
    protected String accessMessage() {
        return message;
    }
    /** 
	 * @param message Set the message attribute to this param
	 */
    protected void modifyMessage(String message) {
        this.message = message;
    }

    
}
