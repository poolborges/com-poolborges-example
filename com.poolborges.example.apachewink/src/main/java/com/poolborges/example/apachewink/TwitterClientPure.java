package com.poolborges.example.apachewink;



import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

/**
 *
 * @author Borges
 */
public class TwitterClientPure {
   public static void main(String[] args) {
       SendTwitter(args[0]);
   }
       public static void SendTwitter(String msg ) {
       try {
           int proxyon = 1;
           String proxyurl = "www-yourproxy.com";
           int proxyport = 80;
           String twitteruser = "username";
           String twitterpass = "password";
           SocketAddress addr = null;
           java.net.Proxy proxy = null;
           URLConnection connection = null;
           String credentials = twitteruser + ":" + twitterpass;
         
           if (proxyon == 1){
                 addr = new InetSocketAddress(proxyurl, proxyport);
                 proxy = new java.net.Proxy(java.net.Proxy.Type.HTTP, addr);
           }
         
           String encodecredentials = new sun.misc.BASE64Encoder().encode (credentials.getBytes());
         
           URL url = new URL("http://twitter.com/statuses/update.xml");
           String encodedData = URLEncoder.encode(msg, "UTF-8");

           if (proxyon == 1){
               connection = url.openConnection(proxy);
           }
           else{
               connection = url.openConnection();
           }
         
           connection.setRequestProperty( "Authorization", "Basic " + encodecredentials);
           connection.setDoOutput(true);

           OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream());
           out.write("status=" + encodedData);
           out.close();

           BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));          
           String decodedString;
           while ((decodedString = in.readLine()) != null) {
               System.out.println(decodedString);
           }
           in.close();

           } catch (Exception e) {
               System.out.println(e.toString());
           }
   }

}