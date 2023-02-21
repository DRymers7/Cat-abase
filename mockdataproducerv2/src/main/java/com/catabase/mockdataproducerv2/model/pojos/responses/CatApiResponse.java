package com.catabase.mockdataproducerv2.model.pojos.responses;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CatApiResponse {

    @JsonProperty("image_link")
    private String imageLink;
    @JsonProperty("name")
    private String name;

}
