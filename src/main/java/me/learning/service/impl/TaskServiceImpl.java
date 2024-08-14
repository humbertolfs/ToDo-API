package me.learning.service.impl;

import me.learning.domain.model.Task;
import me.learning.domain.repository.TaskRepository;
import me.learning.service.TaskService;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class TaskServiceImpl implements TaskService {
    private final TaskRepository taskRepository;

    public TaskServiceImpl(TaskRepository taskRepository){
        this.taskRepository = taskRepository;
    }

    @Override
    public List<Task> findAll(){
        return taskRepository.findAll();
    }

    @Override
    public Task findById(Long id) {
        return taskRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public Task create(@NotNull Task taskToCreate) {
        if (taskToCreate.getId() != null && taskRepository.existsById(taskToCreate.getId())){
            throw new IllegalArgumentException("This ID already exists.");
        }
        return taskRepository.save(taskToCreate);
    }

    @Override
    public Task modify(@NotNull Task taskToModify) {
        if(!taskRepository.existsById(taskToModify.getId())){
            throw new NoSuchElementException("This task doesn't exists");
        }
        return taskRepository.save(taskToModify);
    }

    @Override
    public void deleteById(Long id) {
        if(!taskRepository.existsById(id)){
            throw new NoSuchElementException("This task doesn't exists");
        }
        taskRepository.deleteById(id);
    }
}
