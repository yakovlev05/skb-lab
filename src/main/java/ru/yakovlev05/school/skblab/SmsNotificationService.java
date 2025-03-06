package ru.yakovlev05.school.skblab;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class SmsNotificationService implements NotificationService {
    @Override
    public void send(String message) {
        log.info("Sending sms with message: {}", message);
    }

    @PostConstruct
    private void postConstruct() {
        log.info("SmsNotification service created");
    }

    @PreDestroy
    private void preDestroy() {
        log.info("SmsNotification service destroyed");
    }
}
