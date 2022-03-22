package com.onlineauction.onlineauctionservlet.exceptions;

public class ForbiddenAccessException extends Exception {

    public ForbiddenAccessException(String message, Throwable cause) {
        super(message, cause);
    }

    public ForbiddenAccessException(String message) {
        super(message);
    }

    public ForbiddenAccessException(Throwable cause) {
        super(cause);
    }


}
