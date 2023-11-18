package camp_system.suggestion;

import camp_system.message.*;

/**
 * Represents a Suggestion made by the User from a Camp
 * 
 * @author Gokul Ramesh
 */
public class Suggestion extends Message {

	/**
	 * Prints the suggestion stored in the message attribute
	 */
	public void printSuggestion() {
		System.out.println(this.getMessage());
	}
	/**
	 * Creates a new suggestion object with the required attributes
	 * @param user The user making the suggestion
	 * @param camp The camp that the suggestion is for
	 * @param message The suggestion string
	 */
	public Suggestion(String user, long camp, String message) {
		this.modifyStatus(Status.PROCESSING);
		this.modifyUser(user);
		this.modifyCamp(camp);
		this.modifyMessage(message);
		
	}
	public Suggestion(Status status, String user, long camp, String message) {
		this.modifyStatus(status);
		this.modifyUser(user);
		this.modifyCamp(camp);
		this.modifyMessage(message);
	}
	/**
	 * @return the User who made this Suggestion
	 */
	public String getUser() {
		return this.accessUser();
	}
	/**
	 * @param user Set the user attribute to this param
	 */
	protected void setUser(String user) {
		this.modifyUser(user);
	}
	/**
	 * @return the Camp that the user who made this Suggestion is from
	 */
	public long getCamp() {
		return this.accessCamp();
	}
	/**
	 * @param camp Set the camp attribute to this param
	 */
	protected void setCamp(long camp) {
		this.modifyCamp(camp);
	}
	/**
	 * @return the message that the User made
	 */
	public String getMessage() {
		return this.accessMessage();
	}
	/** 
	 * @param message Set the message attribute to this param
	 */
	protected void setMessage(String message) {
		this.modifyMessage(message);
	}
	/**
	 * @return the status of the suggestion
	 */
	public Status getStatus() {
		return this.accessStatus();
	}
	/**
	 * @param status Set the status attribute to this param
	 */
	protected void setStatus(Status status) {
		this.modifyStatus(status);
	}
}	
