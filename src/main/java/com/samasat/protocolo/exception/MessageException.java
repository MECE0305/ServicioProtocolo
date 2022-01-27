package com.samasat.protocolo.exception;

public class MessageException {

    public String MessageException(String message) {
        String[] splite = message.split("'");
        return splite[1];
    }
}
