package ru.yakovlev05.school.skblab.dto;

import ru.yakovlev05.school.skblab.entity.Product;

public record OrderCreateRequestDto(Product product, int count) {
}
