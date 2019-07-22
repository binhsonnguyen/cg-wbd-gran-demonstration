package cg.wbd.grandemonstration.validator;

import cg.wbd.grandemonstration.model.Customer;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class CustomerEmailValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return Customer.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        errors.rejectValue("email", null, "No reason!");
    }
}
