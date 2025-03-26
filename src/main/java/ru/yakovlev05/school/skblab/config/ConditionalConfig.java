package ru.yakovlev05.school.skblab.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Slf4j
@Configuration
public class ConditionalConfig {

    @Profile("test")
    @Bean
    public String onlyTestProfile() {
        log.info("Created onlyTestProfile");
        return "";
    }

    @ConditionalOnBean(name = "onlyTestProfile")
    @Bean
    public String existOnlyTestProfile() {
        log.info("Created existOnlyTestProfile");
        return "";
    }

    @ConditionalOnExpression("#{'${special-env-variable}' != 'default'}")
    @Bean
    public String specialVariable() {
        log.info("Created specialVariable");
        return "";
    }

}
