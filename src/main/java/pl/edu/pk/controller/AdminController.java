package pl.edu.pk.controller;

import java.util.EnumSet;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.WebApplicationContext;

import pl.edu.pk.bean.User;
import pl.edu.pk.bean.enums.UserType;
import pl.edu.pk.bean.enums.VisitType;
import pl.edu.pk.service.UserService;
import pl.edu.pk.utils.SessionUtil;

@Controller
@Scope(value=WebApplicationContext.SCOPE_REQUEST, proxyMode=ScopedProxyMode.TARGET_CLASS)
public class AdminController implements InitializingBean {
	
	@Autowired
	SessionUtil session;
	
	@Autowired
	UserService userService;
	
	User user;
	
	@Override
	public void afterPropertiesSet() throws Exception {
		user = session.getUser();
		
	}
	
	private boolean isPermited(){
		return user.getUserType() == UserType.ADMINISTRATOR;
	}
	
	@RequestMapping("/admin/doctors")
	public String doctorsList(Model model){
		if (!isPermited()){
			return "error";
		}
		model.addAttribute("doctors", userService.getAllDoctors());
		return "admin/doctors";
	}
	
	@RequestMapping("/admin/newdoctor")
	public String newDoctor(Model model){
		model.addAttribute("doctor", new User());
		model.addAttribute("types", EnumSet.allOf(VisitType.class));
		return "admin/newdoctor";
	}
	
	@RequestMapping(value = "/admin/newdoctor", method= RequestMethod.POST)
    public String register(@ModelAttribute("doctor") @Valid User doctor, BindingResult bindingResult, Model model){
		model.addAttribute("types", EnumSet.allOf(VisitType.class));
    	if (bindingResult.hasErrors()){
    		return "admin/newdoctor";
    	}
    	if (userService.isEmailUnique(doctor.getEmail())) {
    		doctor.setUserType(UserType.DOCTOR);
    		userService.save(doctor);
    	} else {
    		bindingResult.rejectValue("email", null, "Ten adres e-mail posiada już zarejestrowane konto");
    		return "admin/newdoctor";
    	}
        return "redirect:/admin/doctors";
    }

}
