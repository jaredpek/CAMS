package camp_system.application;

import camp_system.user.User;

public interface IControl {
    public void add(User user);
    public void edit(User user);
    public void delete(User user);
}
