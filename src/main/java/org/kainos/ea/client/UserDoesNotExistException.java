package org.kainos.ea.client;

public class UserDoesNotExistException extends Exception{
    @Override
    public String getMessage(){
        return "User does not exist in database";
    }
}
