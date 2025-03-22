package ru.yakovlev05.school.skblab.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@NotNull
@Size(min = 5, max = 20)
@Constraint(validatedBy = {})
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Username {
    String message() default "длина имени пользователя должна быть 5-20";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
