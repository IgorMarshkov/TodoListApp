package com.todolistapp.controllers;

import com.todolistapp.model.Priority;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/priority")
public class PriorityController {

    @RequestMapping(method = RequestMethod.GET)
    public List<Priority> getPriorityList(){
        return new ArrayList<>(Arrays.asList(Priority.values()));
    }
}
