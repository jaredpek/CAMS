package camp_system.user;

import camp_system.camp.Camp;
//import camp_system.enquiry.Enquiry;
//import camp_system.suggestion.Suggestion;
public class User {
    private String name, userID, password;
    private Faculty faculty;
    private Role role;
    private Camp committeeOf;
    private int point = 0;
    /**
     * 
     * @param name this is the name of the user
     * @param userID this is the user ID 
     * @param password this is the password
     * @param faculty this is the faculty that the user belongs to
     * @param role this is the role of the user
     * @param committeeOf this is the camp of the committee belongs to
     * @param point this is the point of the user
     */
    public User (String name, String userID, Faculty faculty, Role role){
        this.name = name;
        this.userID = userID;
        this.password = "password";
        this.faculty = faculty;
        this.role = role;
    }
    public void printInfo() {
        System.out.println("Name: " + name);
        System.out.println("User ID: " + userID);
        System.out.println("Faculty: " + faculty);
        System.out.println("Role: " + role);
    }
    /**
     * return user's name
     * @return String
     */
    public String getName() {return name;}
    protected void setName(String name) {this.name = name;}

    /**
     * return user's ID
     * @return String
     */
    public String getUserID() {return userID;}
    protected void setUserID(String userID) {this.userID = userID;}

    /**
     * return the faculty that the user belongs to
     * @return Faculty
     */
    public Faculty getFaculty() {return faculty;}
    protected void setFaculty(Faculty faculty) {this.faculty = faculty;}

    /**
     * return user's role
     * @return Role
     */
    public Role getRole() { return role;}
    protected void setRole(Role role) {this.role = role;}

    /**
     * Change password for the user
     * @param password this is the new password
     */
    protected void setPassword(String password) {this.password = password;}
    
    public Boolean verifyCredentials(String userID, String password) {
        if (this.userID.compareTo(userID) == 0 && this.password.compareTo(password) == 0) return true;
        return false;
    }

    /**
     * return the camp name which the user belongs to
     * @return Camp
     */
    public Camp getCommitteeOf() {return committeeOf;}
    protected void setCommitteeOf(Camp committeeOf) {this.committeeOf = committeeOf;}
    
    /**
     * return user's point
     * @return int
     */
    public int getPoint() {return point;}
    protected void setPoint(int point) {this.point = point;}
    
    /**
     * add point for the user
     */
    public void addPoint(){
        point++;
    }
}
    
