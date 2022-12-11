package com.solocal.dsp.kata.dto.business;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO implements Serializable {

    @JsonProperty("id")
    private Integer id;

    @JsonProperty("Title")
    private String title;

    @JsonProperty("Description")
    private String description;

    @JsonProperty("Custom User")
    private CustomUserDTO customUser;

    @JsonProperty("Product Image path")
    private String productImagePath;

    @JsonProperty("Price")
    private Double price;

}
