package com.web2.pos.validation.validator;

import com.web2.pos.repository.UserRepository;
import com.web2.pos.validation.UserMustExist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @since 10/29/20
 * @author Abdul Rozak
*/
public class UserMustExistValidator implements ConstraintValidator<UserMustExist, String> {

   @Autowired
   private UserRepository userRepository;

   @Override
   public boolean isValid(String value, ConstraintValidatorContext context) {
      if (StringUtils.isEmpty(value)) {
         return true;
      } else {
         return userRepository.existsByUsername(value);
      }
   }
}
