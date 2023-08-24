package org.kainos.ea.api;

import org.kainos.ea.cli.SalesEmployeeRequest;
import org.kainos.ea.client.FailedToCreateSalesEmployeeException;
import org.kainos.ea.cli.SalesEmployee;
import org.kainos.ea.client.InvalidSalesEmployeeException;
import org.kainos.ea.core.SalesEmployeeValidator;
import org.kainos.ea.db.SalesDAO;

import java.sql.SQLException;

public class SalesService {

    SalesDAO salesDao;
    SalesEmployeeValidator salesEmployeeValidator = new SalesEmployeeValidator();


    public SalesService (SalesDAO salesDAO) {
        this.salesDao = salesDAO;
    }

    public int createSalesEmployee(SalesEmployeeRequest salesEmployee) throws FailedToCreateSalesEmployeeException, InvalidSalesEmployeeException {

        try {



            String validation = salesEmployeeValidator.isValidSalesEmployee(salesEmployee);

            if (validation != null) {
                throw new InvalidSalesEmployeeException(validation);
            }
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
