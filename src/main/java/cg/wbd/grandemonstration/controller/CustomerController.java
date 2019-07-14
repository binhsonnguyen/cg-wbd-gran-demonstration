package cg.wbd.grandemonstration.controller;

import cg.wbd.grandemonstration.model.Customer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Collections;
import java.util.List;

@Controller
public class CustomerController {
    @GetMapping("/customers")
    public String showList(HttpServletRequest request) {
        List<Customer> customers = Collections.emptyList();
        request.setAttribute("customers", customers);
        return "customers/list.jsp";
    }
}
