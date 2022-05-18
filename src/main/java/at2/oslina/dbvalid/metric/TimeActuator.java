package at2.oslina.dbvalid.metric;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@Endpoint(id = "time")
@Slf4j
public class TimeActuator {
    @ReadOperation
    public String datetime() {
        return LocalDateTime.now().toString();
    }
}
