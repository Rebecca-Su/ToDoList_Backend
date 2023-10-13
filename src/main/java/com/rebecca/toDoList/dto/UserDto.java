package com.rebecca.toDoList.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.rebecca.toDoList.models.Category;
import com.rebecca.toDoList.models.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {
    private long id;
    private String firstName;
    private String lastName;
    private String email;
    private String userName;
    private String password;
    @JsonIgnore
    private List<CategoryDto> categories;

    public static User toEntity(UserDto userDto) {
        final User user = new User();

        user.setId(userDto.getId());
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setUserName(userDto.getUserName());
        user.setCategories(
            userDto.getCategories() != null ? userDto.getCategories().stream().map(CategoryDto::toEntity).collect(Collectors.toList()) : null
        );

        return user;
    }

    public static UserDto fromEntity(User user) {
        return UserDto.builder()
        .id(user.getId())
        .firstName(user.getFirstName())
        .lastName(user.getLastName())
        .email(user.getEmail())
        .userName(user.getUserName())
        .password(user.getPassword())
        .categories(
            user.getCategories() != null ? user.getCategories().stream().map(CategoryDto::fromEntity).collect(Collectors.toList()): null
        )
        .build();
    }
}
