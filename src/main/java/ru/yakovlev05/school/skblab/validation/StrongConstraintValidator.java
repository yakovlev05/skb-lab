package ru.yakovlev05.school.skblab.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class StrongConstraintValidator implements ConstraintValidator<Strong, String> {

    private final static char[] STRONG_SYMBOLS = "!@#$%^&*()№;:?".toCharArray();

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        boolean containsStrongSymbols = false;
        for (char strongChar : STRONG_SYMBOLS) {
            if (value.contains(String.valueOf(strongChar))) {
                containsStrongSymbols = true;
                break;
            }
        }

        return containsStrongSymbols && value.length() >= 8;
    }
}
