package cg.wbd.grandemonstration.controller;

import cg.wbd.grandemonstration.model.Customer;
import cg.wbd.grandemonstration.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("customers")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping
    public ModelAndView showList() {
        ModelAndView modelAndView = new ModelAndView("customers/list");
        List<Customer> customers = customerService.findAll();
        modelAndView.addObject("customers", customers);
        return modelAndView;
    }

    @GetMapping("{id}")
    public ModelAndView showInformation(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("customers/info");
        Customer customer = customerService.findOne(id);
        modelAndView.addObject("customer", customer);
        return modelAndView;
    }

    @PostMapping
    public String updateCustomer(Customer customer, HttpServletRequest request) {
        userCredentialInterpretation(request);
        customerService.save(customer);
        return "redirect:/customers";
    }

    private void userCredentialInterpretation(HttpServletRequest request) {
        if (getUserCredentials(request).isEmpty()) {
            throw new AuthenticationCredentialsNotFoundException("Authentication credentials not found!");
        }
    }

    private String getUserCredentials(HttpServletRequest request) {
        Cookie userCredentialCookie = findUserCredentialCookie(request);
        return userCredentialCookie == null ? "" : userCredentialCookie.getValue();
    }

    private Cookie findUserCredentialCookie(HttpServletRequest request) {
        if (request.getCookies() == null) {
            return null;
        }

        for (Cookie ck : request.getCookies()) {
            if (isUserCredentialCookie(ck)) {
                return ck;
            }
        }

        return null;
    }

    private boolean isUserCredentialCookie(Cookie cookie) {
        return "username".equals(cookie.getName());
    }
}
