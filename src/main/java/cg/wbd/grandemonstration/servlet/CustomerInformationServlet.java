package cg.wbd.grandemonstration.servlet;

import cg.wbd.grandemonstration.model.Customer;
import cg.wbd.grandemonstration.service.CustomerService;
import cg.wbd.grandemonstration.service.impl.SimpleCustomerServiceImpl;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CustomerInformationServlet extends HttpServlet {
    private static final CustomerService CUSTOMER_SERVICE = new SimpleCustomerServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Long id = Long.valueOf(req.getParameter("id"));
        Customer customer = CUSTOMER_SERVICE.findOne(id);
        resp.getOutputStream().println("Hello world! " + customer);
    }
}
