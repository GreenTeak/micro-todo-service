package com.thoughtworks.training.todoserver.server;


import com.thoughtworks.training.todoserver.languageCheck.SpellCheckerService;
import com.thoughtworks.training.todoserver.model.Todo;
import com.thoughtworks.training.todoserver.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoServer {

    @Autowired
    private TodoRepository todoRepository;

    @Autowired
    private SpellCheckerService spellCheckerService;


    public List<Todo> find() {
        return todoRepository.findAll();
    }

    public Todo findOne(Integer id) {
        return todoRepository.findOne(id);
    }

    public void create(Todo todo, Integer id) {

        Todo todo1 = new Todo();

        todo1.setUserid(id);
        todo1.setId(todo.getId());
        todo1.setText(todo.getText());
        todo1.setCompleted(todo.isCompleted());
        todo1.setEdit(todo.isEdit());

        todoRepository.save(todo1);

    }

    public void delete(Integer id) {
        todoRepository.delete(id);
    }


    public List<Todo> list(Integer id)  {

        List<Todo> todos= todoRepository.findAllByUseridEquals(id);

       // spellCheckerService.check(todos);
        //spellChecker.check(todos, Todo::getText,Todo::setSuggestion);
        //spellCheckerService.check(todos);
        //spellCheckerService.checkFallback(todos);
        return todos;
    }
    public boolean vertify(String name, String password) {

//      return encoder.matches(password, user.password);
        return true;

    }

}
