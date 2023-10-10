package com.rebecca.toDoList.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rebecca.toDoList.dto.CategoryDto;
import com.rebecca.toDoList.dto.TaskDto;
import com.rebecca.toDoList.exception.EntityNotFoundException;
import com.rebecca.toDoList.exception.ErrorCodes;
import com.rebecca.toDoList.exception.InvalidEntityException;
import com.rebecca.toDoList.models.Category;
import com.rebecca.toDoList.models.Task;
import com.rebecca.toDoList.repositories.CategoryRepository;
import com.rebecca.toDoList.repositories.TaskRepository;
import com.rebecca.toDoList.services.TaskService;
import com.rebecca.toDoList.validators.TaskValidator;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class TaskServiceImpl implements TaskService{
    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public TaskDto save(TaskDto taskDto) {
        List<String> errors = TaskValidator.validateTask(taskDto);
        if(!errors.isEmpty()) {
            log.error("Task is not valid", taskDto);
            throw new InvalidEntityException("Task is not valid", ErrorCodes.TASK_NOT_VALID, errors);
        }

        return TaskDto.fromEntity(taskRepository.save(TaskDto.toEntity(taskDto)));
    }

    @Override
    public List<TaskDto> findAll() {
        return taskRepository.findAll().stream()
                .map(TaskDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public TaskDto findById(Long id) {
        if (id == null) {
            log.error("User id is null");
            return null;
        }

        final Long categoryId = categoryRepository.findCategoryByTaskId(id);
        Category category = new Category();
        category.setId(categoryId);

        final Optional<Task> task = taskRepository.findById(id);
        task.ifPresent(value -> value.setCategory(category));

        final TaskDto taskDto = TaskDto.fromEntity(task.get());
        CategoryDto categoryDto = CategoryDto.fromEntity(category);
        taskDto.setCategory(categoryDto);

        return Optional.of(taskDto)
                .orElseThrow(() -> new EntityNotFoundException("No Task found with ID = " + id, ErrorCodes.USER_NOT_FOUND));
    }

    @Override
    public List<TaskDto> findByCategory(Long categoryId) {
        return taskRepository.findTaskByCategoryId(categoryId).stream()
                .map(TaskDto::fromEntity)
                .collect(Collectors.toList());
    }

    // @Override
    // public List<TaskDto> findAllCompletedTasks() {
    //     return taskRepository.findByCompletedTrue().stream()
    //             .map(TaskDto::fromEntity)
    //             .collect(Collectors.toList());
    // }

    // @Override
    // public List<TaskDto> findAllIncompletedTasks() {
    //     return taskRepository.findByCompletedFalse().stream()
    //             .map(TaskDto::fromEntity)
    //             .collect(Collectors.toList());
    // }

    @Override
    public void delete(Long id) {
        if (id == null) {
            log.error("Task id is null");
            return;
        }
        taskRepository.deleteById(id);
    }
}
