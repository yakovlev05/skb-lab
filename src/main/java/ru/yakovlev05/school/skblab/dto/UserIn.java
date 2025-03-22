package ru.yakovlev05.school.skblab.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import ru.yakovlev05.school.skblab.validation.Strong;
import ru.yakovlev05.school.skblab.validation.Username;

public record UserIn(
        @NotBlank String name,
        @NotBlank String surname,
        @Username String username, // аннотация, объединяющая две другие
        @Min(18) Integer age,
        @Email String email,
        @Strong String password // кастомная аннотация со своим обработчиком
) {
}
