package ru.yakovlev05.school.skblab.metric.timer;

import io.micrometer.core.instrument.MeterRegistry;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Aspect
@Component
public class TimerAspect {


    private final MeterRegistry meterRegistry;

    @Around("@annotation(timer)")
    public Object timer(ProceedingJoinPoint jp, Timer timer) {
        return meterRegistry.timer("custom.timer." + timer.name())
                .record(() -> {
                    try {
                        return jp.proceed();
                    } catch (Throwable e) {
                        throw new RuntimeException(e);
                    }
                });
    }

}
