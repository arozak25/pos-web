package com.web2.pos.validation.data;

import javax.validation.constraints.Size;

/**
 * @author Abdul Rozak
 * @since 10/29/20
 */
public interface UserData {

    String getUsername();

    String getPassword();

    String getFormError();

}
