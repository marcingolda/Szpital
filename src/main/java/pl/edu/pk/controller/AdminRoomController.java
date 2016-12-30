package pl.edu.pk.controller;

import java.util.EnumSet;

import javax.validation.Valid;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.WebApplicationContext;

import pl.edu.pk.bean.Room;
import pl.edu.pk.bean.User;
import pl.edu.pk.bean.enums.UserType;
import pl.edu.pk.bean.enums.VisitType;
import pl.edu.pk.service.RoomService;
import pl.edu.pk.utils.SessionUtil;

@Controller
@Scope(value=WebApplicationContext.SCOPE_REQUEST, proxyMode=ScopedProxyMode.TARGET_CLASS)
public class AdminRoomController implements InitializingBean {
	
	@Autowired
	SessionUtil session;
	
	@Autowired
	RoomService roomService;
	
	User user;
	
	@Override
	public void afterPropertiesSet() throws Exception {
		user = session.getUser();
	}
	
	private boolean isPermited(){
		return user.getUserType() == UserType.ADMINISTRATOR;
	}
	
	@RequestMapping("admin/rooms")
	public String rooms(Model model){
		if (!isPermited()){
			return "error";
		}
		model.addAttribute("rooms", roomService.getAll());
		return "admin/rooms";
	}
	
	@RequestMapping("admin/newroom")
	public String newRoom(Model model){
		if (!isPermited()){
			return "error";
		}
		model.addAttribute("room", new Room());
		model.addAttribute("types", EnumSet.allOf(VisitType.class));
		return "admin/newroom";
	}
	
	@RequestMapping(value="admin/newroom", method= RequestMethod.POST)
	public String newRoom(@ModelAttribute @Valid Room room, BindingResult bindingResult, Model model){
		if (!isPermited()){
			return "error";
		}
		model.addAttribute("types", EnumSet.allOf(VisitType.class));
    	if (bindingResult.hasErrors()){
    		return "admin/newroom";
    	}
    	if (room.getRoomNumber() != 0 || roomService.isNumberUnique(room.getRoomNumber())) {
    		roomService.save(room);
    	} else {
    		bindingResult.rejectValue("roomNumber", null, "Ten numer gabinetu jest już zajęty");
    		return "admin/newdoctor";
    	}
        return "redirect:/admin/rooms";
	}
}