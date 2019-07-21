package cg.wbd.grandemonstration.controller;

import cg.wbd.grandemonstration.model.UserCredential;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
    @GetMapping("/login")
    public ModelAndView showLoginForm() {
        ModelAndView modelAndView = new ModelAndView("login");
        modelAndView.addObject("userCredential", new UserCredential());
        return modelAndView;
    }

    @PostMapping("/login")
    public String login(UserCredential userCredential) {
        return "redirect:/customers";
    }
}
