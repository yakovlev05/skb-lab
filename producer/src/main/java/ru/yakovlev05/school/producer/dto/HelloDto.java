package ru.yakovlev05.school.producer.dto;

import java.time.Instant;

public record HelloDto(String message, Instant timestamp) {
}
