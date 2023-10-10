package com.rebecca.toDoList.repositories;

import java.time.ZonedDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.rebecca.toDoList.models.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    List<Category> findCategoryByUserId(Long userId);

    @Query("select t.category.id from Task t where t.id = :taskId")
    Long findCategoryByTaskId(Long taskId);

    @Query("select c from Category c inner join Task t on t.category.id = c.id where t.startTime >= :startTime and t.startTime <= :endTime and c.user.id = :userId")
    List<Category> getAllTaskByCategoryToday(@Param("startTime") ZonedDateTime startTime, @Param("endTime") ZonedDateTime endTime, @Param("userId")Long userId);
}
