package ru.yakovlev05.school.skblab;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class BookService {

    private static final List<String> LIBRARY = List.of("Капитанская дочка", "Евгений Онегин");

    public boolean existBook(String title) {
        return LIBRARY.contains(title);
    }

    @PostConstruct
    public void postConstruct() {
        log.info("BookService created");
    }

    @PreDestroy
    public void preDestroy() {
        log.info("BookService destroyed");
    }
}
