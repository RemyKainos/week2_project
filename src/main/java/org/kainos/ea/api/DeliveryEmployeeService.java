package org.kainos.ea.api;

import org.kainos.ea.cli.DeliveryEmployeeRequest;
import org.kainos.ea.cli.DeliveryEmployeeUpdateRequest;
import org.kainos.ea.client.FailedToCreateDeliveryEmployee;
import org.kainos.ea.client.FailedToGetDeliveryEmployee;
import org.kainos.ea.client.FailedToUpdateDeliveryEmployee;
import org.kainos.ea.client.UserDoesNotExistException;
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
            int id = deliveryDatabaseService.createDeliveryEmployee(deliveryEmployee);
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
    public void updateDeliveryEmployee(int id,DeliveryEmployeeUpdateRequest deliveryEmployee) throws FailedToUpdateDeliveryEmployee, SQLException, UserDoesNotExistException {
        try{
            String validation = deliveryEmployeeValidator.doesEmployeeExist(id);
            if(validation != null)
            {
                System.err.println(validation);
                throw new UserDoesNotExistException();
            }
            deliveryDatabaseService.updateDeliveryEmployee(id,deliveryEmployee);
        }
        catch (SQLException e)
        {
            System.err.println(e.getMessage());
            throw new FailedToUpdateDeliveryEmployee();
        }
    }
}
