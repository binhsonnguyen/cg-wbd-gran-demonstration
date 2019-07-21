package cg.wbd.grandemonstration.controller;

import cg.wbd.grandemonstration.model.UserCredential;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@Controller
public class UserController {
    private static String adminUsername = "admin";
    private static String adminPassword = "123456";

    @GetMapping("/login")
    public ModelAndView showLoginForm() {
        ModelAndView modelAndView = new ModelAndView("login");
        modelAndView.addObject("userCredential", new UserCredential());
        return modelAndView;
    }

    @PostMapping("/login")
    public String login(UserCredential userCredential, HttpServletResponse response) {
        if (authenticated(userCredential)) {
            Cookie userCredentialCookie = new Cookie("username", userCredential.getUsername());
            userCredentialCookie.setMaxAge(25);
            response.addCookie(userCredentialCookie);
            return "redirect:/customers";
        }

        Cookie userCredentialCookie = new Cookie("username", null);
        userCredentialCookie.setMaxAge(0);
        response.addCookie(userCredentialCookie);
        return "redirect:/login";
    }

    private boolean authenticated(UserCredential userCredential) {
        return adminUsername.equals(userCredential.getUsername())
                && adminPassword.equals(userCredential.getPassword());
    }
}
