/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poolborges.example.spring.model;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author PauloBorges
 */
@XmlRootElement(name = "book")
public class Book {

   private String author;
   private String ISBN;
   private String title;

   public Book() {
   }

   public Book(String author, String ISBN, String title) {
      this.author = author;
      this.ISBN = ISBN;
      this.title = title;
   }

   @XmlElement
   public String getAuthor() {
      return author;
   }

   public void setAuthor(String author) {
      this.author = author;
   }

   @XmlElement
   public String getISBN() {
      return ISBN;
   }

   public void setISBN(String ISBN) {
      this.ISBN = ISBN;
   }

   @XmlAttribute
   public String getTitle() {
      return title;
   }

   public void setTitle(String title) {
      this.title = title;
   }
}
