package org.kainos.ea.client;

public class FailedToUpdateDeliveryEmployee extends Exception {
    @Override
    public String getMessage(){
        return "Failed to update delivery employee";
    }
}
