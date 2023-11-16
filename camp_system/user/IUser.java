package camp_system.user;

import java.util.ArrayList;

public interface IUser {
    public ArrayList<User> getUsers();
    public User login(String userID, String password);
    public void resetPassword(User user);
}
