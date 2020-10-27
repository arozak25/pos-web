package com.web2.pos.model.web;

import lombok.*;

/**
 * @author Abdul Rozak
 * @since 10/28/20
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class LoginWebRequest {

    private String username;

    private String password;
}
