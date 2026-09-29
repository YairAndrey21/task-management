package gm.tareas.service;

import gm.tareas.model.Task;

import java.util.List;

public interface ITaskService {

    public List<Task> listTasks();

    public Task findTaskById(Integer id);

    public void saveTask(Task task);

    public void deteleTask(Task task);
}
