package user;

public interface IUser {
    public User login(String userID, String password);
    public void resetPassword(User user);
}
