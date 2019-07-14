package cg.wbd.grandemonstration.controller;

import cg.wbd.grandemonstration.model.Customer;
import cg.wbd.grandemonstration.service.CustomerService;
import cg.wbd.grandemonstration.service.CustomerServiceFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static cg.wbd.grandemonstration.controller.RequestSupport.*;

public class CustomerController extends HttpServlet {
    private CustomerService customerService = CustomerServiceFactory.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException, ServletException {
        String action = getActionValue(req);
        if (isDefault(action)) {
            showList(req, resp);
        } else if (isEdit(action)) {
            showInformation(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Customer customer = parseCustomer(req);
        customerService.save(customer);
        resp.sendRedirect("/customers");
    }

    private void showList(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setAttribute("customers", customerService.findAll());
        RequestDispatcher dispatcher = req.getRequestDispatcher("/customers/list.jsp");
        dispatcher.forward(req, resp);
    }

    private void showInformation(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        Long id = Long.valueOf(req.getParameter("id"));
        req.setAttribute("customer", customerService.findOne(id));
        RequestDispatcher dispatcher = req.getRequestDispatcher("/customers/info.jsp");
        dispatcher.forward(req, resp);
    }

}
