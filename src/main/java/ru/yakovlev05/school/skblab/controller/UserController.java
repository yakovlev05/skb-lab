package ru.yakovlev05.school.skblab.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.yakovlev05.school.skblab.dto.UserIn;
import ru.yakovlev05.school.skblab.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {


    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void register(@RequestBody UserIn user) {
        userService.save(user);
    }
}
