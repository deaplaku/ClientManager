package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TaskManager {
    private List<Task> tasks = new ArrayList<>();

    public void addTask(Task task){
        tasks.add(task);
    }

    public void removeTask(Task task){
        tasks.remove(task);
    }

    public List<Task> filterByDate(Date date)
    {
        List<Task> filteredTasks = new ArrayList<>();
        for(Task task : tasks){
            if(task.getDate() == date)
                filteredTasks.add(task);
        }
        return filteredTasks;
    }

    public List<Task> filterByStatus(TaskStatus status) {
        List<Task> filteredTasks = new ArrayList<>();
        for(Task task : tasks){
            if(task.getStatus() == status)
                filteredTasks.add(task);
        }
        return filteredTasks;
    }

    public List<Task> filterByClient(Client client) {
        List<Task> filteredTasks = new ArrayList<>();
        for(Task task : tasks){
            if(task.getClient() == client)
                filteredTasks.add(task);
        }
        return filteredTasks;
    }
    public List<Task> searchByKeyword(String keyword) {
        List<Task> filteredTasks = new ArrayList<>();
        for(Task task : tasks){
            if(task.getDescription().contains(keyword))
                filteredTasks.add(task);
        }
        return filteredTasks;
    }

    public List<Task> getAllTasks() { return tasks; }
}
