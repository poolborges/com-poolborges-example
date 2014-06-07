/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poolborges.example.serialport.socket;

import com.poolborges.example.serialport.TwoWaySerialComm;
import gnu.io.CommPort;
import gnu.io.CommPortIdentifier;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author PauloBorges
 */
public class ServidorSocket {

    private ServerSocket serverSocket;

    public ServidorSocket(int port) throws IOException {
        serverSocket = new ServerSocket(port);
        serverSocket.setSoTimeout(10000);
    }

    public void run() {
        while (true) {
            try {
                System.out.println("Waiting for client on port "
                        + serverSocket.getLocalPort() + "...");

                Socket server = serverSocket.accept();

                System.out.println("Just connected to "
                        + server.getRemoteSocketAddress());

                DataInputStream in =
                        new DataInputStream(server.getInputStream());

                System.out.println(in.readUTF());

                DataOutputStream out =
                        new DataOutputStream(server.getOutputStream());

                out.writeUTF("Thank you for connecting to "
                        + server.getLocalSocketAddress() + "\nGoodbye!");

                server.close();
            } catch (SocketTimeoutException s) {
                System.out.println("Socket timed out!");
                break;
            } catch (IOException e) {
                e.printStackTrace();
                break;
            }
        }
    }

    void connect() {
        try {
            Socket server = serverSocket.accept();

            InputStream in = server.getInputStream();
            OutputStream out = server.getOutputStream();

            (new Thread(new TwoWaySerialComm.SerialReader(in))).start();
            (new Thread(new TwoWaySerialComm.SerialWriter(out))).start();
        } catch (SocketTimeoutException s) {
            System.out.println("Socket timed out!");
        } catch (IOException ex) {
            System.out.println("IOException");
        }


    }

    public static void main(String[] args) {
        //int port = Integer.parseInt(args[0]);
        int port = 1506;
        try {
            //Thread t = new ServidorSocket(port);
            //t.start();
            ServidorSocket ser = new ServidorSocket(port);
            ser.connect();
            //ser.run();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception ex) {
            Logger.getLogger(ServidorSocket.class.getName()).log(Level.SEVERE, null, ex);
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
                                System.out.println(builder.toString());
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
    /*
     public static void main(String[] args) {
     try {
     (new TwoWaySerialComm()).connect("COM2");
     } catch (Exception e) {
     System.out.println("Execpão ocorreu no main");
     System.err.print(e);
     }
     }
     * */
}
