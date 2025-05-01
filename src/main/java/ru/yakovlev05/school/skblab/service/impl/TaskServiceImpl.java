package ru.yakovlev05.school.skblab.service.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.yakovlev05.school.skblab.dto.TaskDtoIn;
import ru.yakovlev05.school.skblab.dto.TaskDtoOut;
import ru.yakovlev05.school.skblab.entity.EventEntity;
import ru.yakovlev05.school.skblab.entity.TaskEntity;
import ru.yakovlev05.school.skblab.repository.TaskRepository;
import ru.yakovlev05.school.skblab.service.TaskService;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    @Transactional
    @Override
    public void createTask(TaskDtoIn taskRequest) {
        TaskEntity task = new TaskEntity();
        task.setName(taskRequest.name());

        Set<EventEntity> events = taskRequest.events().stream()
                .map(title -> new EventEntity(title, task))
                .collect(Collectors.toSet());
        task.getEvents().addAll(events);

        taskRepository.save(task);
    }

    @Transactional
    @Override
    public List<TaskDtoOut> getAllTasks() {
        return taskRepository.findAllAndFetchEvents().stream()
                .map(task -> new TaskDtoOut(
                        task.getName(),
                        task.getEvents().stream()
                                .map(EventEntity::getTitle)
                                .toList())
                )
                .toList();
    }
}
