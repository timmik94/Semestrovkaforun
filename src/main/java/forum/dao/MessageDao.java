package forum.dao;

import forum.hibernateclasses.Message;

import java.util.ArrayList;

/**
 * Created by timur on 09.05.2014.
 */
public interface MessageDao {
    public Message getMessage(long id);
    public  void  addMessage(Message message);
    public ArrayList<Message> getmess(long temaid);

}
