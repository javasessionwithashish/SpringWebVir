package io.virinchi.springweb.Controller;

import io.virinchi.springweb.Model.UserTbl;
import io.virinchi.springweb.Repository.UserRepository;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Base64;

@Controller
public class SignupLoginController {


@Autowired
   private  UserRepository uRepo ;


    @GetMapping("/signup")
public String signup()
{
return "signupPage";
}

@GetMapping("/login")
public String login()
{
return "loginPage";
}


@PostMapping("/signup")
    public String signupPost(HttpServletRequest request)
{
    //request.getParameter("username") name?->Intellij ->form name
 String username=   request.getParameter("username");
   String password= request.getParameter("password");

   String hashPassword = DigestUtils.md5DigestAsHex(password.getBytes());
   //md5 algorithm, this is basic algorithm, anyone can hack this
    //we will learn bcrypt technique very soon

UserTbl user = new UserTbl();
user.setUsername(username);
user.setPassword(hashPassword);

uRepo.save(user);

    return "loginPage";
}

@PostMapping("/login")
    public String loginPost(HttpServletRequest request, Model m)
{
    String username= request.getParameter("username");
    String password = request.getParameter("password");

    String hashPassword = DigestUtils.md5DigestAsHex(password.getBytes());

   if( uRepo.existsByUsernameAndPassword(username,hashPassword))
   {
return "home";
   }
//message pathauna kunai page ma hamlai MODEL chainchha
    //Controller bata html page ma model le msg transfer garchha
    //MODEL ma attribute rakhera pathauchhau
//m.addAttribute("title","msg")
    m.addAttribute("error", "Username or password is incorrect");
    return "loginPage";
}

}
