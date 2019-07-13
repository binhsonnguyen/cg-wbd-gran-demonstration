package cg.wbd.grandemonstration.servlet;

import cg.wbd.grandemonstration.model.Customer;
import cg.wbd.grandemonstration.service.CustomerService;
import cg.wbd.grandemonstration.service.impl.SimpleCustomerServiceImpl;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class CustomerServlet extends HttpServlet {
    private static final CustomerService CUSTOMER_SERVICE = new SimpleCustomerServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        long customerCount = CUSTOMER_SERVICE.count();
        StringBuilder viewBuilder = new StringBuilder()
                .append(String.format("There are an %s customer(s) in list.", customerCount))
                .append("<table>")
                .append("  <caption>Customer List</caption>")
                .append("  <thead>")
                .append("  <tr>")
                .append("    <th>ID</th>")
                .append("    <th>Name</th>")
                .append("    <th>Email</th>")
                .append("    <th>Address</th>")
                .append("  </tr>")
                .append("  </thead>")
                .append("  <tbody>");

        List<Customer> customers = CUSTOMER_SERVICE.findAll();
        for (Customer c : customers) {
            viewBuilder
                    .append("  <tr>")
                    .append(String.format("    <td>%d</td>", c.getId()))
                    .append(String.format("    <td><a href='customers/info?id=%d'>%s</a></td>",c.getId(), c.getName()))
                    .append(String.format("    <td>%s</td>", c.getEmail()))
                    .append(String.format("    <td>%s</td>", c.getAddress()))
                    .append("  </tr>");
        }

        viewBuilder
                .append("  </tbody>")
                .append("</table>");

        String view = viewBuilder.toString();
        resp.getOutputStream().println(view);
        resp.setContentType("text/html");
    }
}
