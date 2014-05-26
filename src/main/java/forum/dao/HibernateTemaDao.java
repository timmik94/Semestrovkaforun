package forum.dao;

import forum.factory.HibernateUtil;
import forum.hibernateclasses.Message;
import forum.hibernateclasses.Tema;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by timur on 09.05.2014.
 */
public class HibernateTemaDao implements TemaDao {

    @Override
    public void addTema(Tema tema) {
        Session session= HibernateUtil.getSessionFactory().openSession();
        session.save(tema);
        session.close();
    }

    @Override
    public Tema getTema(long id) {
        Session session= HibernateUtil.getSessionFactory().openSession();
        Tema tema= (Tema) session.load(Tema.class,id);
        tema.getId();
        session.close();
        return tema;
    }

    @Override
    public Tema getTema(String name) {
        Session session= HibernateUtil.getSessionFactory().openSession();
        Tema tema= (Tema) session.load(Tema.class,name);
        session.close();
        return tema;
    }

    @Override
    public void removeTema(long id) {
        Session session= HibernateUtil.getSessionFactory().openSession();
        Tema tema= (Tema) session.load(Tema.class,id);
        session.delete(tema);
        session.close();

    }

    @Override
    public ArrayList<Tema> getall() {
        Session session=HibernateUtil.getSessionFactory().openSession();
        ArrayList<Tema>temas= (ArrayList<Tema>) session.createCriteria(Tema.class).list();
        return temas;
    }

    @Override
    public Message[] gettemamess(long id) {
        Session session= HibernateUtil.getSessionFactory().openSession();
        Tema tema= (Tema) session.load(Tema.class,id);
        Set<Message> messages=tema.getMessages();
        Iterator<Message> iterator=messages.iterator();
        Message[] m= new Message[messages.size()];
        for(int i=0;i<messages.size();i++){
            m[i]=iterator.next();
        }

        session.close();
        return m;
    }
}
