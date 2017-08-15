package com.todolistapp.model.entities;

import com.todolistapp.model.Priority;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity(name = "task")
public class TaskEntity {
    @Id
    @GeneratedValue
    private Integer id;

    @NotNull
    @Size(min=5, max=100)
    private String name;

    private Date creationDate;

    @NotNull
    private Priority priority;

    private boolean done;

    public TaskEntity(){
    }

    public TaskEntity(String name, Date creationDate, Priority priority, boolean done) {
        this.name = name;
        this.creationDate = creationDate;
        this.priority = priority;
        this.done = done;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }
}
