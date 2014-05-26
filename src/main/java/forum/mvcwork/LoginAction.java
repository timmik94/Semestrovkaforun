package forum.mvcwork;

import forum.dao.TemaDao;
import forum.dao.UserDao;
import forum.factory.DaoFactory;
import forum.hibernateclasses.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

/**
 * Created by timur on 19.05.2014.
 */
@Controller
@RequestMapping("/")
public class LoginAction {
    @RequestMapping(method = RequestMethod.GET)
    public String doGet(){return "login";}
    @RequestMapping(method = RequestMethod.POST)
    public String doPost(HttpSession session,@RequestParam(value = "username")String username,
                         @RequestParam(value = "password")String password,Model m){
        DaoFactory daoFactory=new DaoFactory();
        UserDao userDao=daoFactory.getUserDao();
        User user= userDao.getUser(username);
        if(user==null){return "login";}
        if(user.getPasword().equals(password)){
            session.setAttribute("user",user);
            TemaDao temaDao=daoFactory.getTemaDao();
            session.setAttribute("tems",temaDao.getall());
            return "users/tems";
        }else return "/";

    }
}
