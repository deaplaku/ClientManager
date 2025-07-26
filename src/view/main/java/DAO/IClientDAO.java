package DAO;

import model.Client;

import java.sql.SQLException;
import java.util.List;

public interface IClientDAO {
    void addClient(Client client) throws SQLException;
    List<Client> getAllClients() throws SQLException;
    Client getClientById(int id) throws SQLException;
    void updateClient(Client client) throws SQLException;
    void deleteClient(int id) throws SQLException;
    List<Client> searchClientByName(String name) throws SQLException;
}
