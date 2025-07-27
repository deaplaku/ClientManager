package DAO;

import model.Client;
import utility.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClientDAO implements IClientDAO {
    public void addClient(Client client) throws SQLException {
        String sql = "INSERT INTO clients (name, surname, company) VALUES (?, ?, ?)";
        try (Connection connection = DBConnection.getConnection(); PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, client.getName());
            stmt.setString(2, client.getSurname());
            stmt.setString(3, client.getCompany());
            stmt.executeUpdate();
        }
    }

    public List<Client> getAllClients() throws SQLException {
        List<Client> clients = new ArrayList<>();
        String sql = "SELECT * FROM clients";

        try (Connection connection = DBConnection.getConnection(); Statement stmt = connection.createStatement(); ResultSet resultSet = stmt.executeQuery(sql)){
            while(resultSet.next()){
                Client client = new Client(
                        resultSet.getString("name"),
                        resultSet.getString("surname"),
                        resultSet.getString("company")
                );
                client.setId(resultSet.getInt("id"));
                clients.add(client);
            }
        }
        return clients;
    }

    public Client getClientById(int id) throws SQLException {
        String sql = "SELECT * FROM clients WHERE id = ?";
        try (Connection connection = DBConnection.getConnection(); PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet resultSet = stmt.executeQuery();

            if(resultSet.next()){
                String name = resultSet.getString("name");
                String surname = resultSet.getString("surname");
                String company = resultSet.getString("company");

                Client client = new Client(name, surname, company);
                client.setId(id);
                return client;
            }
        }
        return null;
    }

    @Override
    public void updateClient(Client client) throws SQLException {
        String sql = "UPDATE clients SET name = ?, surname = ?, company = ? WHERE id = ?";

        try (Connection connection = DBConnection.getConnection(); PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, client.getName());
            stmt.setString(2, client.getSurname());
            stmt.setString(3, client.getCompany());
            stmt.setInt(4, client.getId());

            stmt.executeUpdate();
        }
    }

    @Override
    public void deleteClient(int id) throws SQLException {
        String sql = "DELETE FROM clients WHERE id = ?";
        try (Connection connection = DBConnection.getConnection(); PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

    @Override
    public List<Client> searchClientByName(String target) throws SQLException {
        String sql = "SELECT * FROM clients WHERE LOWER (name) LIKE ? OR LOWER (surname) LIKE ?";
        List<Client> result = new ArrayList<>();

        try (Connection connection = DBConnection.getConnection(); PreparedStatement stmt = connection.prepareStatement(sql)) {
            String searchTerm = "%" + target.toLowerCase() + "%";
            stmt.setString(1, searchTerm);
            stmt.setString(2, searchTerm);

            ResultSet resultSet = stmt.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String surname = resultSet.getString("surname");
                String company = resultSet.getString("company");

                Client client = new Client(name, surname, company);
                client.setId(id);
                result.add(client);
            }
        }
        return result;
    }
}
