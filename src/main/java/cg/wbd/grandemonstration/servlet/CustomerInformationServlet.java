package cg.wbd.grandemonstration.servlet;

import cg.wbd.grandemonstration.model.Customer;
import cg.wbd.grandemonstration.service.CustomerService;
import cg.wbd.grandemonstration.servicefactory.CustomerServiceFactory;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CustomerInformationServlet extends HttpServlet {
    private CustomerService customerService = CustomerServiceFactory.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Long id = Long.valueOf(req.getParameter("id"));
        Customer customer = customerService.findOne(id);
        StringBuilder viewBuilder = new StringBuilder()
                .append("<form method='post'>")
                .append("<fieldset>")
                .append("  <legend>Customer Information</legend>").append(String.format(
                        "  <input type='hidden' name='id' value='%d'>", customer.getId()))
                .append("  <table>")
                .append("    <tr>")
                .append("      <td>Id</td>").append(String.format(
                        "      <td>%s</td>", customer.getId()))
                .append("    </tr>")
                .append("    <tr>")
                .append("      <td>Name</td>")
                .append("      <td>").append(String.format(
                        "        <input type='text' name='name' value='%s'>", customer.getName()))
                .append("      </td>")
                .append("    </tr>")
                .append("    <tr>")
                .append("      <td>Email</td>")
                .append("      <td>").append(String.format(
                        "        <input type='text' name='email' value='%s'>", customer.getEmail()))
                .append("      </td>")
                .append("    </tr>")
                .append("    <tr>")
                .append("      <td>Address</td>")
                .append("      <td>").append(String.format(
                        "        <input type='text' name='address' value='%s'>", customer.getAddress()))
                .append("      </td>")
                .append("    </tr>")
                .append("    <tr>")
                .append("      <td colspan='2'>")
                .append("        <input type='submit' value='Update'>")
                .append("      </td>")
                .append("    </tr>")
                .append("  </table>")
                .append("</fieldset>")
                .append("</form>")
                .append("<a href='/customers'>Back to list</a>.");
        resp.getOutputStream().println(viewBuilder.toString());
        resp.setContentType("text/html");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Customer customer = new Customer();
        customer.setId(Long.valueOf(req.getParameter("id")));
        customer.setName(req.getParameter("name"));
        customer.setEmail(req.getParameter("email"));
        customer.setAddress(req.getParameter("address"));
        customerService.save(customer);
        resp.sendRedirect("/customers");
    }
}
