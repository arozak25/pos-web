package com.web2.pos.validation.validator;

import com.web2.pos.repository.UserRepository;
import com.web2.pos.validation.UserAndPasswordMustMatch;
import com.web2.pos.validation.UserMustExist;
import com.web2.pos.validation.data.UserData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author Abdul Rozak
 * @since 10/29/20
 */
public class UserAndPasswordMustMatchValidator implements ConstraintValidator<UserAndPasswordMustMatch, UserData> {

    @Autowired
    private UserRepository userRepository;

    @Override
    public boolean isValid(UserData value, ConstraintValidatorContext context) {
        if (StringUtils.isEmpty(value.getUsername()) || StringUtils.isEmpty(value.getPassword())) {
            return true;
        } else {
            boolean isValid = userRepository.findByUsername(value.getUsername()).get(0).getPassword().equals(value.getPassword());

            if (!isValid){
                context.disableDefaultConstraintViolation();
                context.buildConstraintViolationWithTemplate(context.getDefaultConstraintMessageTemplate()).addPropertyNode("formError").addConstraintViolation();
            }

            return isValid;

        }
    }
}
