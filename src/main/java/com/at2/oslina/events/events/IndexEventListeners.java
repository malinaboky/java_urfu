package com.at2.oslina.events.events;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;
import org.springframework.web.context.support.RequestHandledEvent;

@Service
@Slf4j
public class IndexEventListeners {
    @EventListener(RequestHandledEvent.class)
    public void handleRequest(RequestHandledEvent event) {
        log.warn(event.getShortDescription());
        log.warn("Синхронный эвент выполнился.");
    }

    @Async
    @EventListener(AsyncEvent.class)
    public void handleAsync(AsyncEvent event) throws InterruptedException {
        Thread.sleep(1000);
        log.warn("Ассинхроный эвент обработался.");
    }

    @TransactionalEventListener(value = {TransactionalEvent.class}, phase = TransactionPhase.AFTER_COMMIT)
    public void handleAfterCommit(TransactionalEvent event) {
        log.warn("After commit выполнился.");
    }

    @TransactionalEventListener(value = {TransactionalEvent.class}, phase = TransactionPhase.AFTER_ROLLBACK)
    public void handleAfterRollback(TransactionalEvent event) {
        log.warn("After rollback выполнился.");
    }
}
