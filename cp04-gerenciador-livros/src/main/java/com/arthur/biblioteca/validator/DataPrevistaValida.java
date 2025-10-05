package com.arthur.biblioteca.validator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = DataPrevistaValidaValidator.class)
@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface DataPrevistaValida {
    String message() default "Data prevista deve ser posterior à data de retirada";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
