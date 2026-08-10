package io.virinchi.springweb.Controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MailController {


    @GetMapping("/mail")
public String mailGet(HttpSession session, Model m)
{
    if(session.getAttribute("username")!=null)
    {
        return "mailPage";
    }

    m.addAttribute("error","Login First!!!");
   return "loginPage";
}


}
