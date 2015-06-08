package Week3Day1.notebooks.domain;

import javax.persistence.*;

/**
 * Created with IntelliJ IDEA.
 * User: Toxio Xo
 * Date: 10.02.13
 * Time: 16:28
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "Vendor")
public class Vendor {
    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "name", nullable = true )
    private String name;
    @Column(name = "sum", nullable = false)
    private Integer sum;

    public Vendor (){
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

    public void setSum( Integer sum ){
        this.sum = sum;
    }

    public Integer getSum(){
        return sum;
    }

}
