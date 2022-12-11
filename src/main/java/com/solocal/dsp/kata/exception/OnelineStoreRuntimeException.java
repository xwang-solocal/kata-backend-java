package com.solocal.dsp.kata.exception;

public class OnelineStoreRuntimeException extends RuntimeException {

    public OnelineStoreRuntimeException() {
        super();
    }

    public OnelineStoreRuntimeException(String msg) {
        super(msg);
    }

    public OnelineStoreRuntimeException(String msg, Throwable ex) {
        super(msg, ex);
    }
}
