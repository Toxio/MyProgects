package Week3Day1.notebooks.domain;



import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created with IntelliJ IDEA.
 * User: Toxio Xo
 * Date: 09.02.13
 * Time: 15:51
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "Notebooks")
public class Notebooks {
    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "name", nullable = true )
    private String name;
    @OneToOne
    private Vendor vendor;
    @Column(name = "price", nullable = false)
    private Double price;
    @Column(name = "cre_date", nullable = true)
    private Date cre_date;

    public Notebooks() {
    }

    public Notebooks(Date cre_date, Double price ) {
        this.cre_date = cre_date;
        this.price = price;
    }

    public void setId(Integer id ){
       this.id = id;
    }

    public Integer getId(){
       return id;
    }

    public void setName(String name ){
        this.name = name;
    }

    public String getName(){
        return name  ;
    }

    public void setVendor(Vendor vendor ){
     this.vendor = vendor;
    }

    public String getVendor(){
        return vendor.getName() ;
    }

    public void setPrice(Double price ){
        this.price = price;
    }

    public Double getPrice(){
        return price;
    }

    public void setDate(Date  cre_date ){
        this.cre_date = cre_date;
    }

    public Date getDate(){
        return cre_date;
    }

    public static void main(String[] args) {
        Configuration conf = new Configuration();

        // в гибернейте для создания  <property name="hbm2ddl.auto">create</property>
        conf.configure("Week3Day1/notebooks/hibernate.cfg.xml");
        SessionFactory sf = conf.buildSessionFactory();
        Session s = sf.openSession();

        s.close();
    }


}


