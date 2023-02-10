package com.catabase.mockdataserver.model.objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Attributes {
    @JsonProperty("spayed_neutered")
    private boolean spayedNeutered;
    @JsonProperty("house_trained")
    private boolean houseTrained;
    @JsonProperty("declawed")
    private boolean declawed;
    @JsonProperty("special_needs")
    private boolean specialNeeds;
    @JsonProperty("shots_current")
    private boolean shotsCurrent;
}
