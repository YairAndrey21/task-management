package gm.tareas.service;

import gm.tareas.model.Task;
import gm.tareas.repository.ITaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService implements ITaskService{

    @Autowired
    private ITaskRepository taskRepository;

    @Override
    public List<Task> listTasks() {
        return taskRepository.findAll();
    }

    @Override
    public Task findTaskById(Integer id) {
        return taskRepository.findById(id).orElse(null);
    }

    @Override
    public void saveTask(Task task) {
        taskRepository.save(task);
    }

    @Override
    public void deteleTask(Task task) {
        taskRepository.delete(task);
    }
}
