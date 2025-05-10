package ru.yakovlev05.school.skblab.actutator;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Slf4j
@Component
@Endpoint(id = "custom")
public class CustomActuator {

    @ReadOperation(produces = MediaType.TEXT_PLAIN_VALUE)
    public String read() {
        log.info("Actuator read: {}", Instant.now());
        return "logged";
    }

}
