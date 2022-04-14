package com.at2.oslina.web.controller;

import com.at2.oslina.web.data.Price;
import com.at2.oslina.web.service.PriceService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@AllArgsConstructor
public class MainController {
    private final PriceService priceService;

    @GetMapping
    public String main(@RequestHeader Map<String, String> headers, Model model) {
        model.addAttribute("headers", headers);
        return "template";
    }

    @ResponseBody
    @PostMapping("/price")
    public Price savePrice(@RequestBody Price price) {
        return priceService.injectId(price);
    }
}
