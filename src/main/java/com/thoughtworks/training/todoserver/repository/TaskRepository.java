package com.thoughtworks.training.todoserver.repository;


import com.thoughtworks.training.todoserver.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer> {

}
