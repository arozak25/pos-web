package com.web2.pos.service.impl;

import com.web2.pos.entity.User;
import com.web2.pos.model.web.request.LoginForm;
import com.web2.pos.model.web.response.LoginWebResponse;
import com.web2.pos.repository.UserRepository;
import com.web2.pos.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Abdul Rozak
 * @since 10/28/20
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public LoginWebResponse login(LoginForm request) {

        User user = userRepository.findByUsername(request.getUsername()).get(0);

        return LoginWebResponse.builder()
                .username(user.getUsername())
                .role(user.getRole())
                .build();
    }
}
