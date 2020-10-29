package com.web2.pos.validation;

import com.web2.pos.validation.validator.UserMustExistValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @author Abdul Rozak
 * @since 10/29/20
 */
@Documented
@Constraint(validatedBy = {UserMustExistValidator.class})
@Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE})
@Retention(RUNTIME)
public @interface UserMustExist {

    String message();

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
