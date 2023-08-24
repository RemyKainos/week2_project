package org.kainos.ea.db;

import org.kainos.ea.cli.Client;

<<<<<<< HEAD
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
=======
import java.sql.*;
>>>>>>> rebase

public class ClientDAO {
    public Client getClientById(int clientId) throws SQLException {
        Connection connection = DbConnector.getConnection();

        PreparedStatement selectStatement = connection.prepareStatement("SELECT Client_Id, Name, Address, Phone_Number, se_id FROM Client WHERE Client_Id = ?");
        selectStatement.setInt(1, clientId);

        ResultSet rs = selectStatement.executeQuery();

<<<<<<< HEAD
        while(rs.next()){
=======
        if(rs.next()){
>>>>>>> rebase
            return new Client(
                    rs.getInt("client_id"),
                    rs.getString("name"),
                    rs.getString("address"),
                    rs.getString("phone_number"),
                    rs.getInt("se_id")
                    );
        }

        return null;
    }
<<<<<<< HEAD
    public void assignClientToProject(int clientId, int projectId) throws SQLException {
        Connection connection = DbConnector.getConnection();

        PreparedStatement insertStatement = connection.prepareStatement("INSERT INTO `Project_Client` (`project_id`, `client_id`) VALUES ('?', '?');");
        insertStatement.setInt(1, clientId);
        insertStatement.setInt(2, projectId);

        insertStatement.executeUpdate();
=======
    public int assignClientToProject(int clientId, int projectId) throws SQLException {
        Connection connection = DbConnector.getConnection();

        PreparedStatement insertStatement = connection.prepareStatement("INSERT INTO `Project_Client` (`project_id`, `client_id`) VALUES ('?', '?');", Statement.RETURN_GENERATED_KEYS);
        insertStatement.setInt(1, projectId);
        insertStatement.setInt(2, clientId);

        insertStatement.executeUpdate();

        ResultSet rs = insertStatement.getGeneratedKeys();

        if(rs.next()){
            return rs.getInt(1);
        }

        return -1;
>>>>>>> rebase
    }
}
