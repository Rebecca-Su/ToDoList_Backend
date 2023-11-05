package com.rebecca.toDoList.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rebecca.toDoList.dto.TaskDto;
import com.rebecca.toDoList.services.TaskService;

@Controller
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/v1/tasks")
public class TaskController {
    @Autowired
    private TaskService taskService;

    @GetMapping("/")
    public ResponseEntity<List<TaskDto>> getAllTasks() {
        return new ResponseEntity<>(taskService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskDto> getTask(@PathVariable Long id) {
        return new ResponseEntity<>(taskService.findById(id), HttpStatus.OK);
    }

    @GetMapping("/user={id}")
    public ResponseEntity<TaskDto> getTaskByUserId(@PathVariable Long id) {
        return new ResponseEntity<>(taskService.findById(id), HttpStatus.OK);
    }

    @GetMapping("/category={id}")
    public ResponseEntity<List<TaskDto>> getAllTaskByCategoriesId(@PathVariable Long id) {
        return new ResponseEntity<>(taskService.findByCategory(id), HttpStatus.OK);
    }

    // @GetMapping("/completed") 
    // public ResponseEntity<List<TaskDto>> getAllCompletedTasks() {
    //     return new ResponseEntity<>(taskService.findAllCompletedTasks(), HttpStatus.OK);
    // }

    // @GetMapping("/incomplete")
    // public ResponseEntity<List<TaskDto>> getallIncompletedTasks() {
    //     return new ResponseEntity<>(taskService.findAllIncompletedTasks(), HttpStatus.OK);
    // }

    @PostMapping("/")
    public ResponseEntity<TaskDto> createTask(@RequestBody TaskDto task) {
        return new ResponseEntity<>(taskService.save(task), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TaskDto> updateTask(@PathVariable Long id, @RequestBody TaskDto task) {
        return new ResponseEntity<>(taskService.save(task), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteTasks(@PathVariable Long id) {
        taskService.delete(id);
        return ResponseEntity.ok(true);
    }
}
