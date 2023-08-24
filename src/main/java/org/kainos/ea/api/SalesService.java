package org.kainos.ea.api;

import org.kainos.ea.cli.SalesEmployeeRequest;
import org.kainos.ea.client.FailedToCreateSalesEmployeeException;
import org.kainos.ea.cli.SalesEmployee;
import org.kainos.ea.client.InvalidSalesEmployeeException;
import org.kainos.ea.db.SalesDAO;

import java.sql.SQLException;

public class SalesService {
    private SalesDAO salesDao = new SalesDAO();
    public int createSalesEmployee(SalesEmployeeRequest salesEmployee) throws FailedToCreateSalesEmployeeException {
        try {
            int id = salesDao.createSalesEmployee(salesEmployee);

            if (id == -1) {
                throw new FailedToCreateSalesEmployeeException();
            }
            return id;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            throw new FailedToCreateSalesEmployeeException();
        }
    }
}
