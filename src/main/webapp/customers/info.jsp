<%@ page import="cg.wbd.grandemonstration.service.CustomerService" %>
<%@ page import="cg.wbd.grandemonstration.service.CustomerServiceFactory" %>
<%@ page import="cg.wbd.grandemonstration.model.Customer" %>
<%!
    private CustomerService customerService = CustomerServiceFactory.getInstance();
%>
<%
    Long id = Long.valueOf(request.getParameter("id"));
    Customer customer = customerService.findOne(id);
%>
<fieldset>
    <legend>Customer Information</legend>
    <table>
        <tr>
            <td>Id</td>
            <td>
                <input type="text" value="<%= customer.getId() %>">
            </td>
        </tr>
        <tr>
            <td>Name</td>
            <td>
                <input type="text" value="<%= customer.getName() %>">
            </td>
        </tr>
        <tr>
            <td>Email</td>
            <td>
                <input type="text" value="<%= customer.getEmail() %>">
            </td>
        </tr>
        <tr>
            <td>Address</td>
            <td>
                <input type="text" value="<%= customer.getAddress() %>">
            </td>
        </tr>
    </table>
</fieldset>