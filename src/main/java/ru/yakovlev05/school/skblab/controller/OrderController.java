package ru.yakovlev05.school.skblab.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.yakovlev05.school.skblab.dto.OrderCreateRequestDto;
import ru.yakovlev05.school.skblab.dto.OrderResponseDto;
import ru.yakovlev05.school.skblab.metric.counter.Counter;
import ru.yakovlev05.school.skblab.metric.timer.Timer;
import ru.yakovlev05.school.skblab.service.OrderService;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/orders")
public class OrderController {

    private final OrderService orderService;

    @Timer(name = "createOrder")
    @Counter(name = "createOrder")
    @PostMapping
    public OrderResponseDto createOrder(@RequestBody OrderCreateRequestDto request) {
        return orderService.createOrder(request);
    }

    @Timer(name = "getAllOrders")
    @Counter(name = "getAllOrders")
    @GetMapping
    public List<OrderResponseDto> getAllOrders() {
        return orderService.getAllOrders();
    }

}
