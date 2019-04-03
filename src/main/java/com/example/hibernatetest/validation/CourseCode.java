package com.example.hibernatetest.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = CourseCodeContraintValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CourseCode {

    // definire codice corso di default
    public String value() default "LUV";

    // definire messaggio d'errore di default
    public String message() default "must start with LUV";

    // definire gruppo di default
    public Class<?>[] groups() default {};

    // definire payload di default
    public Class <? extends Payload>[] payload() default{};
}
