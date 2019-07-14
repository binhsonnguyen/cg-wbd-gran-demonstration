package cg.wbd.grandemonstration.controller;

import cg.wbd.grandemonstration.model.Customer;

import javax.servlet.http.HttpServletRequest;

interface RequestSupport {
    String ACTION_EDIT = "EDIT";

    static String getActionValue(HttpServletRequest req) {
        String action = req.getParameter("action");
        return action == null ? "" : action.toUpperCase();
    }

    static boolean isDefault(String action) {
        return action.isEmpty();
    }

    static boolean isEdit(String action) {
        return action.equals(ACTION_EDIT);
    }

    static Customer parseCustomer(HttpServletRequest req) {
        Customer customer = new Customer();
        customer.setName(req.getParameter("name"));
        customer.setEmail(req.getParameter("email"));
        customer.setAddress(req.getParameter("address"));

        Long id = Long.valueOf(req.getParameter("id"));
        customer.setId(id);
        return customer;
    }
}
