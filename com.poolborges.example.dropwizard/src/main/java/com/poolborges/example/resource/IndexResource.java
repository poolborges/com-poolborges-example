package com.poolborges.example.resource;

import java.util.Arrays;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
 
import com.yammer.metrics.annotation.Timed;
 
@Path("/")
public class IndexResource {
 
    @GET
    @Produces(value = MediaType.APPLICATION_JSON)
    @Timed
    public List<String> index() {
        return Arrays.asList(
                "Cesaria Evora", "Ildo Lobo", "Bana");
    }
}
