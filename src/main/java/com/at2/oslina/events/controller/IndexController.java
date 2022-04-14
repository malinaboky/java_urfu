package com.at2.oslina.events.controller;

import com.at2.oslina.events.events.AsyncEvent;
import com.at2.oslina.events.events.IndexEventPublisher;
import com.at2.oslina.events.events.TransactionalEvent;
import com.at2.oslina.events.service.IndexService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class IndexController {
    private final IndexService indexService;

    @GetMapping("/async")
    public @ResponseBody String executeAsync() {
        indexService.async();
        return "Logged async event";
    }

    @GetMapping("/transactional")
    public @ResponseBody String executeTransactional(@RequestParam Boolean isRollback) {
        indexService.transactional(isRollback);
        return "Logged transactional event";
    }
}
