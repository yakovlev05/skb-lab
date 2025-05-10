package ru.yakovlev05.school.skblab.metric.counter;

import io.micrometer.core.instrument.MeterRegistry;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Aspect
@Component
public class CounterAspect {

    private final MeterRegistry meterRegistry;

    @Before("@annotation(counter)")
    public void count(Counter counter) throws Throwable {
        meterRegistry.counter("custom.counter.global").increment();
        meterRegistry.counter("custom.counter." + counter.name()).increment();
    }

}
