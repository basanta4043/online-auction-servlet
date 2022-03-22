package com.onlineauction.onlineauctionservlet.exceptions;

public class InvalidDataFormatException extends Exception {


    public InvalidDataFormatException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidDataFormatException(String message) {
        super(message);
    }

    public InvalidDataFormatException(Throwable cause) {
        super(cause);
    }

}
