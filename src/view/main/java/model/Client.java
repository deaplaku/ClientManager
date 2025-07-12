package model;

import java.util.List;

public class Client {
    private String name;
    private String surname;
    private boolean isCompany;
    private List<Task> futureTasks;
    private List<Task> completedTasks;
    private int nrOfTasks = 0;

    public Client(String name, String surname, boolean isCompany){
        this.name = name;
        this.surname = surname;
        this.isCompany = isCompany;
    }

    public void addTask(Task task){
        futureTasks.add(task);
        nrOfTasks++;
    }

    public void deleteTask(Task task){
        futureTasks.remove(task);
        completedTasks.add(task);
        nrOfTasks--;
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

    public boolean isCompany() {
        return isCompany;
    }

    public void setCompany(boolean company) {
        isCompany = company;
    }

    public int getNrOfTasks() {
        return nrOfTasks;
    }

    public void setNrOfTasks(int nrOfTasks) {
        this.nrOfTasks = nrOfTasks;
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

}
