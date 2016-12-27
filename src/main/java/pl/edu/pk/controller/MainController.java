package pl.edu.pk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.edu.pk.form.LoginForm;

@Controller
public class MainController {
    @RequestMapping({"/", "/index"})
    public String index(Model model){
    	model.addAttribute("loginForm", new LoginForm());
        return "index";
    }
    
    @RequestMapping("/about")
    public String about(Model model){
    	model.addAttribute("loginForm", new LoginForm());
        return "about";
    }
    
    @RequestMapping("/offer")
    public String offer(Model model){
    	model.addAttribute("loginForm", new LoginForm());
        return "offer";
    }
    
    @RequestMapping("/contact")
    public String contact(Model model){
    	model.addAttribute("loginForm", new LoginForm());
        return "contact";
    }
}
