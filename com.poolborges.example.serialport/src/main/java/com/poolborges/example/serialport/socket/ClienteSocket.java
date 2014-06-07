/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poolborges.example.serialport.socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 *
 * @author PauloBorges
 */
public class ClienteSocket {
    public static void main(String [] args)
   {
      String serverName = "localhost";//args[0];
      int port = 1506;//Integer.parseInt(args[1]);
      try
      {
         System.out.println("Connecting to " + serverName + " on port " + port);
          try (Socket client = new Socket(serverName, port)) {
              System.out.println("Just connected to "
                           + client.getRemoteSocketAddress());
              OutputStream outToServer = client.getOutputStream();
              DataOutputStream out =
                            new DataOutputStream(outToServer);

              out.writeUTF("Hello from "
                           + client.getLocalSocketAddress());
              InputStream inFromServer = client.getInputStream();
              DataInputStream in =
                             new DataInputStream(inFromServer);
              System.out.println("Server says " + in.readUTF());
          }
      }catch(IOException e)
      {
         e.printStackTrace();
      }
   }
}
