package ru.yakovlev05.school.producer.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopic {

    @Value("${app.kafka.producer.hello.topic}")
    private String sayHelloTopic;

    @Bean
    public NewTopic helloCreateTopic() {
        return TopicBuilder
                .name(sayHelloTopic)
                .build();
    }
}
