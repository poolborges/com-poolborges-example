/* com.poolborges.example.rxtx.TwoWaySerialComm
 $ sudo apt-get install librxtx-java

 $ javac -cp /usr/share/java/RXTXcomm.jar:. TwoWaySerialComm.java
 $ java -Djava.library.path=/usr/lib/jni -cp /usr/share/java/RXTXcomm.jar:. TwoWaySerialComm

 http://eclipsesource.com/blogs/2012/10/17/serial-communication-in-java-with-raspberry-pi-and-rxtx/
 http://rxtx.qbang.org/wiki/index.php/Two_way_communcation_with_the_serial_port

 */
package com.poolborges.example.serialport;

import gnu.io.CommPort;
import gnu.io.CommPortIdentifier;
import gnu.io.SerialPort;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class TwoWaySerialComm {

    void connect(String portName) throws Exception {

        CommPortIdentifier portIdentifier =
                CommPortIdentifier.getPortIdentifier(portName);

        if (portIdentifier.isCurrentlyOwned()) {
            System.out.println("Error: Port is currently in use");
        } else {
            int timeout = 2000;
            CommPort commPort = portIdentifier.open(
                    this.getClass().getName(), timeout);

            if (commPort instanceof SerialPort) {
                SerialPort serialPort = (SerialPort) commPort;
                serialPort.setSerialPortParams(9600,
                        SerialPort.DATABITS_8,
                        SerialPort.STOPBITS_1,
                        SerialPort.PARITY_NONE);

                InputStream in = serialPort.getInputStream();
                OutputStream out = serialPort.getOutputStream();

                (new Thread(new SerialReader(in))).start();
                (new Thread(new SerialWriter(out))).start();

            } else {
                System.out.println("Error: Only serial ports are handled by this example.");
            }
        }
    }

    public static class SerialReader implements Runnable {

        InputStream in;

        public SerialReader(InputStream in) {
            this.in = in;
        }

        @Override
        public void run() {
            byte[] buffer = new byte[1024];
            int len;
            final StringBuilder builder = new StringBuilder(1024);
            char read;
            boolean lastWasReturn = false;
            try {
                while ((len = this.in.read(buffer)) > -1) {
                    //System.out.print(new String(buffer, 0, len));

                    for (int count = 0; count < len; count++) {
                        read = (char) buffer[count];
                        if (read == '\r') {
                            lastWasReturn = true;
                            continue; // ignorar os \r
                        }

                        if (read == '\n' && lastWasReturn) {
                            if (builder.length() > 0) {
                                //sink.consume(builder.toString());
                                System.out.println("{WSBP:{"+builder.toString()+"},DAY}");
                                builder.delete(0, builder.length());
                            }
                            lastWasReturn = false;
                            continue;
                        }

                        lastWasReturn = false;
                        builder.append((char) read);
                    }
                }
            } catch (IOException e) {
                System.out.println("Execpão ocorreu no SerialReader");
            }
        }
    }

    public static class SerialWriter implements Runnable {

        OutputStream out;

        public SerialWriter(OutputStream out) {
            this.out = out;
        }

        @Override
        public void run() {
            try {
                int caracter_recebido;
                while ((caracter_recebido = System.in.read()) > -1) {
                    this.out.write(caracter_recebido);
                }
            } catch (IOException e) {
                System.out.println("Execpão ocorreu no SerialWriter");
            }
        }
    }

    public static void main(String[] args) {
        try {
            (new TwoWaySerialComm()).connect("COM4");
        } catch (Exception e) {
            System.out.println("Execpão ocorreu no main");
            System.err.print(e);
        }
    }
}
