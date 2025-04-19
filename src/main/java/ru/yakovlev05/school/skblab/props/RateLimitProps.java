package ru.yakovlev05.school.skblab.props;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Setter
@Getter
@Component
@ConfigurationProperties(prefix = "rate-limit")
public class RateLimitProps {
    private Long countOfRequests;
    private Long windowToCheck;
}
