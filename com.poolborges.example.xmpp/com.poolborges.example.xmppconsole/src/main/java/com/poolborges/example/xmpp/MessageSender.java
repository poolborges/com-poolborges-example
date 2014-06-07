/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poolborges.example.xmpp;


import org.jivesoftware.smack.ConnectionConfiguration;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.packet.Message;

/**
 *
 * @author Borges
 */
public class  MessageSender {
    private static String username =  "MAIL-AQUI@gmail.com"; 
    private static String password =  "PASSWORD_AQUI"; 
    ConnectionConfiguration connConfig;
    XMPPConnection connection;
                        
    public MessageSender() throws  XMPPException {
        connConfig = new  ConnectionConfiguration("talk.google.com", 5222, "gmail.com");
        connection = new XMPPConnection(connConfig);
        connection.connect();
        connection.login(username, password);
    }
    
    public void sendMessage(String to, String  message ) {
        Message msg = new Message(to,  Message.Type.chat);
        msg.setBody(message);
       connection.sendPacket(msg);
    }
    
    public void disconnect() {
        connection.disconnect(); 
    }
    
    public static void main(String[] args)  throws XMPPException {
        
       MessageSender messageSender = new  MessageSender();
       messageSender.sendMessage("EMAIL-DE-UM-CONATCO-@gmail.com",  
             "Ola. Esta menssagem foi enviada por Smack API  and Google Talk.");
       messageSender.disconnect();
   }
}