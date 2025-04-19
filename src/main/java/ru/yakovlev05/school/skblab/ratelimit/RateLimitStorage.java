package ru.yakovlev05.school.skblab.ratelimit;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.yakovlev05.school.skblab.props.RateLimitProps;

import java.time.Instant;
import java.util.Deque;
import java.util.concurrent.ConcurrentLinkedDeque;

@RequiredArgsConstructor
@Component
public class RateLimitStorage {
    // Храним историю запросов. Их время
    private final Deque<Instant> requests = new ConcurrentLinkedDeque<>();

    private final RateLimitProps rateLimitProps;

    public void handleRequest() {
        requests.add(Instant.now());
    }

    public boolean canHandleRequest() {
        Instant window = Instant.now().minusSeconds(rateLimitProps.getWindowToCheck());

        while (requests.peek() != null && requests.peek().isBefore(window)) {
            requests.poll();
        }

        return requests.size() < rateLimitProps.getCountOfRequests();
    }
}
