package at2.oslina.dbvalid.listener;

import at2.oslina.dbvalid.metric.DbSizeMetric;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.persistence.PostPersist;
import javax.persistence.PostRemove;

@Service
@AllArgsConstructor
public class DbListener {
    private final DbSizeMetric dbSizeMetric;

    @PostPersist
    private void afterSave(Object obj) {
        dbSizeMetric.increment();
    }

    @PostRemove
    private void afterDelete(Object obj) {
        dbSizeMetric.decrement();
    }
}
