package com.poolborges.example.apachewink;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import org.apache.wink.client.ClientConfig;
import org.apache.wink.client.Resource;
import org.apache.wink.client.RestClient;
import org.apache.commons.codec.binary.Base64;
import org.apache.wink.client.ClientResponse;
import org.apache.wink.client.handlers.BasicAuthSecurityHandler;
import org.apache.wink.common.internal.MultivaluedMapImpl;

/**
 *
 * @author Borges
 */
public class TwitterClient {

    private static RestClient client1() {

        ClientConfig clientConfig = new ClientConfig();
        //cc.proxyHost("iam-behind-a-proxy.com");
        //cc.proxyPort(80);

        RestClient client = new RestClient(clientConfig);

        return client;
    }

    private static RestClient client2() {
        ClientConfig config = new ClientConfig();

        BasicAuthSecurityHandler basicAuthHandler = new BasicAuthSecurityHandler();
        basicAuthHandler.setUserName("<USERNAME>");
        basicAuthHandler.setPassword("<PASSWORD-HERE>");

        config.handlers(basicAuthHandler);

        // create the rest client instance<br/>
        RestClient client = new RestClient(config);

        return client;
    }

    private static void getData0() {
    }

    private static void getData1() {
        RestClient client = client1();
        Resource twitter = client.resource("http://stream.twitter.com/1/statuses/filter.json?track=Berlin");

        twitter.contentType(MediaType.APPLICATION_FORM_URLENCODED_TYPE);
        twitter.accept(MediaType.APPLICATION_JSON_TYPE);

        // do the HTTP GET
        ClientResponse cr = twitter.get();

        // we want the input stream
        InputStream is = cr.getEntity(InputStream.class);
        try {

            BufferedReader r = new BufferedReader(new InputStreamReader(is, "UTF8"));
            String rawJsonTweetData = r.readLine();
            System.out.println("Twitter: " + rawJsonTweetData);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(TwitterClient.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(TwitterClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static void sendData1() {
        /* */
        RestClient client = client1();
        Resource twitter = client.resource("https://twitter.com/statuses/update.json");

        MultivaluedMap<String, String> msg = new MultivaluedMapImpl<String, String>();
        msg.add("status", "Poolborges is testing Apache Wink");
        twitter.post(String.class, msg);
        twitter.get();
    }

    private static void s() {
        // create the resource instance to interact with Resource<br/>

        String logon = "<USERNAME>:<PASSWORD-HERE>";
        String encodedLogon = new Base64().encodeAsString(logon.getBytes());

        RestClient client = client1();
        Resource twitter = client.resource("https://twitter.com/statuses/update.json");
        twitter.header("Authorization", "Basic " + encodedLogon);
        twitter.contentType(MediaType.APPLICATION_FORM_URLENCODED_TYPE);
        twitter.accept(MediaType.APPLICATION_JSON_TYPE);
    }

    public static void main(String[] args) {

        SendTwitter(args[0]);
    }

    public static void SendTwitter(String msg) {
        try {
            boolean isProxyEnabled = false;
            URLConnection connection;
            String credentials = "username" + ":" + "password";

            String encodecredentials = new Base64().encodeAsString(credentials.getBytes());

            URL url = new URL("http://twitter.com/statuses/update.xml");
            String encodedData = URLEncoder.encode(msg, "UTF-8");

            if (isProxyEnabled == true) {
                SocketAddress addr = new InetSocketAddress("www-yourproxy.com", 80);
                java.net.Proxy proxy = new java.net.Proxy(java.net.Proxy.Type.HTTP, addr);
                connection = url.openConnection(proxy);
            } else {
                connection = url.openConnection();
            }

            connection.setRequestProperty("Authorization", "Basic " + encodecredentials);
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

        } catch (IOException e) {
            System.out.println(e.toString());
        }
    }
}
