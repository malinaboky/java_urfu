package at2.oslina.dbvalid.metric;

import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicInteger;

@Service
public class DbSizeMetric {
    private final AtomicInteger dbSize;

    public DbSizeMetric(MeterRegistry meterRegistry) {
        this.dbSize = meterRegistry.gauge("db.size", new AtomicInteger(0));
    }

    public void increment() {
        dbSize.incrementAndGet();
    }

    public void decrement() {
        dbSize.decrementAndGet();
    }
}
