package com.rebecca.toDoList.services;

import java.util.List;

import com.rebecca.toDoList.dto.CategoryDto;

public interface CategoryService {
    CategoryDto save(CategoryDto categoryDto);
    List<CategoryDto> findAll();
    CategoryDto findById(Long id);
    List<CategoryDto> findAllByUserId(Long userId);
    void delete(Long id);
    List<CategoryDto> getAllTaskByCategoryToday(Long userId);
}
