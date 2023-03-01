package com.splitwise.splitwise.Controller;

import com.splitwise.splitwise.Dtos.*;
import com.splitwise.splitwise.Dtos.ResponseStatus;
import com.splitwise.splitwise.Model.User;
import com.splitwise.splitwise.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@RestController
public class RegisterUserController {

    private UserService userService;

    @Autowired
    public RegisterUserController(UserService userService){
        this.userService=userService;
    }


    @PostMapping("/user/register/")
    public RegisterUserResponseDto responseDto(@RequestBody() RegisterUserRequestDto registerUserRequestDto){
            RegisterUserResponseDto responseDto = new RegisterUserResponseDto();

        User user = new User();
        user.setName(registerUserRequestDto.getName());
        user.setPassword(registerUserRequestDto.getPassword());
        user.setPname(registerUserRequestDto.getPname());
       // user.setId(10L);

        try {
            User saverUser = userService.getRegister(user);
                  responseDto.setUser(saverUser);

            ResponseStatus responseStatus = new ResponseStatus();
            responseStatus.setCode(StatusCode.SUCCESS);
            responseStatus.setMessage("user registered into the server");
            responseDto.setResponseStatus(responseStatus);

        }catch (Exception e){
            ResponseStatus responseStatus = new ResponseStatus();

            responseStatus.setCode(StatusCode.FAILURE);
            responseStatus.setMessage("user not registered");
            responseDto.setResponseStatus(responseStatus);

        }
          return responseDto;
    }

    @GetMapping("/user/get/")
    public GetUserResponseDto getUser(@RequestParam() Long userId) throws Exception {
        GetUserResponseDto responseDto = new GetUserResponseDto();

        try {
            User user = userService.getUser(userId);
            responseDto.setUser(user);
            ResponseStatus responseStatus = new ResponseStatus();
            responseStatus.setCode(StatusCode.SUCCESS);
            responseStatus.setMessage("user retrieved successfully");
            responseDto.setResponseStatus(responseStatus);
        }catch(Exception e){
          ResponseStatus responseStatus = new ResponseStatus();
          responseStatus.setCode(StatusCode.FAILURE);
          responseStatus.setMessage("user cannot retrieved");
          responseDto.setResponseStatus(responseStatus);

        }
        return responseDto;



    }
}
