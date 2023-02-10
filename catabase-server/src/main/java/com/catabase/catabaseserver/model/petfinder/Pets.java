package com.catabase.catabaseserver.model.petfinder;

import com.catabase.catabaseserver.model.petfinder.objects.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pets {
    @JsonProperty("url")
    private String url;
    @JsonProperty("breeds")
    private Breed breeds;
    @JsonProperty("age")
    private String age;
    @JsonProperty("gender")
    private String gender;
    @JsonProperty("size")
    private String size;
    @JsonProperty("coat")
    private String coat;
    @JsonProperty("attributes")
    private Attributes attributes;
    @JsonProperty("environment")
    private Environment environment;
    @JsonProperty("tags")
    private String[] tags;
    @JsonProperty("name")
    private String name;
    @JsonProperty("description")
    private String description;
    @JsonProperty("photos")
    private Photos[] photos;
    @JsonProperty("primary_photo_cropped")
    private Photos primaryPhotoCropped;
    @JsonProperty("status")
    private String status;
    @JsonProperty("contact")
    private Contact contact;

}
