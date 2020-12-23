package com.sami.supershop.dto;

import com.sami.supershop.domain.UserInformation;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {
    private String username;
    private String password;
    private UserInformation userInformation;
}
