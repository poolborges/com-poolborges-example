/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poolborges.example.serialport;

import gnu.io.CommPort;
import gnu.io.CommPortIdentifier;
import gnu.io.SerialPort;
import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;

import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * This version of the TwoWaySerialComm example makes use of the
 * SerialPortEventListener to avoid polling.
 *
 */
public class TwoWaySerialComm2 {

    static FileWriter out;

    public TwoWaySerialComm2() {
        super();
        try {
            out = new FileWriter("c:\\igloo.log", true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void connect(String portName) throws Exception {
        CommPortIdentifier portIdentifier = CommPortIdentifier.getPortIdentifier(portName);
        if (portIdentifier.isCurrentlyOwned()) {
            System.out.println("Error: Port is currently in use");
        } else {
            CommPort commPort = portIdentifier.open(this.getClass().getName(), 2000);

            if (commPort instanceof SerialPort) {
                SerialPort serialPort = (SerialPort) commPort;
                serialPort.setSerialPortParams(9600, SerialPort.DATABITS_8, SerialPort.STOPBITS_1, SerialPort.PARITY_NONE);

                InputStream inSerial = serialPort.getInputStream();
                OutputStream outSerial = serialPort.getOutputStream();

                (new Thread(new SerialWriter(outSerial))).start();

                serialPort.addEventListener(new SerialReader(inSerial));
                serialPort.notifyOnDataAvailable(true);

            } else {
                System.out.println("Error: Only serial ports are handled by this example.");
            }
        }
    }

    /**
     * Handles the input coming from the serial port. A new line character is
     * treated as the end of a block in this example.
     */
    public static class SerialReader implements SerialPortEventListener {

        private InputStream in;
        private byte[] portBuffer = new byte[1024];
        private String fileBuffer;

        public SerialReader(InputStream in) {
            this.in = in;
        }

        @Override
        public void serialEvent(SerialPortEvent arg0) {
            int data;

            try {
                int len = 0;
                while ((data = in.read()) > -1) {
                    portBuffer[len++] = (byte) data;
                    if (data == '\n') {
                        break;
                    }
                }
                fileBuffer = new String(portBuffer, 0, len);
                java.util.Date today = new java.util.Date();
                String date = new java.sql.Timestamp(today.getTime()).toString();
                fileBuffer = fileBuffer.replaceAll("@", "\n" + date + "|");
                out.write(fileBuffer.toString());
                out.flush();
                System.out.print(fileBuffer.toString());
            } catch (IOException e) {
                System.out.println("ERROR: SerialReader->serialEvent");               
                System.exit(-1);
            }
        }
    }

    /**
     *
     */
    public static class SerialWriter implements Runnable {

        OutputStream out;

        public SerialWriter(OutputStream out) {
            this.out = out;
        }

        @Override
        public void run() {
            try {
                int c;
                while ((c = System.in.read()) > -1) {
                    this.out.write(c);
                }
            } catch (IOException e) {
               System.out.println("ERROR: SerialWriter");
                System.exit(-1);
            }
        }
    }

    public static void main(String[] args) {
        try {
            (new TwoWaySerialComm2()).connect("COM4");
        } catch (Exception e) {
            // TODO Auto-generated catch block
            System.out.println("ERROR: main serial.connect");
        }
    }
}
