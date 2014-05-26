package forum.hibernateclasses;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Created by timur on 09.05.2014.
 */

public class HibernateConnect {
    private static SessionFactory sessionFactory = null;

    static {
        try {
            //creates the session factory from hibernate.cfg.xml
            sessionFactory = new Configuration().configure().buildSessionFactory();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
