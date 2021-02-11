package com.example.mobiLelele.mobiLelele.model.validations;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy = YearOnPastOrPresentValidator.class)
public @interface YearOnPastOrPresent {

    String message() default "Invalid Date";

    Class<?>[] groups() default {};

    int minYear();


    Class<? extends Payload>[] payload() default {};
}

