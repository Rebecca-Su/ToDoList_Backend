package com.rebecca.toDoList.validators;

import java.util.ArrayList;
import java.util.List;

import com.rebecca.toDoList.dto.UserDto;

import io.micrometer.common.util.StringUtils;

public class UserValidator {
    public static List<String> validateUser(UserDto user) {
        List<String> errors = new ArrayList<String>();

        if(user == null) {
            errors.add("Please set the First name");
            errors.add("Please set the Last name");
            errors.add("Please set the User name");
            errors.add("Please set the User email");
            errors.add("Please set the User password");
            return errors;
        }

        if (StringUtils.isEmpty(user.getFirstName())) {
            errors.add("Please set the First name");
        }

        if (StringUtils.isEmpty(user.getLastName())) {
            errors.add("Please set the Last name");
        }

        if (StringUtils.isEmpty(user.getUserName())) {
            errors.add("Please set the User name");
        }

        if (StringUtils.isEmpty(user.getEmail())) {
            errors.add("Please set the User email");
        }

        if (StringUtils.isEmpty(user.getPassword())) {
            errors.add("Please set the User password");
        }

        return errors;
    }

    public static List<String> validateUserCredentials(String email, String password) {
        List<String> errors = new ArrayList<String>();

        if(StringUtils.isEmpty(email)) {
            errors.add("Email is empty");
        }

        if(StringUtils.isEmpty(password)) {
            errors.add("Password is empty");
        }

        return errors;
    }
}
