package forum.mvcwork;

import forum.dao.MessageDao;
import forum.dao.TemaDao;
import forum.factory.DaoFactory;
import forum.hibernateclasses.Message;
import forum.hibernateclasses.Tema;
import forum.hibernateclasses.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by timur on 20.05.2014.
 */
@Controller
@RequestMapping("/users/message")
public class ForumAction {
    @RequestMapping(method = RequestMethod.POST)
    public String doPost(HttpSession session,Model m,@RequestParam(value = "text")String text,@RequestParam(value = "id")long id){
        User user= (User) session.getAttribute("user");
        DaoFactory daoFactory=new DaoFactory();
        TemaDao temaDao=daoFactory.getTemaDao();
        Tema t=temaDao.getTema(id);
        Message message=new Message();
        message.setTema(t);
        message.setDate(System.currentTimeMillis());
        message.setText(text);
        message.setUser(user);
        MessageDao messageDao=daoFactory.getMessageDao();
        messageDao.addMessage(message);
        ArrayList<Message> messarray= messageDao.getmess(id);
        Collections.sort(messarray);
        String title=t.getName();
        session.setAttribute("mess", messarray);
        session.setAttribute("name", title);
        m.addAttribute("id",id);
        return "users/forum";

    }

    @RequestMapping(method = RequestMethod.GET)
    public String doGet(@RequestParam(value = "id")long id,HttpSession session,Model m){
        DaoFactory daoFactory=new DaoFactory();
        TemaDao temaDao=daoFactory.getTemaDao();



        MessageDao messageDao=daoFactory.getMessageDao();
        ArrayList<Message> messarray= messageDao.getmess(id);
        Collections.sort(messarray);
        Tema t=temaDao.getTema(id);
        String title=t.getName();
        Collections.sort(messarray);
        session.setAttribute("mess", messarray);
        session.setAttribute("name", title);
        m.addAttribute("id",id);
        return "users/forum";
    }

}
