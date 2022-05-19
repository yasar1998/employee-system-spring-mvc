package com.my.employeesystemmvc.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;



public class NameConstraintValidator implements ConstraintValidator<ValidName, String> {

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if(s.isEmpty() || s.length() == 1)
            return false;

        for(int i = 0; i < s.length(); i++){
            if(!Character.isAlphabetic(s.charAt(i))){
                return false;
            }
            if(i!=0 && Character.isUpperCase(s.charAt(i))){
                return false;
            }
        }

        return !s.contains(" ") && Character.isUpperCase(s.charAt(0));
    }
}
