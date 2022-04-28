package at2.oslina.aspect.controller;

import at2.oslina.aspect.aspect.MaxCount;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@Controller
public class IndexController {
    private final MainController mainController;

    @GetMapping("/with-max/1")
    @MaxCount(max = 5)
    public @ResponseBody String withMaxFirst() {
        return "Пока еще можно видеть";
    }

    @GetMapping("/with-max/2")
    @MaxCount(max = 10)
    public @ResponseBody String withMaxSecond() {
        return "Пока еще можно видеть";
    }

    @GetMapping("/without")
    public @ResponseBody String without() {
        return "Видно всегда";
    }
}
