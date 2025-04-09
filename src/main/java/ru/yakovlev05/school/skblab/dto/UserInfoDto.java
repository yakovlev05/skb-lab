package ru.yakovlev05.school.skblab.dto;

import java.util.List;

public record UserInfoDto(String username, List<String> roles) {
}
