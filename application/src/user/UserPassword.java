package user;

import input.Scan;
/**
 * A method to reset user's password
 * @author Qiang ZhiQin
 */
public class UserPassword {
    /**
     * reset password
     * @param user this is the user object that wants to reset password
     */
    public void reset(User user) {
        System.out.printf("New Password: "); String password = Scan.scan.nextLine();
        user.setPassword(password);
    }
}
