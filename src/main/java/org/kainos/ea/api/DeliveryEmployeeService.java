package org.kainos.ea.api;

import org.kainos.ea.cli.DeliveryEmployeeRequest;
import org.kainos.ea.cli.DeliveryEmployeeUpdateRequest;
import org.kainos.ea.client.*;
import org.kainos.ea.core.DeliveryEmployeeValidator;
import org.kainos.ea.db.DeliveryDao;
import java.sql.SQLException;

public class DeliveryEmployeeService {
    DeliveryDao deliveryDao;
    DeliveryEmployeeValidator deliveryEmployeeValidator;
    public DeliveryEmployeeService(DeliveryDao deliveryDatabaseService, DeliveryEmployeeValidator deliveryEmployeeValidator) {
        this.deliveryDao = deliveryDatabaseService;
        this.deliveryEmployeeValidator = deliveryEmployeeValidator;
    }
    public int createDeliveryEmployee(DeliveryEmployeeRequest deliveryEmployee) throws FailedToCreateDeliveryEmployee, FailedToValidateEmployee
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
    public void updateDeliveryEmployee(int id,DeliveryEmployeeUpdateRequest deliveryEmployee) throws FailedToUpdateDeliveryEmployee, SQLException, DeliveryEmployeeDoesNotExist {
        try{
            if(!deliveryEmployeeValidator.doesEmployeeExist(id))
            {
                System.err.println("Employee does not exist");
                throw new DeliveryEmployeeDoesNotExist();
            }
            deliveryDao.updateDeliveryEmployee(id,deliveryEmployee);
        }
        catch (SQLException e)
        {
            System.err.println(e.getMessage());
            throw new FailedToUpdateDeliveryEmployee();
        }
    }

    public void deleteOrder(int id) throws FailedToDeleteDeliveryEmployee {
        try{
            deliveryDao.deleteDeliveryEmployee(id);
        } catch (SQLException e) {
            throw new FailedToDeleteDeliveryEmployee();
        }
    }
}
