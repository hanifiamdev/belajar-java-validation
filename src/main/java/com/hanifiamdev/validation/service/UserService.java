package com.hanifiamdev.validation.service;

import com.hanifiamdev.validation.constraint.CheckPasswordParameter;
import jakarta.validation.constraints.NotBlank;

public class UserService {

    @CheckPasswordParameter(
            passwordParam = 1, // karena urutan parameter ke 1, sedangkan 0 adalah username dan 2 adalah retypePassword
            retypePasswordParam = 2
    )

    public void register(@NotBlank(message = "username must not blank") String username,
                         @NotBlank(message = "password must not blank") String password,
                         @NotBlank(message = "retype password must not blank") String retypePassword) {



    }

}
