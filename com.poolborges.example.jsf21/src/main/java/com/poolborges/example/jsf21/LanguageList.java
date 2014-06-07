/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poolborges.example.jsf21;

import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Borges
 */
@ManagedBean(name="languageList")
@ViewScoped
public class LanguageList {
    private ArrayList<String> users;
   private String selectedUser;
 
   @PostConstruct
   public void create (){
	users = new ArrayList <String> ();
	users.add("English");
	users.add("Portugues");
	users.add("Frances");
	users.add("Latin");
	users.add("Aramaico");
	users.add("Crioulo");
	users.add("Mandarin");
	users.add("Espanhol");
   }
   public void delete (){
	users.remove(selectedUser);
   }
   public String getSelectedUser() {
	return selectedUser;
   }
   public void setSelectedUser(String selectedUser) {
	this.selectedUser = selectedUser;
   }
   public ArrayList<String> getUsers() {
	return users;
   }
}
