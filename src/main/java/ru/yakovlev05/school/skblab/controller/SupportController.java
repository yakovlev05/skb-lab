package ru.yakovlev05.school.skblab.controller;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.yakovlev05.school.skblab.dto.UserInfoDto;

@RestController
@RequestMapping("/support/api")
public class SupportController {

    @GetMapping
    public UserInfoDto get(@AuthenticationPrincipal UserDetails user) {
        return new UserInfoDto(
                user.getUsername(),
                user.getAuthorities().stream()
                        .map(GrantedAuthority::getAuthority)
                        .toList()
        );
    }

}
