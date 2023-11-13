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
    public User (String name, String userID, String password, Faculty faculty, Role role, Camp committeeOf, int point){
        this.name = name;
        this.userID = userID;
        this.password = "password";
        this.faculty = faculty;
        this.role = role;
        this.committeeOf = committeeOf;
        this.point = point;
    }
    /**
     * return user's name
     * @return String
     */
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}

    /**
     * return user's ID
     * @return String
     */
    public String getUserID() {return userID;}
    public void setUserID(String userID) {this.userID = userID;}

    /**
     * return the faculty that the user belongs to
     * @return Faculty
     */
    public Faculty getFaculty() {return faculty;}
    public void setFaculty(Faculty faculty) {this.faculty = faculty;}

    /**
     * return user's role
     * @return Role
     */
    public Role getRole() { return role;}
    public void setRole(Role role) {this.role = role;}

    /**
     * Change password for the user
     * @param password this is the new password
     */
    public void setPassword(String password) {this.password = password;}
    public String getPassword() {return password;}

    /**
     * return the camp name which the user belongs to
     * @return Camp
     */
    public Camp getCommitteeOf() {return committeeOf;}
    public void setCommitteeOf(Camp committeeOf) {this.committeeOf = committeeOf;}
    
    /**
     * return user's point
     * @return int
     */
    public int getPoint() {return point;}
    public void setPoint(int point) {this.point = point;}
    
    /**
     * add point for the user
     */
    public void addPoint(){
        point++;
    }
    

    
}
    
