package ru.yakovlev05.school.skblab.service;

import jakarta.validation.Valid;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import ru.yakovlev05.school.skblab.dto.UserIn;

@Validated
@Service
public class UserService {
    public void save(@Valid UserIn user) {
        System.out.println(user);
    }
}
