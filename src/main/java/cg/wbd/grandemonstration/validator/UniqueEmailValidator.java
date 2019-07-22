package cg.wbd.grandemonstration.validator;

import cg.wbd.grandemonstration.model.Customer;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueEmailValidator implements ConstraintValidator<UniqueEmail, Customer> {
    @Override
    public boolean isValid(Customer value, ConstraintValidatorContext context) {
        return false;
    }
}
