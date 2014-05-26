package forum.hibernateclasses;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;


/**
 * Created by timur on 09.05.2014.
 */
@Entity
@Table(name = "users")

public class User implements Serializable {


    @Column
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "my_entity_seq_gen")
    @SequenceGenerator(name = "my_entity_seq_gen", sequenceName = "catalog_seq")
    @Id
    private Long id;

    @Column(unique = true)
    private  String login;
    @Column
    private String pasword;
    @Lob
    @Column
    private byte[] avatar;
    @OneToMany
    private Set<Tema> tems=new HashSet<Tema>();
    @OneToMany
    private Set<Message> messages=new HashSet<Message>();

    public Set<Tema> getTems() {
        return tems;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPasword(String pasword) {
        this.pasword = pasword;
    }

    public void setAvatar(byte[] avatar) {
        this.avatar = avatar;
    }



    public long getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getPasword() {
        return pasword;
    }

    public byte[] getAvatar() {
        return avatar;
    }


}
