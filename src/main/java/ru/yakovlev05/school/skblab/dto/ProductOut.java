package ru.yakovlev05.school.skblab.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class ProductOut {

    private BigDecimal price;
    private ProductOut.Info info;

    @Data
    public static class Info {
        private Long id;
        private Date date;
    }

}
