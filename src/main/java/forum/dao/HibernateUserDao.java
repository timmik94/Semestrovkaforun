package forum.dao;

import forum.factory.HibernateUtil;
import forum.hibernateclasses.User;
import org.hibernate.Session;

import java.util.List;

/**
 * Created by timur on 09.05.2014.
 */
public class HibernateUserDao implements UserDao{
    @Override
    public void adduser(User user) {
        if(havelogin(user.getLogin())){
        Session session= HibernateUtil.getSessionFactory().openSession();
        session.save(user);
        session.close();}
    }

    @Override
    public User getUser(String login) {
        Session session= HibernateUtil.getSessionFactory().openSession();
        List<User> users=(List<User>) session.createCriteria(User.class).list();
        User user= null;
        for(int i=0;i<users.size();i++){
            if(users.get(i).getLogin().equals(login)){
                user=users.get(i);
                break;
            }
        }

        session.close();
        return user;
    }

    @Override
    public User getUser(long id) {
        Session session= HibernateUtil.getSessionFactory().openSession();
        User user=(User)session.load(User.class,id);
        session.close();
        return user;
    }

    @Override
    public void updateUserpassword(long id, String password) {
        Session session= HibernateUtil.getSessionFactory().openSession();
        User user=(User)session.load(User.class,id);
        user.setPasword(password);
        session.update(user);
        session.close();


    }

    @Override
    public void updateUseravatar(long id, byte[] avatar) {
        Session session= HibernateUtil.getSessionFactory().openSession();
        User user=(User)session.load(User.class,id);
        user.setAvatar(avatar);
        session.update(user);
        session.close();

    }

    @Override
    public void removeUser(long id) {
        Session session= HibernateUtil.getSessionFactory().openSession();
        User user=(User)session.load(User.class,id);
        session.delete(user);
        session.close();

    }

    @Override
    public boolean havelogin(String login) {
        User user=this.getUser(login);
        if(user==null){return true;}
        else{
        return false;}
    }
}
