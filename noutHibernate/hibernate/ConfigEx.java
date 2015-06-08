package Week3Day1.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;


/**
 * Created with IntelliJ IDEA.
 * User: Toxio Xo
 * Date: 09.02.13
 * Time: 13:41
 * To change this template use File | Settings | File Templates.
 */
public class ConfigEx {
    public static void main(String[] args) {
        Configuration conf = new Configuration();

        conf.configure("Week3Day1/hibernate/hibernate.cfg.xml");
        SessionFactory sf = conf.buildSessionFactory();
        Session s = sf.openSession();
        s.close();

    }
}
