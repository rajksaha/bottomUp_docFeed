package com.bottomUp.common.exception;

/**
 * Created by raj on 7/25/2020.
 */
public class BottomUpException extends Exception {

    public BottomUpException(String message){
        super(message);
    }

    public BottomUpException(String message, Throwable th){
        super(message, th);
    }
}
