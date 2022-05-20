package at2.oslina.proj1.service;

import lombok.AllArgsConstructor;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MessageService {
    private final JmsTemplate jmsTemplate;

    public void sendMessage(String message) {
        jmsTemplate.convertAndSend("messages", message);
    }
}
