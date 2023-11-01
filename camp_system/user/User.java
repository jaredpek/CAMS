package camp_system.user;

public class User {
    private String name, userID, password;
    private Faculty faculty;
    private Role role;

    public User (String name, String userID, String password, Faculty faculty, Role role){
        this.name = name;
        this.userID = userID;
        this.password = "password";
        this.faculty = faculty;
        this.role = role;
    }

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}

    public String getUserID() {return userID;}
    public void setUserID(String userID) {this.userID = userID;}

    public Faculty getFaculty() {return faculty;}
    public void setFaculty(Faculty faculty) {this.faculty = faculty;}

    public Role getRole() { return role; }
    public void setPassword(String password) {this.password = password;}
    public String getPassword() {return password;}
}