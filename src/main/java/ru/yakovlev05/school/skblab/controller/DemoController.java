package ru.yakovlev05.school.skblab.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.yakovlev05.school.skblab.ratelimit.RateLimit;

@RestController
@RequestMapping("/api/demo")
public class DemoController {

    @RateLimit
    @GetMapping("/execute")
    public String execute() {
        return "Hello ;)";
    }

}
