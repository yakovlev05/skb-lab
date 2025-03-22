package ru.yakovlev05.school.skblab.dto;

import java.util.List;
import java.util.Map;

public record ErrorResponse(Long timestamp, String path, String message, Map<String,String> errors) {
}
