package pl.edu.pk.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pl.edu.pk.bean.User;
import pl.edu.pk.form.LoginForm;
import pl.edu.pk.service.UserService;

@Controller
public class LoginController {
	@Autowired
	private UserService userService;
	
    @RequestMapping(value ="/login", method = RequestMethod.POST)
    public String login(@ModelAttribute("loginForm") LoginForm loginForm, HttpServletRequest request, Model model){
    	userService.resolveAdminStatus();
    	User user = userService
    			.getAll()
    			.stream()
    			.filter(u -> u.getEmail()
				.equals(loginForm.getEmail()))
    			.findFirst()
    			.orElse(null);
    	if (user != null && user.getPassword().equals(loginForm.getPassword())){
    		request.getSession().setAttribute("user", user);
    	} else {
    		model.addAttribute("loginMessage", "Logowanie nieudane. Podano nieporawny adres e-mail lub hasło");
    	}
		return "index";
    	
    }
    
    @RequestMapping("/logout")
    public String logout(HttpServletRequest request){
    	request.getSession().removeAttribute("user");
		return "redirect:/";
    	
    }

}
