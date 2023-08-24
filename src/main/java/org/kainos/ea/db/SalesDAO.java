package org.kainos.ea.db;

import org.kainos.ea.cli.SalesEmployee;
import org.kainos.ea.cli.SalesEmployeeRequest;
import org.kainos.ea.client.FailedToUpdateSalesEmployeeException;
import org.kainos.ea.client.SalesEmployeeDoesNotExistException;

import java.sql.*;

public class SalesDAO {
    private DbConnector databaseConnector = new DbConnector();

    public int createSalesEmployee(SalesEmployeeRequest salesEmployee) throws SQLException {
        Connection c = databaseConnector.getConnection();

        String insertStatement = "INSERT INTO Sales_Employee (Name, Salary, bank_number, ni, commission_rate) VALUES (?,?,?,?,?)";
        PreparedStatement st = c.prepareStatement(insertStatement, Statement.RETURN_GENERATED_KEYS);

        st.setString(1, salesEmployee.getName());
        st.setDouble(2, salesEmployee.getSalary());
        st.setString(3, salesEmployee.getBankAccountNumber());
        st.setString(4, salesEmployee.getNationInsuranceNumber());
        st.setDouble(5, salesEmployee.getCommission_rate());


        st.executeUpdate();

        ResultSet rs = st.getGeneratedKeys();

        if (rs.next()){
            return rs.getInt(1);
        }
        return -1;
    }

    /*public void updateProduct(int id, SalesEmployee sales) throws SalesEmployeeDoesNotExistException, FailedToUpdateSalesEmployeeException {
        Product productToUpdate = productDao.getProductById(id);

        if (productToUpdate == null) {
            throw new ProductDoesNotExistException();
        }

        productDao.updateProduct(id, product);

    } catch (SQLException e) {
        System.err.println(e.getMessage());
        throw new FailedToUpdateProductException();
    }
    }*/
}
