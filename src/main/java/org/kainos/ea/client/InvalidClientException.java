package org.kainos.ea.client;

public class InvalidClientException extends Throwable {
    public InvalidClientException(String valid) {
        super(valid);
    }
}
