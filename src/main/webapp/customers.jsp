<%@ page import="cg.wbd.grandemonstration.service.CustomerService" %>
<%@ page import="cg.wbd.grandemonstration.service.CustomerServiceFactory" %>
<%!
    private CustomerService customerService = CustomerServiceFactory.getInstance();
%>
<%
    long count = customerService.count();
%>
There are <%= count %> customer(s) in list.