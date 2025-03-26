package ru.yakovlev05.school.skblab.config;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import ru.yakovlev05.school.skblab.config.props.MyConfigProps;

@EnableConfigurationProperties(MyConfigProps.class)
@Configuration
public class MyConfig {
}
