package com.thoughtworks.training.todoserver.controller;

import com.google.common.net.HttpHeaders;
import com.thoughtworks.training.todoserver.languageCheck.SpellCheckerService;
import com.thoughtworks.training.todoserver.model.Todo;

import com.thoughtworks.training.todoserver.security.TodoFilter;
import com.thoughtworks.training.todoserver.server.TodoServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TodoAPI {

    @Autowired
    TodoServer todolistSerive;

    @Autowired
    TodoFilter todoFilter;


    @GetMapping("/todos")
    public List<Todo> todolist()  {

        Integer id = todoFilter.requestId();

        return todolistSerive.list(id);
    }

    @GetMapping("/todos/{id}")
    public Todo findOne(@PathVariable Integer id) {
        return todolistSerive.findOne(id);
    }

    @PostMapping("/todos")
    public String createOne(@RequestBody Todo todo) {

        Integer id = todoFilter.requestId();

        todolistSerive.create(todo, id);

        return todo.getText();
    }
    @DeleteMapping("/todos/{id}")
    public void delete(@PathVariable Integer id) {
        todolistSerive.delete(id);
    }

}
