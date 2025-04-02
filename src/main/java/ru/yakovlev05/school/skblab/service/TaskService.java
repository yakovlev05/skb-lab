package ru.yakovlev05.school.skblab.service;

import ru.yakovlev05.school.skblab.dto.TaskDto;

import java.util.List;

public interface TaskService {
    void createTask(TaskDto taskRequest);

    List<TaskDto> getAllTasks();
}
