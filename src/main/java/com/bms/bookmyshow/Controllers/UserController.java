package com.bms.bookmyshow.Controllers;

import com.bms.bookmyshow.Dtos.*;
import com.bms.bookmyshow.Exceptions.UserNotFoundException;
import com.bms.bookmyshow.Models.User;
import com.bms.bookmyshow.Services.UserService;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {
    private UserService userService;

    public UserController(UserService userService)
    {
        this.userService = userService;
    }

    public SignupResponseDto signup(SignupRequestDto signupRequestDto)
    {
        SignupResponseDto signupResponseDto = new SignupResponseDto();

        User user =userService.signup(signupRequestDto.getName(),
                                        signupRequestDto.getEmail(),
                                            signupRequestDto.getPassword());

        signupResponseDto.setResponseStatus(ResponseStatus.SUCCESS);
        signupResponseDto.setUserId(user.getId());

        return signupResponseDto;
    }

    public LoginResponseDto login(LoginRequestDto loginRequestDto)
    {
        LoginResponseDto responseDto=new LoginResponseDto();
        try {
            User user=userService.login(loginRequestDto.getUsername(),
                    loginRequestDto.getPassword());

            responseDto.setResponseStatus(ResponseStatus.SUCCESS);
        }
        catch (Exception e)
        {
            responseDto.setResponseStatus(ResponseStatus.FAILURE);
        }

        return responseDto;
    }
}
