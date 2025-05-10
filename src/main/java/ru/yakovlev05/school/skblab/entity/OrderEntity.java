package ru.yakovlev05.school.skblab.entity;

import lombok.Data;

@Data
public class OrderEntity {
    private Long id;
    private Product product;
    private int count;

    public OrderEntity(Product product, int count) {
        this.product = product;
        this.count = count;
    }
}
