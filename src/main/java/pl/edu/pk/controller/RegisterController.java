package pl.edu.pk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pl.edu.pk.form.UserForm;
import pl.edu.pk.service.UserService;

@Controller
public class RegisterController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private UserForm userForm;
	
    @RequestMapping("/register")
    public String register(Model model){
    	model.addAttribute(userForm);
        return "register";
    }
    
    @RequestMapping(value ="/register", method = RequestMethod.POST)
    public String register(UserForm userForm, BindingResult bindingResult){
    	if (bindingResult.hasErrors()){
    		return "register";
    	}
        return "index";
    }
    
}
