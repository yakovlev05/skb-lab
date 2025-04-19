package ru.yakovlev05.school.skblab.ratelimit;

import lombok.RequiredArgsConstructor;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import ru.yakovlev05.school.skblab.exception.RateLimitException;

@RequiredArgsConstructor
@Aspect
@Component
public class RateLimitAspect {

    private final RateLimitStorage rateLimitStorage;

    @Before("@annotation(RateLimit)")
    public void beforeRateLimit() {
        if (!rateLimitStorage.canHandleRequest()) {
            throw new RateLimitException("Too many requests");
        }

        rateLimitStorage.handleRequest();
    }

}
