package com.web2.pos.validation;

import com.web2.pos.validation.validator.UserAndPasswordMustMatchValidator;
import com.web2.pos.validation.validator.UserMustExistValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.ElementType.TYPE_USE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @since 10/29/20
 * @author Abdul Rozak
*/
@Documented
@Constraint(validatedBy = {UserAndPasswordMustMatchValidator.class})
@Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE})
@Retention(RUNTIME)
public @interface UserAndPasswordMustMatch {

   String message();

   Class<?>[] groups() default {};

   Class<? extends Payload>[] payload() default {};

}
