package org.kainos.ea.client;

public class FailedToValidateEmployee extends Throwable {
    @Override
    public String getMessage(){
        return "Failed to validate employee";
    }
}
