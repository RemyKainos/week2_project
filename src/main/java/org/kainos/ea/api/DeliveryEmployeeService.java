package org.kainos.ea.api;

import org.eclipse.jetty.server.Authentication;
import org.kainos.ea.cli.DeliveryEmployee;
import org.kainos.ea.cli.DeliveryEmployeeRequest;
import org.kainos.ea.client.FailedToCreateDeliveryEmployee;
import org.kainos.ea.db.DeliveryDao;
import java.sql.SQLException;

public class DeliveryEmployeeService {
    DeliveryDao deliveryDatabaseService;
    public DeliveryEmployeeService(DeliveryDao deliveryDatabaseService) {
        this.deliveryDatabaseService = deliveryDatabaseService;
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
}
