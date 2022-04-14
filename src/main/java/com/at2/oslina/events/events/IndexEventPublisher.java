package com.at2.oslina.events.events;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@AllArgsConstructor
public class IndexEventPublisher {
    private final ApplicationEventPublisher eventPublisher;

    public void publish(TransactionalEvent event) {
        log.warn("Транзакционное событие пораждается");
        eventPublisher.publishEvent(event);
    }

    public void publish(AsyncEvent asyncEvent) {
        log.warn("Ассинхронное событие пораждается");
        eventPublisher.publishEvent(asyncEvent);
    }
}
