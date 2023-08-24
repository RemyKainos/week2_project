package org.kainos.ea.api;

public class FailedToAssignClientException extends Throwable {
    @Override
    public String getMessage(){
        return "Failed to assign client exception";
    }
}
