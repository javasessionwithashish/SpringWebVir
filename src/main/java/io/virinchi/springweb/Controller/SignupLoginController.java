package io.virinchi.springweb.Controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SignupLoginController {

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

    System.out.println(username);
    System.out.println(password);

    return "loginPage";
}


}
