package com.ucheclass.requestdto;

import com.ucheclass.enums.UserPosition;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserReqDto {

    @NotNull(message="First name cannot be empty")
    private String firstName;
    @NotNull(message = "Lastname cannot be empty")
    private String lastName;
    @NotNull(message = "Country cannot be empty")
    private String country;
    @NotNull(message = "School cannot be empty")
    private String school;
    @NotNull(message = "Email cannot be empty")
    private String email;
    @NotNull(message = "password cannot be empty")
    private String password;
    @NotNull(message = "retype-password field cannot be empty")
    private String retypepassword;
    @NotNull(message = "Phone number cannot be empty")
    private String phone;
    @NotNull(message = "User Position cannot be empty")
    private UserPosition userPosition;

}
