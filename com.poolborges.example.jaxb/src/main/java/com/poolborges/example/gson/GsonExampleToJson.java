/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poolborges.example.gson;


import com.google.gson.Gson;
import java.io.FileWriter;
import java.io.IOException;
 
public class GsonExampleToJson {
    public static void main(String[] args) {
 
	DataObject obj = new DataObject();
	Gson gson = new Gson();
 
	// convert java object to JSON format,
	// and returned as JSON formatted string
	String json = gson.toJson(obj);
 
	try {
		//write converted json data to a file named "file.json"
		FileWriter writer = new FileWriter("file.json");
		writer.write(json);
		writer.close();
 
	} catch (IOException e) {
		e.printStackTrace();
	}
 
	System.out.println(json);
 
    }
}