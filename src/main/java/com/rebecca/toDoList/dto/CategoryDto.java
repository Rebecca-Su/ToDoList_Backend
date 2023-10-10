package com.rebecca.toDoList.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.rebecca.toDoList.models.Category;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CategoryDto {
    private Long id;
    private String name;
    private String description;
    private UserDto user;
    private List<TaskDto> tasks;

    public static Category toEntity(CategoryDto categoryDto) {
        Category category = new Category();

        category.setId(categoryDto.getId());
        category.setName(categoryDto.getName());
        category.setDescription(categoryDto.getDescription());
        category.setUser(UserDto.toEntity(categoryDto.getUser()));
        category.setTasks(
            categoryDto.getTasks() != null ? categoryDto.getTasks().stream().map(TaskDto::toEntity).collect(Collectors.toList()) : null
        );
        return category;
    }

    public static CategoryDto fromEntity(Category category) {
        return CategoryDto.builder()
        .id(category.getId())
        .name(category.getName())
        .description(category.getDescription())
        .user(UserDto.fromEntity(category.getUser()))
        .tasks(
            category.getTasks() != null ? category.getTasks().stream().map(TaskDto::fromEntity).collect(Collectors.toList()) : null
        )
        .build();
    }
}
