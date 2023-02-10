package com.catabase.catabaseserver.model.petfinder.objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Photos {
    @JsonProperty("small")
    private String small;
    @JsonProperty("medium")
    private String medium;
    @JsonProperty("large")
    private String large;
    @JsonProperty("full")
    private String full;
}
