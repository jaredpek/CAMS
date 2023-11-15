package camp_system.suggestion;

/**
 * Represents a Suggestion made by the User from a Camp
 * 
 * @author Gokul Ramesh
 */
public class Suggestion {
	private Status status = Status.PROCESSING;
	private String user;
	private int camp;
	private String message;
	/**
	 * Prints the suggestion stored in the message attribute
	 */
	public void printSuggestion() {
		System.out.println(this.message);
	}
	/**
	 * Creates a new suggestion object with the required attributes
	 * @param user The user making the suggestion
	 * @param camp The camp that the suggestion is for
	 * @param message The suggestion string
	 */
	public Suggestion(String user, int camp, String message) {
		this.user = user;
		this.camp = camp;
		this.message = message;
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
	public int getCamp() {
		return camp;
	}
	/**
	 * @param camp Set the camp attribute to this param
	 */
	protected void setCamp(int camp) {
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
}	
