package camp_system.camp;

import camp_system.user.User;

public interface IEnrolment {
    public void registerCamp(User user);
    public void withdrawAttendee(User user);
}
