package com.solocal.dsp.kata.dto.auth;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LoginRequestDTO implements Serializable {

    @NotBlank
    private String username;

    @NotBlank
    private String password;
}
