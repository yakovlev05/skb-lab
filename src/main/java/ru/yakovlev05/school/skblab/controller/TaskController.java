package ru.yakovlev05.school.skblab.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.yakovlev05.school.skblab.dto.TaskDto;
import ru.yakovlev05.school.skblab.service.TaskService;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void createTask(@RequestBody TaskDto taskRequest) {
        taskService.createTask(taskRequest);
    }

    @GetMapping
    public List<TaskDto> getAllTasks() {
        return taskService.getAllTasks();
    }

}
