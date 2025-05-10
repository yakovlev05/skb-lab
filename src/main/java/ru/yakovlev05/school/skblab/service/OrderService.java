package ru.yakovlev05.school.skblab.service;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import ru.yakovlev05.school.skblab.dto.OrderCreateRequestDto;
import ru.yakovlev05.school.skblab.dto.OrderResponseDto;
import ru.yakovlev05.school.skblab.entity.OrderEntity;
import ru.yakovlev05.school.skblab.event.CreateOrderEvent;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class OrderService {

    private final List<OrderEntity> orders = Collections.synchronizedList(new ArrayList<>());
    private final AtomicLong currentId = new AtomicLong();
    private final ApplicationEventPublisher applicationEventPublisher;

    public OrderService(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }

    public OrderResponseDto createOrder(OrderCreateRequestDto request) {
        OrderEntity order = new OrderEntity(request.product(), request.count());
        order.setId(currentId.incrementAndGet());

        orders.add(order);

        applicationEventPublisher.publishEvent(new CreateOrderEvent(order.getProduct(), order.getCount()));

        return toDto(order);
    }

    public List<OrderResponseDto> getAllOrders() {
        return orders.stream()
                .map(this::toDto)
                .toList();
    }

    private OrderResponseDto toDto(OrderEntity order) {
        return new OrderResponseDto(order.getId(), order.getProduct(), order.getCount());
    }
}
