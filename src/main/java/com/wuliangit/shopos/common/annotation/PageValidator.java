package com.wuliangit.shopos.common.annotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PageValidator implements ConstraintValidator<Page, Integer> {

    private static final Integer DEFAULT_PAGE = 1;

    public void initialize(Page page) {

    }

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext constraintValidatorContext) {
        if (value != null && value > 0) {
            return true;
        } else {
            return false;
        }

    }

}