package pl.edu.pk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
    @RequestMapping("/")
    public String index(){
        return "index";
    }
    
    @RequestMapping("/about")
    public String about(){
        return "about";
    }
    
    @RequestMapping("/offer")
    public String offer(){
        return "offer";
    }
    
    @RequestMapping("/contact")
    public String contact(){
        return "contact";
    }
}
