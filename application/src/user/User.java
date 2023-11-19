package user;

import java.util.Date;

/** Represents a user objects who uses the system */
public class User {
    /** The name of the user */
    private String name;

    /** The user's unique userID */
    private String userID;

    /** The user's password */
    private String password;

    /** The user's faculty */
    private Faculty faculty;

    /** The role of the user in NTU */
    private Role role;

    /** The date when the user last logged-in */
    private Date lastLogin;
    
    /**
     * Creates a new user object based on the given parameters
     * @param name this is the name of the user
     * @param userID this is the user ID 
     * @param faculty this is the faculty that the user belongs to
     * @param role this is the role of the user
     */
    public User (String name, String userID, Faculty faculty, Role role){
        this.name = name;
        this.userID = userID;
        this.password = "password";
        this.faculty = faculty;
        this.role = role;
        this.lastLogin = null;
    }
    /**
     * Creates a new user object based on the given parameters
     * @param name this is the name of the user
     * @param userID this is the user ID 
     * @param password this is the password of the user
     * @param faculty this is the faculty that the user belongs to
     * @param role this is the role of the user
     * @param lastLogin this is the date that the user last logged-in
     */
    public User (String name, String userID, String password, Faculty faculty, Role role, Date lastLogin){
        this.name = name;
        this.userID = userID;
        this.password = password;
        this.faculty = faculty;
        this.role = role;
        this.lastLogin = lastLogin;
    }
    /**
     * return user's name
     * @return String
     */
    public String getName() {return name;}
    /**
     * set user's name
     * @param name new name
     */
    protected void setName(String name) {this.name = name;}

    /**
     * return user's ID
     * @return String
     */
    public String getUserID() {return userID;}

    /**
     * set user's ID
     * @param userID new userID
     */
    protected void setUserID(String userID) {this.userID = userID;}

    /**
     * return the faculty that the user belongs to
     * @return Faculty
     */
    public Faculty getFaculty() {return faculty;}
    /**
     * set user's faculty
     * @param faculty new faculty
     */
    protected void setFaculty(Faculty faculty) {this.faculty = faculty;}

    /**
     * return user's role
     * @return Role
     */
    public Role getRole() { return role;}
    /**
     * set user's role
     * @param role new role
     */
    protected void setRole(Role role) {this.role = role;}

    /**
     * return user's password
     * @return password
     */
    protected String getPassword() { return password; }
    /**
     * Change password for the user
     * @param password this is the new password
     */
    protected void setPassword(String password) {this.password = password;}
    /**
     * a method to verify user's credentials
     * @param userID userID that login in
     * @param password password that user inputs
     * @return true if the user is authenticated/false if not
     */
    protected Boolean verifyCredentials(String userID, String password) {
        if (this.userID.compareTo(userID) == 0 && this.password.compareTo(password) == 0) return true;
        return false;
    }
    /** 
     * returns the date when the user last logged-in 
     * @return Date when user last logged in
     */
    public Date getLastLogin() { return lastLogin; }
    /**
     * Sets the new lastlogin date for the user to today
     */
    protected void updateLastLogin() { this.lastLogin = new Date(); }
}
    
