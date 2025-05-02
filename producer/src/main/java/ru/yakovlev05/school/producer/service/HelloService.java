package ru.yakovlev05.school.producer.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import ru.yakovlev05.school.producer.dto.HelloDto;

import java.time.Instant;

@Slf4j
@RequiredArgsConstructor
@Service
public class HelloService {

    @Value("${app.kafka.producer.hello.topic}")
    private String sayHelloTopic;

    private final KafkaTemplate<String, Object> kafkaTemplate;

    public void sayHello() {
        kafkaTemplate.send(sayHelloTopic, new HelloDto("Hello, consumer!", Instant.now()))
                .thenRun(() -> {
                    log.info("Say hello topic: {}", sayHelloTopic);
                })
                .exceptionally((ex) -> {
                    log.error("Error while say hello", ex);
                    return null;
                });
    }

}
