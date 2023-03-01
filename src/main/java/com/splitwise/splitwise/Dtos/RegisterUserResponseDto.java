package com.splitwise.splitwise.Dtos;

import com.splitwise.splitwise.Model.User;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class RegisterUserResponseDto {
    private User user;
    private ResponseStatus responseStatus;

}
