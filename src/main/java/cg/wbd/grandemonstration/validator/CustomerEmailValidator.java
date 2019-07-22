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
        String email = customer.getEmail();
        Customer sameEmailOne = customerService
                .findAll()
                .stream()
                .filter(c -> Objects.equals(email, c.getEmail()))
                .findAny()
                .orElse(null);
        return sameEmailOne != null && !sameEmailOne.getId().equals(customer.getId());
    }
}
