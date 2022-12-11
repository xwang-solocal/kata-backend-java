package com.solocal.dsp.kata.dto.auth;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SignupRequestDTO implements Serializable {

    @NotBlank
    private String username;

    @NotBlank
    private String password;

    @NotBlank
    private String authorPseudonym;

    private Set<String> role;
}
