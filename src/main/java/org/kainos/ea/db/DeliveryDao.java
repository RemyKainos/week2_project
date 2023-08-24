package org.kainos.ea.db;
import org.kainos.ea.cli.DeliveryEmployeeRequest;
import org.kainos.ea.cli.DeliveryEmployeeUpdateRequest;
import org.kainos.ea.cli.Employee;

import java.sql.*;

public class DeliveryDao {
    private DbConnector databaseConnector = new DbConnector();

    // connections to db for delivery CRUD operations to be done here.

    public int createDeliveryEmployee(DeliveryEmployeeRequest employee) throws SQLException {
        Connection c = databaseConnector.getConnection();
        String insertStatement = "INSERT INTO Delivery_Employee (name, salary, bank_number, ni) VALUES (?,?,?,?)";

        PreparedStatement st = c.prepareStatement(insertStatement, Statement.RETURN_GENERATED_KEYS);
        st.setString(1, employee.getName());
        st.setDouble(2, employee.getSalary());
        st.setString(3, employee.getBankAccountNumber());
        st.setString(4, employee.getNationInsuranceNumber());

        st.executeUpdate();

        ResultSet rs = st.getGeneratedKeys();

        if (rs.next()) {
            return rs.getInt(1);
        }

        return -1;
    }

    public void updateDeliveryEmployee(int id, DeliveryEmployeeUpdateRequest employeeToUpdate) throws SQLException {
        Connection c = databaseConnector.getConnection();
        String updateRequest = "UPDATE Delivery_Employee SET name=?, salary=?, bank_number=? WHERE de_id = ?";
        PreparedStatement st = c.prepareStatement(updateRequest);

        st.setString(1, employeeToUpdate.getName());
        st.setDouble(2, employeeToUpdate.getSalary());
        st.setString(3, employeeToUpdate.getBankAccountNumber());
        st.setInt(4, id);
        st.executeUpdate();
    }

    public Employee getDeliveryEmployee(int id) throws SQLException {
        Connection c = databaseConnector.getConnection();
        Statement st = c.createStatement();
        ResultSet rs = st.executeQuery("SELECT name, salary, bank_number, ni FROM Delivery_Employee WHERE de_id = " + id);

        while (rs.next()) {
            return new Employee(
                    rs.getString("name"),
                    id,
                    rs.getDouble("salary"),
                    rs.getString("bank_number"),
                    rs.getString("ni")
            );
        }
        return null;
    }
    public void deleteDeliveryEmployee(int id) throws SQLException
    {
        Connection c = databaseConnector.getConnection();
        String deleteStatement = "DELETE FROM Delivery_Employee WHERE de_id = " + id;
        PreparedStatement st = c.prepareStatement(deleteStatement);
        st.setInt(1,id);
        st.executeUpdate();
    }
}