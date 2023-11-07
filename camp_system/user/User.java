package camp_system.user;

import camp_system.camp.Camp;

public class User {
    private String name, userID, password;
    private Faculty faculty;
    private Role role;
    private Camp committeeOf;
    private int point = 0;

    public User (String name, String userID, String password, Faculty faculty, Role role, Camp committeeOf, int point){
        this.name = name;
        this.userID = userID;
        this.password = "password";
        this.faculty = faculty;
        this.role = role;
        this.committeeOf = committeeOf;
        this.point = point;
    }

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}

    public String getUserID() {return userID;}
    public void setUserID(String userID) {this.userID = userID;}

    public Faculty getFaculty() {return faculty;}
    public void setFaculty(Faculty faculty) {this.faculty = faculty;}

    public Role getRole() { return role;}
    public void setRole(Role role) {this.role = role;}

    public void setPassword(String password) {this.password = password;}
    public String getPassword() {return password;}

    public Camp getCommitteeOf() {return committeeOf;}
    public void setCommitteeOf(Camp committeeOf) {this.committeeOf = committeeOf;}

    public int getPoint() {return point;}
    
}