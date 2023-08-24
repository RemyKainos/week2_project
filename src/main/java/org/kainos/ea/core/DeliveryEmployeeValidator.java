package org.kainos.ea.core;

import org.kainos.ea.cli.DeliveryEmployee;
import org.kainos.ea.client.FailedToGetDeliveryEmployee;
import org.kainos.ea.db.DeliveryDao;

import java.sql.SQLException;

public class DeliveryEmployeeValidator {
    DeliveryDao deliveryDao;

    public DeliveryEmployeeValidator(DeliveryDao deliveryDao) {
        this.deliveryDao = deliveryDao;
    }

    public String doesEmployeeExist(int id) throws SQLException {
        if (deliveryDao.getDeliveryEmployee(id) == null) {
            return "Employee does not exists";
        }
        return null;
    }
}
