/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poolborges.example.smvc.model;

import java.util.Date;

/**
 *
 * @author Borges
 */
public class Article {
    
    private String id;
    private String title;
    private String author;
    private String summary;
    private String content;
    private Date date;

    public Article(String title, String author, Date date, String summary, String content ) {

        this.title = title;
        this.author = author;
        this.summary = summary;
        this.content = content;
        this.date = date;
    }

    public Article(String id, String title, String author, Date date, String summary, String content) {

        this.id = id;
        this.title = title;
        this.author = author;
        this.date = date;
        this.summary = summary;
        this.content = content;
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    
    /**
     * Compare with ot
     * @param obj
     * @return 
     */
    public int compareByDate(Object obj){
        // Comparing the other date to ours should order descending 
        int result = ((Article)obj).getDate().compareTo(date);
        if( result == 0 ) {
            // Ensure that we don't lose any articles that have the same date
            return 1;
        }
        return result;
    }   
    
}
