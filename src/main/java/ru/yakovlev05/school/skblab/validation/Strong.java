package ru.yakovlev05.school.skblab.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Constraint(validatedBy = {StrongConstraintValidator.class})
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Strong {
    String message() default "пароль слишком слабый";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
