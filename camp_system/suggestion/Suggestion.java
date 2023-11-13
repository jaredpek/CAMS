package camp_system.suggestion;

import camp_system.camp.Camp;
import camp_system.user.User;

public class Suggestion {
	private Status status = Status.PROCESSING;
	private User user;
	private Camp camp;
	private String message;
	
	public void printSuggestion() {
		System.out.println(this.message);
	}
	public Suggestion() {
		
	}
	public User getUser() {
		return user;
	}
	protected void setUser(User user) {
		this.user = user;
	}
	public Camp getCamp() {
		return camp;
	}
	protected void setCamp(Camp camp) {
		this.camp = camp;
	}
	public String getMessage() {
		return message;
	}
	protected void setMessage(String message) {
		this.message = message;
	}
	public Status getStatus() {
		return status;
	}
	protected void setStatus(Status status) {
		this.status = status;
	}
	
	}	


