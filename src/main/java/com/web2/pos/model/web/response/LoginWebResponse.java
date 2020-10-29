package com.web2.pos.model.web.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @author Abdul Rozak
 * @since 10/28/20
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class LoginWebResponse {

    private String username;

    private Integer role;
}
