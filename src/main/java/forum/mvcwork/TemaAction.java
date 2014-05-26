package forum.mvcwork;

import forum.dao.TemaDao;
import forum.factory.DaoFactory;
import forum.hibernateclasses.Tema;
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
@RequestMapping("/users/tema")
public class TemaAction {
    @RequestMapping(method = RequestMethod.POST)
public String dopost(@RequestParam(value = "tema")String name,HttpSession session,Model m){
    Tema tema=new Tema();
    tema.setName(name);
    tema.setUser((forum.hibernateclasses.User) session.getAttribute("user"));
    DaoFactory daoFactory=new DaoFactory();
    TemaDao temaDao=daoFactory.getTemaDao();
    temaDao.addTema(tema);
    session.setAttribute("tems",temaDao.getall());
    return "users/tems";

}
@RequestMapping(method = RequestMethod.GET)
public String doGet(HttpSession session){
    DaoFactory daoFactory=new DaoFactory();
    TemaDao temaDao=daoFactory.getTemaDao();
    session.setAttribute("tems",temaDao.getall());
    return "users/tems";
}

}
