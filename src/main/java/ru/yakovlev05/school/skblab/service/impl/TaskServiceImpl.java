package ru.yakovlev05.school.skblab.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.yakovlev05.school.skblab.dto.TaskDto;
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

    @Override
    public void createTask(TaskDto taskRequest) {
        TaskEntity task = new TaskEntity();
        task.setName(taskRequest.name());

        Set<EventEntity> events = taskRequest.events().stream()
                .map(title -> new EventEntity(title, task))
                .collect(Collectors.toSet());
        task.setEvents(events);

        taskRepository.save(task);
    }

    @Override
    public List<TaskDto> getAllTasks() {
        return taskRepository.findAll().stream()
                .map(task -> new TaskDto(
                        task.getName(),
                        task.getEvents().stream()
                                .map(EventEntity::getTitle)
                                .toList())
                )
                .toList();
    }
}
