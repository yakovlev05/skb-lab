package ru.yakovlev05.school.skblab.exception.handler;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.yakovlev05.school.skblab.dto.ErrorDto;
import ru.yakovlev05.school.skblab.exception.RateLimitException;

import java.util.Date;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ResponseStatus(HttpStatus.TOO_MANY_REQUESTS)
    @ExceptionHandler(RateLimitException.class)
    public ErrorDto handleRateLimitException(RateLimitException ex, HttpServletRequest request) {
        return new ErrorDto(
                new Date(),
                429,
                ex.getMessage(),
                request.getServletPath()
        );
    }
}
