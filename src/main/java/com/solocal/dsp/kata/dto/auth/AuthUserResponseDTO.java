package com.solocal.dsp.kata.dto.auth;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuthUserResponseDTO implements Serializable {

    private String username;

    private List<String> roles;

    private String jwtToken;

}
