package com.todolistapp.services;

import com.todolistapp.model.entities.TaskEntity;
import com.todolistapp.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public TaskEntity getById(int id) {
        return taskRepository.findOne(id);
    }

    public List<TaskEntity> getTaskList() {
        return taskRepository.findAll();
    }

    public void save(TaskEntity task) {
        if (task.getId() == null) {
            task.setCreationDate(new Date());
        }
        taskRepository.save(task);
    }

    public void delete(int id) {
        taskRepository.delete(id);
    }
}
