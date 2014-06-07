/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poolborges.example.gson;

/**
 *
 * @author Borges
 */
public class Torrent {

    private String name;
    private int size;
    private String page;
    private String torrent;
    private String magnet;
    private String hash;
    private String category;
    private int seeder;
    private int leecher;
    private int verified;

    public Torrent(String name, int size, String page, String torrent, String magnet, String hash, String category, int seeder, int leecher, int verified) {
        this.name = name;
        this.size = size;
        this.page = page;
        this.torrent = torrent;
        this.magnet = magnet;
        this.hash = hash;
        this.category = category;
        this.seeder = seeder;
        this.leecher = leecher;
        this.verified = verified;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public String getTorrent() {
        return torrent;
    }

    public void setTorrent(String torrent) {
        this.torrent = torrent;
    }

    public String getMagnet() {
        return magnet;
    }

    public void setMagnet(String magnet) {
        this.magnet = magnet;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getSeeder() {
        return seeder;
    }

    public void setSeeder(int seeder) {
        this.seeder = seeder;
    }

    public int getLeecher() {
        return leecher;
    }

    public void setLeecher(int leecher) {
        this.leecher = leecher;
    }

    public int isVerified() {
        return verified;
    }

    public void setVerified(int verified) {
        this.verified = verified;
    }
    
    
}
