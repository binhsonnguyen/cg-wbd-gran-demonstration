package cg.wbd.grandemonstration.validator;

import cg.wbd.grandemonstration.model.Customer;
import cg.wbd.grandemonstration.service.CustomerService;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Objects;

public class CustomerEmailValidator implements Validator {

    private CustomerService customerService;

    public CustomerEmailValidator(CustomerService customerService) {
        this.customerService = customerService;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return Customer.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Customer customer = (Customer) target;
        if (isSameEmailWithOther(customer)) {
            errors.rejectValue("email", null, "Exists email!");
        }
    }

    private boolean isSameEmailWithOther(Customer customer) {
        return customerService
                .findAll()
                .stream()
                .filter(c -> isSameEmail(customer, c))
                .anyMatch(c -> !isSameId(customer, c));
    }

    private boolean isSameEmail(Customer c1, Customer c2) {
        return Objects.equals(c1.getEmail(), c2.getEmail());
    }

    private boolean isSameId(Customer c1, Customer c2) {
        return Objects.equals(c1.getId(), c2.getId());
    }
}
