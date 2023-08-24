package org.kainos.ea.client;

public class FailedToCreateDeliveryEmployee extends Throwable{
    @Override
    public String getMessage(){
        return  "Failed to create delivery employee";
    }
}
