package at2.oslina.proj2;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MessageListener {
    @JmsListener(destination = "messages")
    public void print(String message) {
        log.error(message);
    }
}
