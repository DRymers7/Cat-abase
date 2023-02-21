package com.catabase.mockdataproducerv2.model.pojos.objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.awt.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Photos {
    @JsonProperty("small")
    private Image small;
    @JsonProperty("medium")
    private Image medium;
    @JsonProperty("large")
    private Image large;
    @JsonProperty("full")
    private Image full;
}
