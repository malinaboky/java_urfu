package com.at2.oslina.events.service;

import com.at2.oslina.events.events.AsyncEvent;
import com.at2.oslina.events.events.IndexEventPublisher;
import com.at2.oslina.events.events.TransactionalEvent;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class IndexService {
    private final IndexEventPublisher publisher;

    public void async() {
        publisher.publish(new AsyncEvent(this));
    }

    @Transactional
    public void transactional(Boolean isRollback) {
        publisher.publish(new TransactionalEvent(this));
        if (isRollback)
            throw new IllegalArgumentException();
    }
}
