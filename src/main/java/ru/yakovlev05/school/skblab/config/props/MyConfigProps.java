package ru.yakovlev05.school.skblab.config.props;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

@Data
@ConfigurationProperties(prefix = "myconfig")
public class MyConfigProps {
    private String value1;
    private Integer value2;
    private Boolean value3;
    private List<String> list;
}
