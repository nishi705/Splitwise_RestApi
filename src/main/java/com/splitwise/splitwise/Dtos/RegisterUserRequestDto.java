package com.splitwise.splitwise.Dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterUserRequestDto {
    private String name;
    private String pname;
    private String password;
}
