package com.gen.todolist.repository;

import com.gen.todolist.model.Taskk;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Taskk, Long> {
}
