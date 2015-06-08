package Week3Day1.notebooks;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Created with IntelliJ IDEA.
 * User: Toxio Xo
 * Date: 10.02.13
 * Time: 11:32
 * To change this template use File | Settings | File Templates.
 */
public class Util {
    private static SessionFactory sessionFactory;

    static {
        try {
            Configuration configuration;

            configuration = new Configuration();

            configuration.configure("Week3Day1/notebooks/hibernate.cfg.xml");

            System.out.println("conf:" + configuration);

            sessionFactory = configuration.buildSessionFactory();

        } catch (HibernateException exception) {
            exception.printStackTrace();
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
