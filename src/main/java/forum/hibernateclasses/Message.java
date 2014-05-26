package forum.hibernateclasses;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by timur on 09.05.2014.
 */
@Entity
@Table(name = "messages")
public class Message implements Serializable ,Comparable<Message> {
    @Column(name = "messid")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "my_entity_seq_gen")
    @SequenceGenerator(name = "my_entity_seq_gen", sequenceName = "catalog_seq")
    @Id
    private Long id;

    @Column(name = "text")
    private String text;

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public Tema getTema() {
        return tema;
    }



    @Column(name = "date")
    private long date;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @ManyToOne
    private User user;

    public void setTema(Tema tema) {
        this.tema = tema;
    }

    @ManyToOne
    private Tema tema;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }


    public String toString(){
        String s=user.getLogin()+": "+text;
        return s;
    }

    @Override
    public int compareTo(Message o) {
        if(this.date>o.getDate()){return 1;}
        if(this.date<o.getDate()){return -1;}
        return 0;
    }
}
