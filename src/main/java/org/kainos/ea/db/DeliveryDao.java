package org.kainos.ea.db;
import org.kainos.ea.cli.DeliveryEmployee;
import org.kainos.ea.cli.DeliveryEmployeeRequest;

import java.sql.*;

public class DeliveryDao {
    private DbConnector databaseConnector = new DbConnector();

    // connections to db for delivery CRUD operations to be done here.

    public int createDeliveryEmployee(DeliveryEmployeeRequest employee) throws SQLException
    {
        Connection c = databaseConnector.getConnection();
        String insertStatement = "INSERT INTO Delivery_Employee (name, salary, bank_number, ni) VALUES (?,?,?,?)";

        PreparedStatement st = c.prepareStatement(insertStatement, Statement.RETURN_GENERATED_KEYS);
        st.setString(1, employee.getName());
        st.setDouble(2, employee.getSalary());
        st.setString(3, employee.getBankAccountNumber());
        st.setString(4, employee.getNationInsuranceNumber());

        st.executeUpdate();

        ResultSet rs = st.getGeneratedKeys();

        if(rs.next())
        {
            return rs.getInt(1);
        }

        return -1;
    }
}