package io.virinchi.springweb.Controller;

import io.virinchi.springweb.Model.UserTbl;
import io.virinchi.springweb.Repository.UserRepository;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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

UserTbl user = new UserTbl();
user.setUsername(username);
user.setPassword(password);

uRepo.save(user);

    return "loginPage";
}

@PostMapping("/login")
    public String loginPost()
{
    return "home";
}

}
