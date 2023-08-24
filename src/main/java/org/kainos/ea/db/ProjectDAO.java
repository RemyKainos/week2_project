package org.kainos.ea.db;

import org.kainos.ea.cli.Client;
import org.kainos.ea.cli.Project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProjectDAO {
    public Project getProjectById(int projectId) throws SQLException {
        Connection connection = DbConnector.getConnection();

        PreparedStatement selectStatement = connection.prepareStatement("SELECT project_id, name, value, lead_id, start_date, complete_date FROM Project WHERE project_id = ?");
        selectStatement.setInt(1, projectId);

        ResultSet rs = selectStatement.executeQuery();

        while(rs.next()){
            return new Project(rs.getString("name"),
                    rs.getInt("value"),
                    rs.getInt("lead_id"),
                    rs.getDate("start_date"),
                    rs.getDate("complete_date")
            );
        }

        return null;
    }
}
