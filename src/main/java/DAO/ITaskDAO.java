package DAO;

import model.Task;

import java.sql.SQLException;
import java.util.List;

public interface ITaskDAO {
    void addTask(Task task) throws SQLException;
    List<Task> getAllTasks() throws SQLException;
    Task getTaskById(int id) throws SQLException;
    void updateTask(Task task) throws SQLException;
    void markTaskAsCompleted(int id) throws SQLException;
}
