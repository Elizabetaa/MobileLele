package com.example.mobiLelele.mobiLelele.model.validations;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.YearMonth;

public class YearOnPastOrPresentValidator
implements ConstraintValidator<YearOnPastOrPresent, Integer> {

    private int minYear;

    @Override
    public void initialize(YearOnPastOrPresent constraintAnnotation) {
        this.minYear=constraintAnnotation.minYear();
    }

    @Override
    public boolean isValid(Integer year, ConstraintValidatorContext constraintValidatorContext) {
       int nowYear = YearMonth.now().getYear();

        return year >= minYear && year <= nowYear;
    }
}
