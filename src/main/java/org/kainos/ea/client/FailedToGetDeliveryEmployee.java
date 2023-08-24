package org.kainos.ea.client;

public class FailedToGetDeliveryEmployee extends Throwable{
    @Override
    public String getMessage(){
        return "Failed to get delivery employee";
    }
}
