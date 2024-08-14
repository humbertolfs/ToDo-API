package me.learning.service;

import me.learning.domain.model.Task;

import java.util.List;

public interface TaskService {
    List<Task> findAll();

    Task findById(Long id);

    Task create(Task taskToCreate);

    Task modify(Task taskToModify);

    void deleteById(Long id);
}
