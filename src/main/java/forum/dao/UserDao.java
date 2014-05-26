package forum.dao;

import forum.hibernateclasses.User;

/**
 * Created by timur on 09.05.2014.
 */
public interface UserDao {
    public void adduser(User user);
    public User getUser(String login);
    public User getUser(long id);
    public void updateUserpassword(long id,String password);
    public void updateUseravatar(long id,byte[] avatar);
    public void removeUser(long id);
    public boolean havelogin(String login);

}
