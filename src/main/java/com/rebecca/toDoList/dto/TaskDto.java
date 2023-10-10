package com.rebecca.toDoList.dto;

import java.time.ZonedDateTime;

import com.rebecca.toDoList.models.Task;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TaskDto {
    private Long id;
    private String title;
    private String description;
    private ZonedDateTime startTime;
    private boolean done;
    private boolean important;
    private CategoryDto category;

    public static Task toEntity(TaskDto taskDto) {
        Task task = new Task();

        task.setId(taskDto.getId());
        task.setTitle(taskDto.getTitle());
        task.setDescription(taskDto.getDescription());
        task.setStartTime(taskDto.getStartTime());
        task.setDone(taskDto.isDone());
        task.setImportant(taskDto.isImportant());
        task.setCategory(CategoryDto.toEntity(taskDto.getCategory()));

        return task;
    }

    public static TaskDto fromEntity(Task task) {
        return TaskDto.builder()
        .id(task.getId())
        .title(task.getTitle())
        .description(task.getDescription())
        .startTime(task.getStartTime())
        .done(task.isDone())
        .important(task.isImportant())
        .category(CategoryDto.fromEntity(task.getCategory()))
        .build();
    }
}
