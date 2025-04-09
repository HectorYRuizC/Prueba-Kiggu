package com.example.Mini_Proyecto.controller;

import com.example.Mini_Proyecto.dto.SaveRequest;
import com.example.Mini_Proyecto.dto.UpdateRequest;
import com.example.Mini_Proyecto.model.Task;
import com.example.Mini_Proyecto.service.TaskService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
@CrossOrigin(origins = "*")
public class TaskController {

    private TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public List<Task> getATasks(){
        return taskService.findAll();
    }

    @PostMapping
    public Task saveTask(@RequestBody SaveRequest saveRequest){
        return taskService.save(saveRequest);
    }

    @PutMapping("/{id}")
    public Task updateTask(@PathVariable Long id,@RequestBody UpdateRequest updateRequest){
        return taskService.update(id,updateRequest);
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id) {
        taskService.delete(id);
    }


}
