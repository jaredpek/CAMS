package camp_system.user;

import camp_system.scanner.Scan;
/**
 * A method to reset user's password
 */
public class UserPassword {
    /**
     * reset password
     * @param user this is the user object that wants to reset password
     */
    public static void reset(User user) {
        System.out.printf("New Password: "); String password = Scan.scan.nextLine();
        user.setPassword(password);
    }
}
