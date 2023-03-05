package com.gen.todolist.controller;

import com.gen.todolist.model.Taskk;
import com.gen.todolist.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.config.Task;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/tasks")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TaskController {

    @Autowired
    private TaskRepository taskRepository;

    @PostMapping
    public ResponseEntity<Taskk> post (@Valid @RequestBody Taskk taskk) {
        return ResponseEntity.status(HttpStatus.CREATED).body(taskRepository.save(taskk));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Taskk> getById(@PathVariable Long id) {
        return taskRepository.findById(id)
                .map(resp -> ResponseEntity.ok(resp))
                .orElse(ResponseEntity.notFound().build());
    }
}
