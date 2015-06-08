package Week3Day1.notebooks.domain;

import javax.persistence.*;

/**
 * Created with IntelliJ IDEA.
 * User: Toxio Xo
 * Date: 22.02.13
 * Time: 11:37
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "Store")
public class Store {
    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "name", nullable = true )
    private String name;


    public  Store(){
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

}
