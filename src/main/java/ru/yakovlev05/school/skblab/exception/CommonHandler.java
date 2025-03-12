package ru.yakovlev05.school.skblab.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.yakovlev05.school.skblab.dto.ErrorResponse;

@RestControllerAdvice
public class CommonHandler {

    @ExceptionHandler(BadGatewayException.class)
    @ResponseStatus(HttpStatus.BAD_GATEWAY)
    public ErrorResponse handleBadGateway(BadGatewayException ex, HttpServletRequest request) {
        return new ErrorResponse(System.currentTimeMillis(), request.getRequestURI(), ex.getMessage());
    }

}
