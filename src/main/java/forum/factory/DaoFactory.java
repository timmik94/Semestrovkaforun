package forum.factory;

import forum.dao.MessageDao;
import forum.dao.TemaDao;
import forum.dao.UserDao;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by timur on 19.05.2014.
 */
public class DaoFactory {
    public MessageDao getMessageDao(){
        BeanFactory beanFactory=new ClassPathXmlApplicationContext("applicationContext.xml");
        MessageDao messageDao=(MessageDao)beanFactory.getBean("MessageDao");
        return  messageDao;
    }
    public UserDao getUserDao(){
        BeanFactory beanFactory=new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDao userDao= (UserDao) beanFactory.getBean("UserDao");
        return userDao;
    }
    public TemaDao getTemaDao(){
        BeanFactory beanFactory=new ClassPathXmlApplicationContext("applicationContext.xml");
        TemaDao temaDao=(TemaDao)beanFactory.getBean("TemaDao");
        return temaDao;
    }
}
