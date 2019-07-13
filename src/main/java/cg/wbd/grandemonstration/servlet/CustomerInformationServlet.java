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
                .append("<fieldset>")
                .append("  <legend>Customer Information</legend>")
                .append("  <table>")
                .append("    <tr>")
                .append("      <td>Id</td>")
                .append("      <td>").append(String.format(
                        "        <input type='text' value='%d'>", customer.getId()))
                .append("      </td>")
                .append("    </tr>")
                .append("    <tr>")
                .append("      <td>Name</td>")
                .append("      <td>").append(String.format(
                        "        <input type='text' value='%s'>", customer.getName()))
                .append("      </td>")
                .append("    </tr>")
                .append("    <tr>")
                .append("      <td>Email</td>")
                .append("      <td>").append(String.format(
                        "        <input type='text' value='%s'>", customer.getEmail()))
                .append("      </td>")
                .append("    </tr>")
                .append("    <tr>")
                .append("      <td>Address</td>")
                .append("      <td>").append(String.format(
                        "        <input type='text' value='%s'>", customer.getAddress()))
                .append("      </td>")
                .append("    </tr>")
                .append("  </table>")
                .append("</fieldset>");
        resp.getOutputStream().println(viewBuilder.toString());
        resp.setContentType("text/html");
    }
}
