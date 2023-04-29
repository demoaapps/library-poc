package net.prasenjit.poc.library.core;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import net.prasenjit.poc.library.core.validator.MyValidator;

import java.lang.annotation.*;

@Documented
@Target(ElementType.TYPE)
@Constraint(validatedBy = MyValidator.class)
@Retention(RetentionPolicy.RUNTIME)
public @interface MyConstraint {
    String message() default "my constraint error";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
