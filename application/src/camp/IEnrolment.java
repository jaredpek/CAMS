package camp;

import user.User;

/** An interface that represents the required methods for camp participant management */
public interface IEnrolment {
    public void registerCamp(User user);
    public void withdrawAttendee(User user);
}
