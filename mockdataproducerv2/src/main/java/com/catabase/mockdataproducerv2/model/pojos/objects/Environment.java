package com.catabase.mockdataproducerv2.model.pojos.objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Environment {
    @JsonProperty("children")
    private boolean children;
    @JsonProperty("dogs")
    private boolean dogs;
    @JsonProperty("cats")
    private boolean cats;
}
