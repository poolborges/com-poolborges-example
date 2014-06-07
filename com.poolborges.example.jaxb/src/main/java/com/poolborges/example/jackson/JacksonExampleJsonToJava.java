/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poolborges.example.jackson;

import java.io.File;
import java.io.IOException;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

public class JacksonExampleJsonToJava {

    public static void main(String[] args) {

        ObjectMapper mapper = new ObjectMapper();

        try {

            // read from file, convert it to user class
            User user = mapper.readValue(new File("user-example.json"), User.class);

            // display to console
            System.out.println(user);

        } catch (JsonGenerationException e) {

            e.printStackTrace();

        } catch (JsonMappingException e) {

            e.printStackTrace();

        } catch (IOException e) {

            e.printStackTrace();

        }
    }
}