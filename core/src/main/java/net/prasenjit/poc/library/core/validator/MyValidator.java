package net.prasenjit.poc.library.core.validator;

import jakarta.validation.ConstraintValidatorContext;
import jakarta.validation.metadata.ConstraintDescriptor;
import net.prasenjit.poc.library.core.MyConstraint;
import org.hibernate.validator.constraintvalidation.HibernateConstraintValidator;
import org.hibernate.validator.constraintvalidation.HibernateConstraintValidatorInitializationContext;

public class MyValidator implements HibernateConstraintValidator<MyConstraint, Object> {
    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        return false;
    }

    @Override
    public void initialize(ConstraintDescriptor<MyConstraint> constraintDescriptor,
                           HibernateConstraintValidatorInitializationContext initializationContext) {
        HibernateConstraintValidator.super.initialize(constraintDescriptor, initializationContext);
    }
}
