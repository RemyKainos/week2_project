package org.kainos.ea.client;

public class DeliveryEmployeeDoesNotExist extends Exception{
    @Override
    public String getMessage(){
        return "Delivery employee does not exist in database";
    }
}
