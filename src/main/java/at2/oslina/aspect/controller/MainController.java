package at2.oslina.aspect.controller;

import at2.oslina.aspect.aspect.MaxCount;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
    @GetMapping("/useless")
    @MaxCount(max = 2) // аннотация не работает, так как может испльзоваться только в IndexController
    public @ResponseBody String useless() {
        return "useless";
    }
}
