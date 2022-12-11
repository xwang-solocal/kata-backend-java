package com.solocal.dsp.kata.dto.business;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class CustomUserDTO implements Serializable  {

    @JsonProperty("id")
    @JsonIgnore
    private Integer id;

    @JsonProperty("username")
    String username;

    @JsonProperty("authorPseudonym")
    String authorPseudonym;

}
