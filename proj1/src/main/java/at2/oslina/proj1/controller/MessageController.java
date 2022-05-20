package at2.oslina.proj1.controller;

import at2.oslina.proj1.service.MessageService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class MessageController {
    private final MessageService messageService;

    @PostMapping("/message")
    public void send(@RequestParam String message) {
        messageService.sendMessage(message);
    }
}
