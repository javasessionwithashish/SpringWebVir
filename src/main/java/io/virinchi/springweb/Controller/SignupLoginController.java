package io.virinchi.springweb.Controller;

import io.virinchi.springweb.Model.UserTbl;
import io.virinchi.springweb.Repository.UserRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Base64;

@Controller
@RequiredArgsConstructor //autowired
public class SignupLoginController {

private final JavaMailSender jms;

private  final UserRepository uRepo ;


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
   String email= request.getParameter("email");

   String hashPassword = DigestUtils.md5DigestAsHex(password.getBytes());
   //md5 algorithm, this is basic algorithm, anyone can hack this
    //we will learn bcrypt technique very soon

UserTbl user = new UserTbl();
user.setUsername(username);
user.setPassword(hashPassword);

uRepo.save(user);

//Mail Sender
    SimpleMailMessage message = new SimpleMailMessage();
    message.setTo(email);
    message.setSubject("Signup Successful");

    message.setText("Congratulations! you have successfuly signed up!!! WELCOME: "+username);

    jms.send(message);

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
       HttpSession session= request.getSession();
       //request bhaneko http ko request ho
       //session http ma banaune

session.setAttribute("username",username);
//yedi userko password ra username mileko chha bhane usko
       //session ma euta attribute janchha
       //session janchha until user logs out

      m.addAttribute("totalUsers",uRepo.findAll());
return "home";
   }
//message pathauna kunai page ma hamlai MODEL chainchha
    //Controller bata html page ma model le msg transfer garchha
    //MODEL ma attribute rakhera pathauchhau
//m.addAttribute("title","msg")
    m.addAttribute("error", "Username or password is incorrect");
    return "loginPage";
}

@GetMapping("/logout")
public String logoutGet(HttpSession session, Model m)
{

    session.invalidate();

    m.addAttribute("message","You have logged out!");
return "loginPage";
}


}
