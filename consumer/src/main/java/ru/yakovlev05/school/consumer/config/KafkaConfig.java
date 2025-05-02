package ru.yakovlev05.school.consumer.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.listener.CommonLoggingErrorHandler;
import org.springframework.kafka.support.serializer.ErrorHandlingDeserializer;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import ru.yakovlev05.school.consumer.dto.HelloDto;

@RequiredArgsConstructor
@Configuration
@EnableKafka
public class KafkaConfig {

    @Value("${app.kafka.consumer.hello.package}")
    private String trustedPackage;

    private final ObjectMapper objectMapper;
    private final KafkaProperties kafkaProperties;

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, HelloDto> helloListenerContainerFactory() {
        return buildListenerContainerFactory(HelloDto.class);
    }

    <T> ConcurrentKafkaListenerContainerFactory<String, T> buildListenerContainerFactory(Class<T> clazz) {
        var consumerFactory = new DefaultKafkaConsumerFactory<>(
                kafkaProperties.buildConsumerProperties(),
                new StringDeserializer(),
                new ErrorHandlingDeserializer<>(
                        new JsonDeserializer<>(
                                clazz, objectMapper, false
                        )
                )
        );

        var listenerContainerFactory = new ConcurrentKafkaListenerContainerFactory<String, T>();
        listenerContainerFactory.setConsumerFactory(consumerFactory);
        listenerContainerFactory.setCommonErrorHandler(commonLoggingErrorHandler());
        return listenerContainerFactory;
    }


    @Bean
    public CommonLoggingErrorHandler commonLoggingErrorHandler() {
        return new CommonLoggingErrorHandler();
    }

}
