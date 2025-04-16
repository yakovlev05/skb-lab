package ru.yakovlev05.school.skblab.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.yakovlev05.school.skblab.dto.MessageIn;
import ru.yakovlev05.school.skblab.service.MessageService;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/messages")
public class MessageController {

    private final MessageService messageService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    private void createMessage(@RequestBody MessageIn messageIn) {
        messageService.createMessage(messageIn);
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateMessage(@PathVariable Long id, @RequestBody MessageIn messageIn) {
        messageService.updateMessage(id, messageIn);
    }
}
