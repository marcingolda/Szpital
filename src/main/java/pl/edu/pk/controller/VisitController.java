package pl.edu.pk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import pl.edu.pk.form.LoginForm;

@Controller
public class VisitController {
    @RequestMapping("/visit")
    public String about(Model model){
        return "visit";
    }
}
