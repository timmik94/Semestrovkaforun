package forum.dao;

import forum.hibernateclasses.Message;
import forum.hibernateclasses.Tema;

import java.util.ArrayList;

/**
 * Created by timur on 09.05.2014.
 */
public interface TemaDao {
    public void  addTema(Tema tema);
    public Tema getTema(long id);
    public Tema getTema(String name);
    public void removeTema(long id);
    public ArrayList<Tema>getall();
    public Message[] gettemamess(long id);
}
