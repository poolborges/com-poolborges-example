/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poolborges.example.gson;


import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
 
public class GsonExampleFromJson {
    public static void main(String[] args) {
 
	Gson gson = new Gson();
 
	try {
 
		BufferedReader br = new BufferedReader(
			new FileReader("file.json"));
 
		//convert the json string back to object
		DataObject obj = gson.fromJson(br, DataObject.class);
 
		System.out.println(obj);
 
	} catch (IOException e) {
		e.printStackTrace();
	}
 
    }
}