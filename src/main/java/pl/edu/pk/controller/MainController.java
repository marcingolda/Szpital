package pl.edu.pk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.edu.pk.service.UserService;

@Controller
public class MainController {
	
	@Autowired
	private UserService userService;

    @RequestMapping("/")
    public String helloWorld(){
        return "index";
    }
}
