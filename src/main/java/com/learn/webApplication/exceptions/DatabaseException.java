package com.learn.webApplication.exceptions;

/**
 * Created by z002v2f on 17/11/17.
 */
public class DatabaseException extends Exception {

    public DatabaseException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
