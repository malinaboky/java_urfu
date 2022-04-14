package com.at2.oslina.web.service;

import com.at2.oslina.web.data.Price;
import org.springframework.stereotype.Service;

@Service
public class PriceService {
    private Integer currentId = 0;

    public Price injectId(Price price) {
        price.getInfo().setId(currentId);
        currentId++;
        return price;
    }
}
