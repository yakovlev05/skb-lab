package ru.yakovlev05.school.skblab.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.yakovlev05.school.skblab.config.props.MyConfigProps;

@RequiredArgsConstructor
@RestController
@RequestMapping("/checks")
public class CheckController {

    private final MyConfigProps myConfigProps;

    @GetMapping("/props")
    public String check() {
        return myConfigProps.toString();
    }

}
