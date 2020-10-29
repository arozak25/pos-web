package com.web2.pos.service;

import com.web2.pos.model.web.request.LoginForm;
import com.web2.pos.model.web.response.LoginWebResponse;

/**
 * @author Abdul Rozak
 * @since 10/28/20
 */
public interface UserService {

    LoginWebResponse login(LoginForm request);

}
