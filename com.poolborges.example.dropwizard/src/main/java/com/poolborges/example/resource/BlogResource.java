package com.poolborges.example.resource;

import com.poolborges.example.model.Blog;
import java.util.Arrays;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
 
import com.yammer.metrics.annotation.Timed;
 
@Path("/blog")
public class BlogResource {
 
    @GET
    @Produces(value = MediaType.APPLICATION_JSON)
    @Timed
    public List<Blog> index() {
        return Arrays.asList(
                
                new Blog("Day 12: OpenCV--Face Detection for Java Developers",
                "https://www.openshift.com/blogs/day-12-opencv-face-detection-for-java-developers"),
                
                new Blog("Day 30: Play Framework--A Java Developer Dream Framework",
                        "https://www.openshift.com/blogs/day-30-play-framework-a-java-developer-dream-framework") ,
                new Blog("Day 13: Dropwizard--The Awesome Java REST Server Stack",
                        "https://www.openshift.com/blogs/day-13-dropwizard-the-awesome-java-rest-server-stack"),
                
                new Blog("Blog Uploader","Este Modulo ira permitir envio para varios servidores "),
                
                new Blog("Blog Restfull","Este Modulo criar um serviço Restfull"));
    }
}
