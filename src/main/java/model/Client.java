package model;

import java.util.ArrayList;
import java.util.List;

public class Client {
    private int id;
    private String name;
    private String surname;
    private String company;

    private List<Task> futureTasks;
    private List<Task> completedTasks;

    public Client(String name, String surname, String company){
        this.name = name;
        this.surname = surname;
        this.company = company;
        futureTasks = new ArrayList<>();
        completedTasks = new ArrayList<>();
    }

    public Client(String name, String surname){
        this.name = name;
        this.surname = surname;
        this.company = null;
        futureTasks = new ArrayList<>();
        completedTasks = new ArrayList<>();
    }

    public void addTask(Task task){
        futureTasks.add(task);
    }

    public void markTaskAsCompleted(Task task){
        futureTasks.remove(task);
        completedTasks.add(task);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public List<Task> getFutureTasks() {
        return futureTasks;
    }

    public void setFutureTasks(List<Task> futureTasks) {
        this.futureTasks = futureTasks;
    }

    public List<Task> getCompletedTasks() {
        return completedTasks;
    }

    public void setCompletedTasks(List<Task> completedTasks) {
        this.completedTasks = completedTasks;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return name + " " + surname;
    }
}
