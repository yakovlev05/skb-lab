package ru.yakovlev05.school.consumer.listener;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;
import ru.yakovlev05.school.consumer.dto.HelloDto;
import ru.yakovlev05.school.consumer.service.HelloService;

@RequiredArgsConstructor
@Component
public class HelloListener {

    private final HelloService helloService;

    @KafkaListener(topics = "${app.kafka.consumer.hello.topic}",
            groupId = "${app.kafka.consumer.hello.group-id}",
            containerFactory = "helloListenerContainerFactory")
    public void onMessage(@Payload HelloDto helloDto) {
        helloService.receiveHello(helloDto);
    }

}
