package DAO;

import model.*;
import utility.DBConnection;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;

public class TaskDAO implements ITaskDAO{

    private final ClientDAO clientDAO = new ClientDAO();

    public void addTask(Task task) throws SQLException {
        String sql = "INSERT INTO tasks (client_id, date, price, description, task_status, pay_status) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection connection = DBConnection.getConnection(); PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, task.getClient().getId());

            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            stmt.setString(2, formatter.format(task.getDate()));

            stmt.setDouble(3, task.getPrice());
            stmt.setString(4, task.getDescription());
            stmt.setString(5, task.getStatus().name());       // store enum as string
            stmt.setString(6, task.getPayStatus().name());

            stmt.executeUpdate();
        }
    }

    public List<Task> getAllTasks() throws SQLException {
        List<Task> tasks = new ArrayList<>();
        String sql = "SELECT * FROM tasks";

        try (Connection connection = DBConnection.getConnection();
             Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                int clientId = rs.getInt("client_id");
                Client client = clientDAO.getClientById(clientId);

                String description = rs.getString("description");
                LocalDate date = LocalDate.parse(rs.getString("date"));
                double price = rs.getDouble("price");
                TaskStatus status = TaskStatus.valueOf(rs.getString("task_status"));
                PayStatus payStatus = PayStatus.valueOf(rs.getString("pay_status"));

                Task task = new Task(client, description, date, price);
                task.setStatus(status);
                task.setPayStatus(payStatus);

                tasks.add(task);
            }
        }

        return tasks;
    }

    @Override
    public Task getTaskById(int id) throws SQLException {
        String sql = "SELECT * FROM tasks WHERE id = ?";
        try (Connection connection = DBConnection.getConnection(); PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet resultSet = stmt.executeQuery();

            if(resultSet.next()) {
                int clientId = resultSet.getInt("client_id");
                Client client = clientDAO.getClientById(clientId);
                String description = resultSet.getString("description");
                LocalDate date = resultSet.getDate("date").toLocalDate();
                double price = resultSet.getDouble("price");

                Task task = new Task(client, description, date, price);
                task.setId(id);
                return task;
            }
        }
        return null;
    }

    @Override
    public void updateTask(Task task) throws SQLException {
        String sql = "UPDATE tasks SET client_id = ?, date = ?, price = ?, description = ?, task_status = ?, pay_status = ? WHERE id = ?";

        try (Connection connection = DBConnection.getConnection(); PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, task.getClient().getId());

            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            stmt.setString(2, formatter.format(task.getDate()));

            stmt.setDouble(3, task.getPrice());
            stmt.setString(4, task.getDescription());
            stmt.setString(5, task.getStatus().name());
            stmt.setString(6, task.getPayStatus().name());
            stmt.setInt(7, task.getId());

            stmt.executeUpdate();
        }
    }


    @Override
    public void markTaskAsCompleted(int id) throws SQLException {
        String sql = "UPDATE tasks SET task_status = ? WHERE id = ?";

        try (Connection connection = DBConnection.getConnection(); PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, TaskStatus.DONE.name());
            stmt.setInt(2, id);
            stmt.executeUpdate();
        }
    }

    public void deleteTask(int id) throws SQLException {
        String sql = "DELETE FROM tasks WHERE id = ?";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}
