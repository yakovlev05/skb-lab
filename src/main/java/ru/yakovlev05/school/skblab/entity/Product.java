package ru.yakovlev05.school.skblab.entity;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
@Builder
public class Product {

    private Long id;
    private BigDecimal price;
    private Date date;

}
