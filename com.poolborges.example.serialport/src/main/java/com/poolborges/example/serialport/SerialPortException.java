package com.poolborges.example.serialport;

public class SerialPortException extends Exception {

    private static final long serialVersionUID = 1L;

    public SerialPortException() {
    }

    public SerialPortException(String message) {
        super(message);
    }

    public SerialPortException(Throwable cause) {
        super(cause);
    }

    public SerialPortException(String message, Throwable cause) {
        super(message, cause);
    }
}
