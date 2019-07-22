package cg.wbd.grandemonstration.validator;

import javax.validation.Constraint;

@Constraint(validatedBy = UniqueEmailValidator.class)
public @interface UniqueEmail {
}
