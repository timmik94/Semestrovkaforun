package forum.hibernateclasses;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Set;

/**
 * Created by timur on 09.05.2014.
 */
@Entity
@Table(name = "tems")
public class Tema implements Serializable {
    @Column(name = "temaid")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "my_entity_seq_gen")
    @SequenceGenerator(name = "my_entity_seq_gen", sequenceName = "catalog_seq")
    @Id
    private Long id;

    @Column(name = "title" ,unique = true)
    private String  name;
    @ManyToOne
    private User user;

    public Set<Message> getMessages() {
        return messages;
    }

    @OneToMany
    private Set<Message> messages;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    public String toString(){
        String s=name+": "+user.getLogin();
        return s;
    }


}
