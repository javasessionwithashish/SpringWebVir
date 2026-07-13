package io.virinchi.springweb.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
//Controller - manages http requests : Get Mapping, Post Mapping,etc
public class AllController {

    @GetMapping("/")
    public String firstPage()
    {
return "firstPage.html";
    }

}
