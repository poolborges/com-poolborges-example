package com.poolborges.example.serialport;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public interface SerialPort {

    void open() throws SerialPortException;

    InputStream getInputStream() throws IOException;
    
    public OutputStream getOutputStream() throws IOException;;

    void close();
}