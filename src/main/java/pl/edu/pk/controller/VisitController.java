package pl.edu.pk.controller;

import java.util.List;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.WebApplicationContext;

import pl.edu.pk.bean.User;
import pl.edu.pk.bean.UserType;
import pl.edu.pk.bean.Visit;
import pl.edu.pk.service.VisitService;
import pl.edu.pk.utils.SessionUtil;

@Controller
@Scope(value=WebApplicationContext.SCOPE_REQUEST, proxyMode=ScopedProxyMode.TARGET_CLASS)
public class VisitController implements InitializingBean{
	
	@Autowired
	SessionUtil session;
	
	@Autowired
	VisitService visitService;
	
	User user;
	
	@Override
	public void afterPropertiesSet() throws Exception {
		user = session.getUser();
		
	}
	
    @RequestMapping("/visit")
    public String visit(Model model){
    	List<Visit> visits;
    	if(user.getUserType()== UserType.USER){
    		visits = visitService.getPlannedPatientVisits(user);
    	} else if (user.getUserType() == UserType.DOCTOR){
    		visits = visitService.getPlannedDoctorVisits(user);
    	} else {
    		return "error";
    	}
    	model.addAttribute("visits", visits);
        return "visit";
    }


}
