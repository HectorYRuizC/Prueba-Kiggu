package com.example.Mini_Proyecto.repository;

import com.example.Mini_Proyecto.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task,Long> {
    
}
