package io.virinchi.springweb.Controller;

import io.virinchi.springweb.Model.UserTbl;
import io.virinchi.springweb.Repository.UserRepository;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

    @Autowired
    private UserRepository uRepo;

@PostMapping("/deleteUser")
    public String deletePost(@RequestParam("id") int id, Model m)
{
//int id= req.getParameter("id");

    uRepo.deleteById(id);

    m.addAttribute("totalUsers",uRepo.findAll());
    return "home";
}


@PostMapping("/editUser")
    public String editUser(@RequestParam("id") int id ,Model m )
{
    UserTbl user = uRepo.getById(id);
// user ko information -> id, username, password
    //user.getId()......etc

m.addAttribute("user",user);
    return "editPage";
}


@PostMapping("/updateUser")
    public String updateUser(@ModelAttribute UserTbl user , Model m)
{
    //@ModelAttribute-> if the parameters like id,username,password matches
    //exactly with the model's table.
    //IN our case, our model UserTbl also has id, username,password that is coming
    //exactly from editPage.html, we use @ModelAttribute

    uRepo.save(user);
    //It uses the id parameter to update its username, we can directly use uRepo.save function

    m.addAttribute("totalUsers",uRepo.findAll());
    return "home";
}


}
