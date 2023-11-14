package camp_system.user;

import camp_system.application.IBase;

public class UserPassword implements IBase {
    public void reset(User user) {
        System.out.printf("New Password: "); String password = scan.nextLine();
        user.setPassword(password);
    }
}
