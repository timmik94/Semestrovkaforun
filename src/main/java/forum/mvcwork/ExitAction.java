package forum.mvcwork;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

/**
 * Created by timur on 26.05.2014.
 */
@Controller
@RequestMapping("/exit")
public class ExitAction
{
    @RequestMapping(method = RequestMethod.GET)
    public String doget(HttpSession session){
        session.setAttribute("user",null);
        return "login";
    }
}
