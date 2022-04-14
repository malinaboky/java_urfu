package com.at2.oslina.web.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

@Data
public class Price {
    @JsonProperty("price")
    private Float price;
    @JsonProperty("info")
    private Info info;
}
