package ru.yakovlev05.school.skblab;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class OrderService {

    @Autowired
    private NotificationService emailNotificationService; // Внедрение через поле

    @Setter(onMethod_ = @Autowired)
    private NotificationService smsNotificationService; // Внедрение через сеттер

    private final BookService bookService; // Внедрение через конструктор

    public void orderBook(String title) {
        if (bookService.existBook(title)) {
            log.info("Book {} ordered.", title);
            emailNotificationService.send("Book " + title + " has been ordered.");
            smsNotificationService.send("Book " + title + " has been ordered.");
        }
    }

    @PostConstruct
    public void postConstruct() {
        log.info("Order service created");

        // Проверка, что все бины внедрились правильно
        log.info("\n\n\n****Checking****");
        this.orderBook("Капитанская дочка");
        log.info("\n\n\n");
    }

    @PreDestroy
    public void preDestroy() {
        log.info("Order service destroyed");
    }
}
