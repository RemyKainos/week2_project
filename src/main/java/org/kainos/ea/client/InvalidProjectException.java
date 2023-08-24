package org.kainos.ea.client;

public class InvalidProjectException extends Throwable {
    public InvalidProjectException(String validClient) {
        super(validClient);
    }
}
