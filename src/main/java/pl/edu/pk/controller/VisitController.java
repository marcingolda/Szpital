package pl.edu.pk.controller;

import java.util.EnumSet;
import java.util.List;

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
import pl.edu.pk.bean.Visit;
import pl.edu.pk.bean.enums.UserType;
import pl.edu.pk.bean.enums.VisitType;
import pl.edu.pk.form.VisitForm;
import pl.edu.pk.service.VisitService;
import pl.edu.pk.utils.PotentialVisitUtil;
import pl.edu.pk.utils.SessionUtil;

@Controller
@Scope(value=WebApplicationContext.SCOPE_REQUEST, proxyMode=ScopedProxyMode.TARGET_CLASS)
public class VisitController implements InitializingBean{
	
	@Autowired
	SessionUtil session;
	
	@Autowired
	VisitService visitService;
	
	@Autowired
	PotentialVisitUtil potentialVisitUtil;
	
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
    	model.addAttribute("title", "Zaplanowane wizyty");
        return "visit";
    }
    
    @RequestMapping("/oldvisit")
    public String oldvisit(Model model){
    	List<Visit> visits;
    	if(user.getUserType()== UserType.USER){
    		visits = visitService.getArchivedPatientVisits(user);
    	} else if (user.getUserType() == UserType.DOCTOR){
    		visits = visitService.getArchivedDoctorVisits(user);
    	} else {
    		return "error";
    	}
    	model.addAttribute("visits", visits);
    	model.addAttribute("title", "Archiwum wizyt");
        return "visit";
    }
    
    @RequestMapping("/newvisit")
    public String newvisit(Model model){
    	model.addAttribute("types", EnumSet.allOf(VisitType.class));
    	model.addAttribute("visitForm", new VisitForm());
        return "newvisittype";
    }
    
    @RequestMapping(value = "/newvisit", method = RequestMethod.POST)
    public String newvisit(@ModelAttribute VisitForm visitForm, Model model){
    	model.addAttribute("potenitalVisits", potentialVisitUtil.getPotentialVisitList(visitForm.getVisitType()));
    	return "newvisitrest";
    }
    
    @RequestMapping(value = "/newvisitsend", method = RequestMethod.POST)
    public String newvisitsend(@ModelAttribute VisitForm visitForm, BindingResult result, Model model){
    	visitService.save(potentialVisitUtil.getVisit(potentialVisitUtil.getPotentialVisitList(visitForm.getVisitType()), visitForm, user));
    	return "redirect:/visit";
    }
}
