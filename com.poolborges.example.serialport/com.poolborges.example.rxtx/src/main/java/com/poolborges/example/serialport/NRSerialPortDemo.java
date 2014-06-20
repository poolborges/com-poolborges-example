package com.poolborges.example.serialport;

import gnu.io.NRSerialPort;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/**
 * Hello world!
 *
 */
public class NRSerialPortDemo {

    public static void main(String[] args) {

        NRSerialPort serial = new NRSerialPort("COM2", 9600);

        serial.connect();

        DataInputStream ins = new DataInputStream(serial.getInputStream());
        DataOutputStream outs = new DataOutputStream(serial.getOutputStream());

        byte b;
        while (true) {
            try {
                b = (byte) ins.read();
                //outs.write(b);
                System.out.print(b);
            } catch (IOException ex) {
                System.err.print(ex);
            } finally {
                serial.disconnect();
            }
        }
    }
}
