package ru.yakovlev05.school.skblab.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class ProductIn {

    private BigDecimal price;
    private Info info;

    @Data
    public static class Info {
        private Date date;
    }

}
