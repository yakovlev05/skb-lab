package ru.yakovlev05.school.skblab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.yakovlev05.school.skblab.entity.TaskEntity;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<TaskEntity, Long> {
    @Query(value = """
            select t from TaskEntity t
            join fetch t.events
            """)
    List<TaskEntity> findAllAndFetchEvents();
}
