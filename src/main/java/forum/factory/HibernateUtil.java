package forum.factory;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Created by timur on 20.05.2014.
 */
public class HibernateUtil {
    private static final SessionFactory sessionFactory;
    static {

            sessionFactory = new Configuration().configure().buildSessionFactory();

    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}