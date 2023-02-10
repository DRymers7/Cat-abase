package com.catabase.mockdataserver.model.objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Breed {
    @JsonProperty("primary")
    private String primary;
    @JsonProperty("secondary")
    private String secondary;
    @JsonProperty("mixed")
    private boolean mixed;
    @JsonProperty("unknown")
    private boolean unknown;
}
