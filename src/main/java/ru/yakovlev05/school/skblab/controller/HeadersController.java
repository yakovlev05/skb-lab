package ru.yakovlev05.school.skblab.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.yakovlev05.school.skblab.service.HeaderService;

@RequiredArgsConstructor
@Controller
@RequestMapping("/headers")
public class HeadersController {

    private final HeaderService headerService;

    @GetMapping
    public String getHeaders(@RequestHeader MultiValueMap<String, String> headers, Model model) {
        headerService.getHeaders(headers, model);
        return "headers";
    }

}
