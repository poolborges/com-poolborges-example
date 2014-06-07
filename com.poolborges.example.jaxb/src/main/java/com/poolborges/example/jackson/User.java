/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poolborges.example.jackson;

import java.util.ArrayList;
import java.util.List;
 
public class User {
 
	private int age = 29;
	private String name = "mkyong";
	private List<String> messages = new ArrayList<String>() {
		{
			add("msg 1");
			add("msg 2");
			add("msg 3");
		}
	};
 
	//getter and setter methods
 
	@Override
	public String toString() {
		return "User [age=" + age + ", name=" + name + ", " +
				"messages=" + messages + "]";
	}
}
