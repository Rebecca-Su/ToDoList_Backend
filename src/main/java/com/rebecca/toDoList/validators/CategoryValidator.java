package com.rebecca.toDoList.validators;

import java.util.ArrayList;
import java.util.List;

import com.rebecca.toDoList.dto.CategoryDto;

import io.micrometer.common.util.StringUtils;

public class CategoryValidator {
    public static List<String> validateCategory(CategoryDto categoryDto) {
        List<String> errors = new ArrayList<>();

        if(categoryDto == null) {
            errors.add("Please set the name");
            errors.add("Please set the description");
            return errors;
        }

        if(StringUtils.isEmpty(categoryDto.getName())) {
            errors.add("Please set the name");
        }

        if(StringUtils.isEmpty(categoryDto.getDescription())) {
            errors.add("Please set the description");
        }

        return errors;
    }
}
