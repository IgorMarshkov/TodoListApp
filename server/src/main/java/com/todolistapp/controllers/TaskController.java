package com.todolistapp.controllers;

import com.todolistapp.model.entities.TaskEntity;
import com.todolistapp.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/task")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @RequestMapping(method = RequestMethod.GET)
    public List<TaskEntity> getTaskList(){
        return taskService.getTaskList();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public TaskEntity getTaskById(@PathVariable("id") Integer id){
        return taskService.getById(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public void saveTask(@RequestBody @Valid TaskEntity task){
        taskService.save(task);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public void deleteTask(@PathVariable("id") Integer id){
        taskService.delete(id);
    }
}
