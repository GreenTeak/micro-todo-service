package com.thoughtworks.training.todoserver.languageCheck;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.thoughtworks.training.todoserver.model.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.TimeoutException;

@Component
public  class SpellCheckerService{
    @Autowired
    SpellChecker spellChecker;

    @HystrixCommand(fallbackMethod = "checkFallback")
    public List<Todo> checkFallback(List<Todo> todos){
        spellChecker.check(todos, Todo::getText,Todo::setSuggestion);
        return todos;
    }

    @Retryable(maxAttempts=3, backoff = @Backoff(10))
    public List<Todo> check(List<Todo> todos){
        spellChecker.check(todos, Todo::getText,Todo::setSuggestion);
        return todos;
    }
    @Recover
    public List<Todo> failure(TimeoutException e, List<Todo> todos){
        return todos;
    }
}