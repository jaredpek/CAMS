package suggestion;

import message.*;

/**
 * Represents a Suggestion made by the User from a Camp
 * 
 * @author Gokul Ramesh
 */
public class Suggestion extends Message {
	/**
	 * Creates a new suggestion object with the required attributes
	 * @param user The user making the suggestion
	 * @param camp The camp that the suggestion is for
	 * @param message The suggestion string
	 */
	public Suggestion(String user, long camp, String message) {
		super(user, camp, message);
		
	}
	/**
	 * Creates a new suggestion object with the required attributes
	 * @param status The current status of the suggestion
	 * @param user The user making the suggestion
	 * @param camp The camp that the suggestion is for
	 * @param message The suggestion string
	 */
	public Suggestion(Status status, String user, long camp, String message) {
		super(status, user, camp, message);
	}
	/**
	 * Sets the new status of the suggestion
	 * @param status The new status to be set
	*/
	protected void setStatus(Status status) { super.setStatus(status); }
	/**
	 * Sets the new message of the suggestion
	 * @param message The new message to be set
	*/
	protected void setMessage(String message) { super.setMessage(message); }
}	
