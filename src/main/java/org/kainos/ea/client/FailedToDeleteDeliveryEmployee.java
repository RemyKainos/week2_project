package org.kainos.ea.client;

public class FailedToDeleteDeliveryEmployee extends Throwable {
    @Override
    public String getMessage()
    {
        return "Failed to delete delivery employee";
    }
}
