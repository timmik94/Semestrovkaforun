package forum.dao;

import forum.factory.HibernateUtil;
import forum.hibernateclasses.Message;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by timur on 09.05.2014.
 */
public class HibernateMessageDao implements  MessageDao{

    @Override
    public Message getMessage(long id) {
        Session session= HibernateUtil.getSessionFactory().openSession();
        Message message=(Message)session.load(Message.class,id);
        session.close();
        return message;
    }
    public ArrayList<Message> getmess(long temaid){
        Session session= HibernateUtil.getSessionFactory().openSession();
        ArrayList<Message> ret=new ArrayList<Message>();
        List<Message> messages= (List<Message>) session.createCriteria(Message.class).list();
        for(int i=0;i<messages.size();i++){
            if(messages.get(i).getTema().getId()==temaid){ret.add(messages.get(i));}
        }
        return ret;
    }

    @Override
    public void addMessage(Message message) {
        Session session= HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();
        session.save(message);
        session.getTransaction().commit();
        session.close();

    }
}
