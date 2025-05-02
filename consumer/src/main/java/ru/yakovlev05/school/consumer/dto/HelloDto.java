package ru.yakovlev05.school.consumer.dto;

import java.time.Instant;

public record HelloDto(String message, Instant timestamp) {
}
