package camp_system.user;

import camp_system.scanner.Scan;

public class UserPassword {
    public static void reset(User user) {
        System.out.printf("New Password: "); String password = Scan.scan.nextLine();
        user.setPassword(password);
    }
}
