package ru.yakovlev05.school.skblab.dto;

import java.util.Date;

public record ErrorDto(
        Date timestamp,
        Integer status,
        String error,
        String path
) {
}
