package com.web2.pos.model.web.request;

import com.web2.pos.validation.UserAndPasswordMustMatch;
import com.web2.pos.validation.UserMustExist;
import com.web2.pos.validation.data.UserData;
import lombok.*;

import javax.validation.constraints.Size;

/**
 * @author Abdul Rozak
 * @since 10/28/20
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@UserAndPasswordMustMatch(message = "Username and password doesn't match the record")
public class LoginForm implements UserData {

    @Size(min=4, max=30, message = "Username length size must be between 4 and 30")
    @UserMustExist(message = "Username not found")
    private String username;

    @Size(min=4, max=30, message = "Password length size must be between 4 and 30")
    private String password;

    private String formError = "";
}
