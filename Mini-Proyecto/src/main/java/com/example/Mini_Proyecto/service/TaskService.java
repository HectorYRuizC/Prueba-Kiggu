package com.example.Mini_Proyecto.service;

import com.example.Mini_Proyecto.dto.SaveRequest;
import com.example.Mini_Proyecto.dto.UpdateRequest;
import com.example.Mini_Proyecto.model.Task;
import com.example.Mini_Proyecto.repository.TaskRepository;
import com.sun.source.util.TaskListener;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> findAll(){
        return taskRepository.findAll();
    }
    public Task save(SaveRequest saveRequest){
        Task task = new Task();
        task.setTitle(saveRequest.getTitle());
        task.setDescription(saveRequest.getDescription());
        task.setStatus(saveRequest.getStatus());
        return taskRepository.save(task);
    }

    public Task update(Long id, UpdateRequest updateRequest) {
        return taskRepository.findById(id).map(task -> {
            task.setTitle(updateRequest.getTitle());
            task.setDescription(updateRequest.getDescription());
            task.setStatus(updateRequest.getStatus());
            return taskRepository.save(task);
        }).orElseThrow(() -> new RuntimeException("Tarea no encontrada"));
    }

    public void delete(Long id) {
        taskRepository.deleteById(id);
    }
}
