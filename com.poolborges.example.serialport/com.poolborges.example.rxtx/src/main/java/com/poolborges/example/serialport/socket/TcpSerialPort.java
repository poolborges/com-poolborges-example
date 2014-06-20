package com.poolborges.example.serialport.socket;

import com.poolborges.example.serialport.SerialPort;
import com.poolborges.example.serialport.SerialPortException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * Client
 * @author PauloBorges
 */
public class TcpSerialPort implements SerialPort {

    public static final int DEFAULT_SOCKET_TIMEOUT = 15 * 1000;
    private final String host;
    private final int port;
    private final int timeout;
    private Socket socket;

    public TcpSerialPort(String host, int port) {
        this(host, port, DEFAULT_SOCKET_TIMEOUT);
    }

    private TcpSerialPort(String host, int port, int timeout) {
        super();
        this.host = host;
        this.port = port;
        this.timeout = timeout;
    }

    @Override
    public void open() throws SerialPortException {
        try {
            socket = new Socket(host, port);
            socket.setSoTimeout(timeout);
        } catch (UnknownHostException e) {
            throw new SerialPortException(e);
        } catch (IOException e) {
            throw new SerialPortException(e);
        }
        
    }

    @Override
    public InputStream getInputStream() throws IOException {
        return socket.getInputStream();
    }


    @Override
    public void close() {
        try {
            socket.close();
        } catch (IOException e) {
        }
    }

    @Override
    public String toString() {
        return "[TCP] " + host + ":" + port;
    }

    @Override
    public OutputStream getOutputStream() throws IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
