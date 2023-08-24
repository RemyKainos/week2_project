package org.kainos.ea.api;

import org.kainos.ea.cli.*;
import org.kainos.ea.client.FailedToCreateDeliveryEmployee;
import org.kainos.ea.client.FailedToGetDeliveryEmployee;
import org.kainos.ea.client.FailedToUpdateDeliveryEmployee;
import org.kainos.ea.client.DeliveryEmployeeDoesNotExistException;
import org.kainos.ea.core.DeliveryEmployeeValidator;
import org.kainos.ea.db.DeliveryDao;
import java.sql.SQLException;

public class DeliveryEmployeeService {
    DeliveryDao deliveryDatabaseService;
    DeliveryEmployeeValidator deliveryEmployeeValidator;
    public DeliveryEmployeeService(DeliveryDao deliveryDatabaseService, DeliveryEmployeeValidator deliveryEmployeeValidator) {
        this.deliveryDatabaseService = deliveryDatabaseService;
        this.deliveryEmployeeValidator = deliveryEmployeeValidator;
    }
    public int createDeliveryEmployee(DeliveryEmployeeRequest deliveryEmployee) throws FailedToCreateDeliveryEmployee
    {
        try{
            String validation = deliveryEmployeeValidator.isEmployeeValid(deliveryEmployee);

            if(validation != null)
            {
                System.err.println(validation);
                throw new FailedToValidateEmployee();
            }

            int id = deliveryDao.createDeliveryEmployee(deliveryEmployee);

            if(id == -1)
            {
                throw new FailedToCreateDeliveryEmployee();
            }

            return id;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            throw new FailedToCreateDeliveryEmployee();
        }
    }
    public void updateDeliveryEmployee(int id,DeliveryEmployeeUpdateRequest deliveryEmployee) throws FailedToUpdateDeliveryEmployee, SQLException, DeliveryEmployeeDoesNotExistException {
        try{
            boolean validation = deliveryEmployeeValidator.doesEmployeeExist(id);
            if(!validation)
            {
                System.err.println(validation);
                throw new DeliveryEmployeeDoesNotExistException();
            }
            deliveryDatabaseService.updateDeliveryEmployee(id,deliveryEmployee);
        }
        catch (SQLException e)
        {
            System.err.println(e.getMessage());
            throw new FailedToUpdateDeliveryEmployee();
        }
    }

    public GetDeliveryEmployee getDeliveryEmployee(int id) throws DeliveryEmployeeDoesNotExistException, FailedToGetDeliveryEmployee{
        try {
            Employee deliveryEmployee = deliveryDatabaseService.getDeliveryEmployee(id);

            if (deliveryEmployee == null) {
                throw new DeliveryEmployeeDoesNotExistException();
            }
            return new GetDeliveryEmployee(deliveryEmployee.getName(),deliveryEmployee.getSalary(),deliveryEmployee.getBankAccountNumber(),deliveryEmployee.getNationInsuranceNumber());
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            throw new FailedToGetDeliveryEmployee();
        }
    }
}
