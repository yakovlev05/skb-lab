package ru.yakovlev05.school.skblab.exception;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.yakovlev05.school.skblab.dto.ErrorResponse;

import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalHandler {

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleConstraintViolationException(ConstraintViolationException ex, HttpServletRequest request) {
        return new ErrorResponse(
                System.currentTimeMillis(),
                request.getRequestURI(),
                "Неправильно заполнены поля",
                ex.getConstraintViolations().stream()
                        .collect(Collectors.toMap(
                                key -> key.getPropertyPath().toString(),
                                ConstraintViolation::getMessage
                        ))
        );
    }
}
