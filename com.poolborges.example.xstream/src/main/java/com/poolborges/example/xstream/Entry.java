package com.poolborges.example.xstream;

/**
 *
 * @author Borges
 */
public class Entry {

    private String title, description;

    public Entry(String title, String description) {
        this.title = title;
        this.description = description;
    }

    @Override
    public String toString() {
        return title;
    }
}
