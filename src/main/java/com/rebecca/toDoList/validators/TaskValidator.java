package com.rebecca.toDoList.validators;

import java.util.ArrayList;
import java.util.List;

import com.rebecca.toDoList.dto.TaskDto;

import io.micrometer.common.util.StringUtils;

public class TaskValidator {
    public static List<String> validateTask(TaskDto task) {
        List<String> errors = new ArrayList<>();
        if(task == null) {
            errors.add("Please set the title");
            // errors.add("Please set the description");
            errors.add("Pleast select a category");
            return errors;
        }

        if (StringUtils.isEmpty(task.getTitle())) {
            errors.add("Please set the title");
        }

        // if (StringUtils.isEmpty(task.getDescription())) {
        //     errors.add("Please set the description");
        // }

        if (task.getCategory() == null || task.getCategory().getId() == null) {
            errors.add("Please select a category");
        }

        return errors;
    }
}
