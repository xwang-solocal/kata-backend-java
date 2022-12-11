package com.solocal.dsp.kata.controller;

import com.solocal.dsp.kata.dto.auth.AuthUserResponseDTO;
import com.solocal.dsp.kata.dto.auth.LoginRequestDTO;
import com.solocal.dsp.kata.dto.auth.SignupRequestDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Api(value = "User resource endpoints", description = "All endpoints allow to manipulate the user resource")
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/onelinestore_api/auth")
public class UserController {

    @ApiOperation(value = "Login", response = AuthUserResponseDTO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success|OK"),
            @ApiResponse(code = 401, message = "not authorized!"),
            @ApiResponse(code = 403, message = "forbidden!!!"),
            @ApiResponse(code = 404, message = "not found!!!") })
    @PostMapping(path = "/signin", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<AuthUserResponseDTO> authenticateUser(@Valid @RequestBody LoginRequestDTO loginRequestDTO) {
        return null;
    }

    @ApiOperation(value = "Register a user", response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success|OK"),
            @ApiResponse(code = 401, message = "not authorized!"),
            @ApiResponse(code = 403, message = "forbidden!!!"),
            @ApiResponse(code = 404, message = "not found!!!") })
    @PostMapping(path = "/signup", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> registerUser(@Valid @RequestBody SignupRequestDTO signupRequestDTO) {
        return null;
    }

}
