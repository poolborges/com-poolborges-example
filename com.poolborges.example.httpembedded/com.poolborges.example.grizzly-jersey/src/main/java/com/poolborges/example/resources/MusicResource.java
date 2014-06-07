package com.poolborges.example.resources;

import com.poolborges.example.resources.model.Music;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;


@Path("/resource/music")
public class MusicResource {

    @GET
    @Path("/get")
    @Produces(MediaType.APPLICATION_JSON)
    public Music getMusicInJSON() {

        Music track = new Music();
        track.setTitle("Enter Sandman");
        track.setSinger("Metallica");
        track.setDuration(180);
        return track;

    }
    @GET
    @Path("/gets")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Music> getMusicsInJSON() {

        Music mus1 = new Music();
        mus1.setTitle("Enter Sandman");
        mus1.setSinger("Metallica");
        mus1.setDuration(180);

        List<Music> listMusic = new ArrayList<Music>();
        listMusic.add(mus1);

        mus1.setTitle("Sodade");
        mus1.setSinger("Cesaria Evora");
        mus1.setDuration(180);
        listMusic.add(mus1);

        return listMusic;

    }

    @POST
    @Path("/post")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createTrackInJSON(Music track) {

        String result = "Track saved : " + track;
        return Response.status(201).entity(result).build();

    }
}
