package com.catabase.mockdataserver.model.responses;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DogApiResponse {

    @JsonProperty("message")
    private String message;
    @JsonProperty("status")
    private String status;

}
