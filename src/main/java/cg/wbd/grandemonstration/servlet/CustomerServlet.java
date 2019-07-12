package cg.wbd.grandemonstration.servlet;

import cg.wbd.grandemonstration.service.CustomerService;
import cg.wbd.grandemonstration.service.impl.SimpleCustomerServiceImpl;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CustomerServlet extends HttpServlet {
    private static final CustomerService CUSTOMER_SERVICE = new SimpleCustomerServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String template = "There are an %s customer(s) in list.";
        long customerCount = CUSTOMER_SERVICE.count();
        String view = String.format(template, customerCount);
        resp.getOutputStream().println(view);
    }
}
