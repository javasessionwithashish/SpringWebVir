package io.virinchi.springweb.Controller;

import io.virinchi.springweb.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
//Controller - manages http requests : Get Mapping, Post Mapping,etc
//@Profile("/prod")
//@Profile("/default")
public class AllController {
    @Autowired
    private UserRepository uRepo;

    @GetMapping("/")
    public String firstPage()
    {
return "firstPage.html";
    }


    @GetMapping("/home")
    public String homeGet(Model m)
    {
        m.addAttribute("totalUsers",uRepo.findAll() );

        return "home.html";
    }

}
