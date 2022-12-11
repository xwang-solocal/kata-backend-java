package com.solocal.dsp.kata.model;

import lombok.*;

@Data
@Builder
public class ErrorResponse {
    private int errorCode;
    private String servicePath;
    private String errorMessage;
    private String timestamp;
}
