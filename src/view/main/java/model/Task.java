package model;

import java.util.Date;

import static model.TaskStatus.*;
import static model.PayStatus.*;

public class Task {
    private Client client;
    private String description;
    private Date date;
    private double price;
    private TaskStatus status;
    private PayStatus payStatus;

    public Task(Client client, String description, Date date, double price){
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
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
}


