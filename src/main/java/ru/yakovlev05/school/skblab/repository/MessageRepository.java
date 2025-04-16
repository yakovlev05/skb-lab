package ru.yakovlev05.school.skblab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.yakovlev05.school.skblab.entity.Message;

public interface MessageRepository extends JpaRepository<Message, Long> {
}
