package ru.yakovlev05.school.skblab.service;

import ru.yakovlev05.school.skblab.dto.TaskDtoIn;
import ru.yakovlev05.school.skblab.dto.TaskDtoOut;

import java.util.List;

public interface TaskService {
    void createTask(TaskDtoIn taskRequest);

    List<TaskDtoOut> getAllTasks();
}
