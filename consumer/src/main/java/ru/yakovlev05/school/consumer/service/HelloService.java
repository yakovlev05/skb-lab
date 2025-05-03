package ru.yakovlev05.school.consumer.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.yakovlev05.school.consumer.dto.HelloDto;

@Slf4j
@Service
public class HelloService {

    public void receiveHello(HelloDto helloDto) {
        log.info("Received hello: {}", helloDto);
    }

}
