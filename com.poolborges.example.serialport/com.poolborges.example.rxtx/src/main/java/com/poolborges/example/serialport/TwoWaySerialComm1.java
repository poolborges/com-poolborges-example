/*
 * http://code.google.com/p/rb-project-name/source/browse/trunk/SmartHeat_WSN_Client/main/java/ie/georgiatech/smartheat/comm/serial/TwoWaySerialComm.java
 */
package com.poolborges.example.serialport;

import gnu.io.CommPort;
import gnu.io.CommPortIdentifier;
import gnu.io.NoSuchPortException;
import gnu.io.PortInUseException;
import gnu.io.SerialPort;
import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;
import gnu.io.UnsupportedCommOperationException;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.TooManyListenersException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This version of the TwoWaySerialComm example makes use of the
 * SerialPortEventListener to avoid polling.
 *
 */
public class TwoWaySerialComm1 {

    OutputStream out;

    public TwoWaySerialComm1() {
        super();
    }

    void connect(String portName) {
        try {
            CommPortIdentifier portIdentifier = CommPortIdentifier.getPortIdentifier(portName);

            if (portIdentifier.isCurrentlyOwned()) {
                System.out.println("Error: Port is currently in use");
            } else {
                try {
                    CommPort commPort = portIdentifier.open(this.getClass().getName(), 2000);

                    if (commPort instanceof SerialPort) {
                        try {
                            SerialPort serialPort = (SerialPort) commPort;
                            serialPort.setSerialPortParams(9600, SerialPort.DATABITS_8, SerialPort.STOPBITS_1, SerialPort.PARITY_NONE);

                            InputStream in = serialPort.getInputStream();
                            out = serialPort.getOutputStream();

                            (new Thread(new SerialWriter(out))).start();

                            serialPort.addEventListener(new SerialReader(in));
                            serialPort.notifyOnDataAvailable(true);
                        } catch (TooManyListenersException | UnsupportedCommOperationException | IOException ex) {
                            Logger.getLogger(TwoWaySerialComm1.class.getName()).log(Level.SEVERE, "Ocorreu erro ao connectar:{0}", portName);
                        }

                    } else {
                        Logger.getLogger("O recurso não é uma porta serial:{0}", portName);
                    }
                } catch (PortInUseException ex) {
                    Logger.getLogger(TwoWaySerialComm1.class.getName()).log(Level.SEVERE, "A porta esta em uso:{0}", portName);
                }
            }
        } catch (NoSuchPortException ex) {
            Logger.getLogger("A porta não existe:{0}",portName);
        }
    }

    public static String[] listAvailablePorts() {
        List<String> localVector = new ArrayList();
        try {
            Enumeration localEnumeration = CommPortIdentifier.getPortIdentifiers();
            while (localEnumeration.hasMoreElements()) {
                CommPortIdentifier localCommPortIdentifier = (CommPortIdentifier) localEnumeration.nextElement();
                if (localCommPortIdentifier.getPortType() == 1) {
                    String str = localCommPortIdentifier.getName();
                    localVector.add(str);
                }
            }
        } catch (UnsatisfiedLinkError | Exception localUnsatisfiedLinkError) {
            // errorMessage("ports", localUnsatisfiedLinkError);
        }
        String[] arrayOfString = new String[localVector.size()];
        localVector.toArray(arrayOfString);
        return arrayOfString;
    }

    void writeToCOM(String str) {
        try {
            this.out.write(str.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Handles the input coming from the serial port. A new line character is
     * treated as the end of a block in this example.
     */
    public static class SerialReader implements SerialPortEventListener {

        private InputStream in;
        private byte[] buffer = new byte[1024];

        public SerialReader(InputStream in) {
            this.in = in;
        }

        @Override
        public void serialEvent(SerialPortEvent arg0) {
            int data;

            try {
                int len = 0;
                while ((data = in.read()) > -1) {
                    //check for end of message \r\n
                    if (data == '\n') {
                        break;
                    }
                    buffer[len++] = (byte) data;
                }
                //System.out.println("FOI ENCONTRADO UM \\n");
                System.out.print(new String(buffer, 0, len));
            } catch (IOException e) {
                e.printStackTrace();
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
                e.printStackTrace();
                System.exit(-1);
            }
        }
    }

    public static void main(String[] args) {
        TwoWaySerialComm1 twsc = new TwoWaySerialComm1();
        for (int i = 0; i < TwoWaySerialComm1.listAvailablePorts().length; i++) {
            System.out.println(TwoWaySerialComm1.listAvailablePorts()[i]);
        }

        twsc.connect("COM2");
        twsc.writeToCOM("SmartHeatS;194;30;POLL;SmartHeatE");



    }
}
