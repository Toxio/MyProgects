package Week3Day1.notebooks;

import Week3Day1.notebooks.domain.Notebooks;
import Week3Day1.notebooks.domain.Vendor;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.hibernate.criterion.Restrictions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Toxio Xo
 * Date: 10.02.13
 * Time: 11:33
 * To change this template use File | Settings | File Templates.
 */
public class Service {

    public static void exit() {
        System.exit(1);
    }

   public static Notebooks creteNotebook(){
        Notebooks nout = new Notebooks() ;
        BufferedReader input = new BufferedReader (new InputStreamReader(System.in));

        System.out.println("Set name: ");
        String s = "";
        try{
            s = input.readLine()  ;
        } catch (IOException e) {
            e.printStackTrace();
        }
        nout.setName(s);

        System.out.println("Set producer: ");
       // String s = "";
        try{
            s = input.readLine()  ;
        } catch (IOException e) {
            e.printStackTrace();
        }
        nout.setVendor(Service.getVendorByName(s));

        System.out.println("Set price: ");
        //String s = "";
        try{
            s = input.readLine()  ;
        } catch (IOException e) {
            e.printStackTrace();
        }
        nout.setPrice(Double.parseDouble(s));

        System.out.println("Set date: ");
        try{
            s = input.readLine()  ;

        } catch (IOException e) {
            e.printStackTrace();
        }

        nout.setDate(new Date(Long.parseLong(s)));

        return nout;
    }

   public  static void saveNotebook(Notebooks nout){
      /* Configuration conf = new Configuration();
       conf.configure("Week3Day1/notebooks/hibernate.cfg.xml");

       SessionFactory sf = conf.buildSessionFactory();
       Session s = sf.openSession();   */
       SessionFactory sessionFactory = Util.getSessionFactory();
       Session s = sessionFactory.openSession();

       try {
           s.beginTransaction();
           s.save(nout);
           s.getTransaction().commit();

       } catch(HibernateException e) {
           s.getTransaction().rollback();
       } finally {
           s.close();
       }

   }

   public  static void showNotebooks(){
       /*Configuration conf = new Configuration();
       conf.configure("Week3Day1/notebooks/hibernate.cfg.xml");

       SessionFactory sf = conf.buildSessionFactory();
       Session s = sf.openSession();      */

       SessionFactory sessionFactory = Util.getSessionFactory();
       Session s = sessionFactory.openSession();
       try {
           List<Notebooks> list = s.createCriteria(Notebooks.class).list();
           for (Notebooks notebook:list){
               System.out.println("Id: " + notebook.getId() + " name: " + notebook.getName() +" price: " + notebook.getPrice() + " vendor: " + notebook.getVendor());
           }
       }
       catch (HibernateException e){
       }
       finally {
           s.close();
       }
   }

    public static void showVendors(){
        SessionFactory sessionFactory = Util.getSessionFactory();
        Session s = sessionFactory.openSession();
        try {
            List<Vendor> list = s.createCriteria(Vendor.class).list();
            for (Vendor vendor:list){
                System.out.println("Id: " + vendor.getId() + " name: " + vendor.getName() +" price: " + vendor.getSum() );
            }
        }
        catch (HibernateException e){
        }
        finally {
            s.close();
        }
    }

    public static Vendor getVendorByName(String vendorName){
        SessionFactory sessionFactory = Util.getSessionFactory();
        Session s = sessionFactory.openSession();
        try {
            List<Vendor> list = s.createCriteria(Vendor.class).add(Restrictions.eq("name", vendorName)).list();
            if (!list.isEmpty()){
                return list.get(0);
            }
        }
        catch (HibernateException e){

        }
        finally {
            s.close();
        }

        return createVendorWithName(vendorName);
    }

    public static Vendor createVendorWithName(String vendorName){

        Vendor vendor = new Vendor();
        vendor.setName(vendorName);
        vendor.setSum(10);
        SaveVendor(vendor);
        return vendor;
    }

    public static void SaveVendor(Vendor vendor){

        SessionFactory sessionFactory = Util.getSessionFactory();
        Session s = sessionFactory.openSession();
        try {
            s.beginTransaction();
            s.save(vendor);
            s.getTransaction().commit();
        }
        catch (HibernateException e){
            e.printStackTrace();
            s.getTransaction().rollback();
        }
        finally {
            s.close();
        }
    }


}
