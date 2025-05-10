package ru.yakovlev05.school.skblab.metric.statistic;

import io.micrometer.core.instrument.MeterRegistry;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import ru.yakovlev05.school.skblab.event.CreateOrderEvent;

@RequiredArgsConstructor
@Component
public class OrderEventListener {

    private final MeterRegistry meterRegistry;

    @EventListener
    public void handleCreateOrderEvent(CreateOrderEvent event) {
        meterRegistry.counter("custom.statistic." + event.product()).increment(event.count());
    }
}
