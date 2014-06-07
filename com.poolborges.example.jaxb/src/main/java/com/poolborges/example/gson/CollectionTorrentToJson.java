/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poolborges.example.gson;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
 

public class CollectionTorrentToJson {
    public static void main(String[] args) {
        //
        // Converts a collection of string object into JSON string.
        //
       
 
        Gson gson;
 
        //
        // Converts a collection Student object into JSON string
        //
        Torrent trTorrent = new Torrent("OpenOffice - Windows - Linux - Mac", 
                633464879, "http://fenopy.eu/torrent/openoffice+windows+linux+mac/NTM2NTY2Mw", 
                "http://fenopy.eu/torrent/OpenOffice-Windows-Linux-Mac/NTM2NTY2Mw==/download.torrent", 
                "magnet:?xt=urn:btih:38c5eaaf88faa41bd4a677b0c7da1dfda9cc268e&dn=OpenOffice+-+Windows+-+Linux+-+Mac", 
                "38c5eaaf88faa41bd4a677b0c7da1dfda9cc268e", 
                "Applications", 16, 1, 0);
        
        Torrent trTorrentA = new Torrent("OpenOffice 3.3.0 Windows x86 en-US Application windows/software", 
                633464879, "http://fenopy.eu/torrent/openoffice+3+3+0+windows+x86+en+us+application+windows+software/NjYyOTEyMQ", 
                "http://fenopy.eu/torrent/OpenOffice-3-3-0-Windows-x86-en-US-Application-windows-software/NjYyOTEyMQ==/download.torrent", 
                "magnet:?xt=urn:btih:eeb444aa863286dcc87efcabb1f6df83d5b98144&dn=OpenOffice+3.3.0+Windows+x86+en-US+Application+windows%2Fsoftware", 
                "eeb444aa863286dcc87efcabb1f6df83d5b98144", 
                "Applications", 12, 0, 0);
  
 
        List<Torrent> trz = new ArrayList<Torrent>();
        trz.add(trTorrent);
 
        gson = new Gson();
        String jsonStudents = gson.toJson(trz);
        System.out.println("Torrent: " + jsonStudents);
 
        //
        // Converts JSON string into a collection of Student object.
        //
        /*
        Type type = new TypeToken<List<Student>>(){}.getType();
        List<Student> studentList = gson.fromJson(jsonStudents, type);
 
        for (Student student : studentList) {
            System.out.println("student.getName() = " + student.getName());
        }*/
    }
}

