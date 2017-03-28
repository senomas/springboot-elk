package com.senomas.bootapp.rest.endpoint;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.senomas.bootapp.rest.domain.Person;

public class PersonValidator implements Validator { 

    @Override
    public boolean supports(Class<?> clazz) {
        return Person.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "middleName", "validation.message.field.required");
    }

}