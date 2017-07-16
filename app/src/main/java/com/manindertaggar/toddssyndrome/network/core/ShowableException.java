package com.manindertaggar.toddssyndrome.network.core;

/**
 * Created by Maninder Taggar on 12/6/17.
 */

public class ShowableException extends Exception {

    public ShowableException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }
}
