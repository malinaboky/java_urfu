package com.at2.oslina.events.events;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;

public class TransactionalEvent extends ApplicationEvent {
    public TransactionalEvent(Object source) {
        super(source);
    }
}
