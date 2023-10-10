package com.rebecca.toDoList.services;

import com.rebecca.toDoList.dto.TaskDto;
import java.util.List;

public interface TaskService {
    TaskDto save(TaskDto taskDto);
    List<TaskDto> findAll();
    TaskDto findById(Long id);
    List<TaskDto> findByCategory(Long categoryId);
    // List<TaskDto> findAllCompletedTasks();
    // List<TaskDto> findAllIncompletedTasks();
    void delete(Long id);
}
