package io.virinchi.springweb.Controller;

import io.virinchi.springweb.Repository.UserRepository;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

}
