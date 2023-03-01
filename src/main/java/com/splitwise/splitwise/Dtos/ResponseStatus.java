package com.splitwise.splitwise.Dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseStatus {
    private StatusCode code;
    private String message;
}
