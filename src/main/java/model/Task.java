package model;

import java.time.LocalDate;
import static model.TaskStatus.*;
import static model.PayStatus.*;

public class Task {
    private int id;
    private Client client;
    private String description;
    private LocalDate date;
    private double price;
    private TaskStatus status;
    private PayStatus payStatus;

    public Task(Client client, String description, LocalDate date, double price){
        this.client = client;
        this.description = description;
        this.date = date;
        this.price = price;
        status = TODO;
        payStatus = UNPAID;
        client.addTask(this);
    }

    public void setTaskAsDone(){
        status = DONE;
    }

    public void setTaskAsPending(){
        status = PENDING;
    }

    public void setTaskAsToDo(){
        status = TODO;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public TaskStatus isStatus() {
        return status;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    public PayStatus isPayStatus() {
        return payStatus;
    }

    public void setPayStatus(PayStatus payStatus) {
        this.payStatus = payStatus;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public PayStatus getPayStatus() {
        return payStatus;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}


