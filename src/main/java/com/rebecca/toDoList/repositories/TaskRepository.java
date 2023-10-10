package com.rebecca.toDoList.repositories;

import com.rebecca.toDoList.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    // public List<Task> findByCompletedTrue();
    // public List<Task> findByCompletedFalse();
    public List<Task> findAll();
    public Task getById(Long id);
    public List<Task> findTaskByCategoryId(Long categoryId);
}