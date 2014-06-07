/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poolborges.example.cayenne.persistence;

import org.apache.cayenne.ObjectContext;
import org.apache.cayenne.configuration.server.ServerRuntime;

/**
 *
 * @author Borges
 */
public class Main {

    public static void main(String[] args) {

        //org.apache.log4j.PropertyConfigurator.configure("cayenne-log.properties");

        ServerRuntime cayenneRuntime = new ServerRuntime("cayenne-janusDomain.xml");
        ObjectContext context = cayenneRuntime.getContext();

        Artist picasso = context.newObject(Artist.class);
        picasso.setName("Pablo Picasso");
        picasso.setDateOfBirthString("18811025");

        Gallery metropolitan = context.newObject(Gallery.class);
        metropolitan.setName("Metropolitan Museum of Art");

        Painting girl = context.newObject(Painting.class);
        girl.setName("Girl Reading at a Table");

        Painting stein = context.newObject(Painting.class);
        stein.setName("Gertrude Stein");

        picasso.addToPaintings(girl);
        picasso.addToPaintings(stein);

        girl.setGallery(metropolitan);
        stein.setGallery(metropolitan);
        
        context.commitChanges();
    }
}