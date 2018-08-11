package com.thoughtworks.training.todoserver.controller;


import com.thoughtworks.training.todoserver.model.Task;
import com.thoughtworks.training.todoserver.server.TaskServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TaskAPI {
    @Autowired
    TaskServer taskServer;

    @GetMapping("/task")
    public List<Task> taskslist() {
        return taskServer.find();
    }

    @GetMapping("/task/{id}")
    public Task findOne(@PathVariable Integer id) {
        return taskServer.findOne(id);
    }

    @PostMapping("/task")
    public void createOne(@RequestBody Task task) {
        taskServer.create(task);
    }

    @RequestMapping(value = "/task/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Integer id) {
        taskServer.deleteById(id);
    }


}
