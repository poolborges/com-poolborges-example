package com.poolborges.example.xstream;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Borges
 */
public class Blog {

    private Author writer;
    private List<Entry> entries = new ArrayList<Entry>();

    public Blog(Author writer) {
        this.writer = writer;
    }

    public void add(Entry entry) {
        entries.add(entry);
    }

    public List<Entry> getContent() {
        return entries;
    }

    @Override
    public String toString() {

        StringBuilder notas = new StringBuilder();
        for (int i = 0; i < entries.size(); i++) {
            notas.append(entries.get(i).toString()).append("; ");
        }

        return "writer: " + this.writer.getName() + "\nEntries: " + notas;
    }
}
