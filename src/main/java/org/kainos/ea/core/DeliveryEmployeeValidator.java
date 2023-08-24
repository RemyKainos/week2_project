package org.kainos.ea.core;

import org.kainos.ea.cli.DeliveryEmployeeRequest;
import org.kainos.ea.cli.DeliveryEmployeeUpdateRequest;
import org.kainos.ea.db.DeliveryDao;

import java.sql.SQLException;

public class DeliveryEmployeeValidator {
    DeliveryDao deliveryDao;

    public DeliveryEmployeeValidator(DeliveryDao deliveryDao) {
        this.deliveryDao = deliveryDao;
    }

    public boolean doesEmployeeExist(int id) throws SQLException {
        return deliveryDao.getDeliveryEmployee(id) == null;
    }

    public String isEmployeeValid(DeliveryEmployeeRequest deliveryEmployee) {
        if(deliveryEmployee.getName().length() > 70)
        {
            return "Name is too long";
        }
        if(deliveryEmployee.getBankAccountNumber().length() > 34) // I know this is just wrong but it's what the DB check is
        {
            return "Bank account number too long";
        }
        if(deliveryEmployee.getNationInsuranceNumber().length() > 10)
        {
            return "National insurance number too long";
        }
        return null;
    }

    public String isDeliveryUpdateValid(DeliveryEmployeeUpdateRequest employeeToUpdate) {
        if(employeeToUpdate.getName().length() > 70)
        {
            return "Name is too long";
        }
        if(employeeToUpdate.getBankAccountNumber().length() > 34) // I know this is just wrong but it's what the DB check is
        {
            return "Bank account number too long";
        }
        return null;
    }
}
