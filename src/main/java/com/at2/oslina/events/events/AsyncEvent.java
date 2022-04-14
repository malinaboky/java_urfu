package com.at2.oslina.events.events;

import org.springframework.context.ApplicationEvent;

public class AsyncEvent extends ApplicationEvent {
    public AsyncEvent(Object source) {
        super(source);
    }
}
