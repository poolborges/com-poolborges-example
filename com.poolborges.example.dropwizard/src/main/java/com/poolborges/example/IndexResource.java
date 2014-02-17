package com.poolborges.example;

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
    public List<Blog> index() {
        return Arrays.asList(
                new Blog("Day 12: OpenCV--Face Detection for Java Developers",
                "https://www.openshift.com/blogs/day-12-opencv-face-detection-for-java-developers"),
                new Blog("Janus Mod_UploaderNG","Este Modulo ira permitir envio para varios servidores "),
                new Blog("Janus Mod_Webservice","Este Modulo criar um serviço Restfull"));
    }
}
