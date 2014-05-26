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
@RequestMapping("/reg")
public class RegAction {
    @RequestMapping(method = RequestMethod.POST)
    public String dopost(HttpSession session,@RequestParam(value = "login") String login,
                         @RequestParam(value = "password") String password,Model m){
        DaoFactory daoFactory=new DaoFactory();
        UserDao userDao=daoFactory.getUserDao();
        if(userDao.havelogin(login)){
            if(password.length()>6){
                User user=new User();
                user.setLogin(login);
                user.setPasword(password);
                userDao.adduser(user);
                session.setAttribute("user",user);
                TemaDao temaDao=daoFactory.getTemaDao();
                session.setAttribute("tems",temaDao.getall());
                return "users/tems";
            }else {m.addAttribute("message","Short Password");
            return "Registration";}
        }else {m.addAttribute("message","login don't exist");
        return "Registration";}

    }
}
