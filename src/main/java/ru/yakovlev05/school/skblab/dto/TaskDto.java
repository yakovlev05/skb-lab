package ru.yakovlev05.school.skblab.dto;

import java.util.List;

public record TaskDto(String name, List<String> events) {
}
