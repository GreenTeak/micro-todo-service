
package com.thoughtworks.training.todoserver.controller;

import com.thoughtworks.training.todoserver.server.TodoServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;

@Controller
public class TodoController {

    @Autowired
    TodoServer todolistSerive;

//    @GetMapping(path = "/todolist")
//    public String ToDo(Model model) {
//        model.addAttribute("todos", todolistSerive.find());
//        return "Hello";
//    }
}
