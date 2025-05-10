package ru.yakovlev05.school.skblab.event;

import ru.yakovlev05.school.skblab.entity.Product;

public record CreateOrderEvent(Product product, int count) {
}
