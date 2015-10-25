package Week3Day1.notebooks;

import Week3Day1.notebooks.domain.Notebooks;
import Week3Day1.notebooks.domain.Vendor;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import java.sql.Date;

/**
 * Created with IntelliJ IDEA.
 * User: Toxio Xo
 * Date: 09.02.13
 * Time: 17:23
 * To change this template use File | Settings | File Templates.
 */
public class ConfigEx {
    public static void main(String[] args) {
        Configuration conf = new Configuration();

        conf.configure("Week3Day1/notebooks/hibernate.cfg.xml");
        SessionFactory sf = conf.buildSessionFactory();

        Notebooks n1 = new Notebooks();
        n1.setPrice(1.0);
        n1.setDate(new Date(10000));
        Vendor v1 = new Vendor();
        v1.setName("HP");
        v1.setSum(200);
        n1.setVendor(v1);

        Notebooks n2 = new Notebooks();
        n2.setPrice(2.0);
        n2.setDate(new Date(10000));
      //  n2.setVendor("HP");

        Notebooks n3 = new Notebooks();
        n3.setPrice(3.0);
        n3.setDate(new Date(10000));
       // n3.setVendor("HP");

        Session s = sf.openSession();

        try {

            s.beginTransaction();
            s.save(n1);
            s.save(n2);
            s.save(n3);
            s.getTransaction().commit();

            /*s.beginTransaction();
            Long n1Id = (Long) s.save(n1);
            Long n2Id = (Long) s.save(n2);
            Long n3Id = (Long) s.save(n3);
            s.getTransaction().commit();

            n1 = (Notebooks) s.get(Notebooks.class, n1Id);
            n2 = (Notebooks) s.get(Notebooks.class, n2Id);
            n3 = (Notebooks) s.get(Notebooks.class, n3Id);
            double n1P = n1.getPrice();
            double n2P = n2.getPrice();
            double n3P = n3.getPrice();
            double tmpP = n1.getPrice();
            n1.setPrice(n2.getPrice());
            n2.setPrice(n3.getPrice());
            n3.setPrice(tmpP);


            s.beginTransaction();
            n1Id = (Long) s.save(n1);
            n2Id = (Long) s.save(n2);
            n3Id = (Long) s.save(n3);
            s.beginTransaction().commit();     */

        } catch(HibernateException e) {
            s.getTransaction().rollback();
        } finally {
            s.close();
        }

    }
}
