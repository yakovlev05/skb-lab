package ru.yakovlev05.school.skblab;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class EmailNotificationService implements NotificationService {
    @Override
    public void send(String message) {
        log.info("Sending email with message: {}", message);
    }

    @PostConstruct
    public void postConstruct() {
        log.info("EmailNotification service created");
    }

    @PreDestroy
    public void preDestroy() {
        log.info("EmailNotification service destroyed");
    }
}
