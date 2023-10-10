package com.rebecca.toDoList.services;

import java.util.List;

import com.rebecca.toDoList.dto.UserDto;

public interface UserService {
    UserDto save(UserDto user);
    List<UserDto> findAll();
    UserDto findById(Long id);
    void delete(Long id);
    UserDto login(UserDto user);
}
