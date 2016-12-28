package pl.edu.pk.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pl.edu.pk.bean.enums.UserType;
import pl.edu.pk.form.LoginForm;
import pl.edu.pk.form.UserForm;
import pl.edu.pk.service.UserService;

@Controller
public class RegisterController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private UserForm userForm;
	
	@Autowired
	private LoginController loginController;
	
    @RequestMapping("/register")
    public String register(Model model){
    	model.addAttribute(userForm);
        return "register";
    }
    
    @RequestMapping(value ="/register", method = RequestMethod.POST)
    public String register(@ModelAttribute("userForm") @Valid UserForm userForm, BindingResult bindingResult, HttpServletRequest request, Model model){
    	if (bindingResult.hasErrors()){
    		return "register";
    	}
    	
    	if(!userForm.getPassword().equals(userForm.getPassword2())){
    		bindingResult.rejectValue("password", null, "Hasła muszą się zgadzać");
    		bindingResult.rejectValue("password2", null, "Hasła muszą się zgadzać");
    		return "register";
    	}
    	if (userService.isEmailUnique(userForm.getEmail())) {
    		userForm.setUserType(UserType.USER);
    		userService.save(userForm.getUser());
    	} else {
    		bindingResult.rejectValue("email", null, "Ten adres e-mail posiada już zarejestrowane konto");
    		return "register";
    	}
        return loginController.login(new LoginForm(userForm.getEmail(), userForm.getPassword()), request, model);
    }
    
}
