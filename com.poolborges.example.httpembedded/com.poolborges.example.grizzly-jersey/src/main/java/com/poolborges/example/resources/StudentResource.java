package com.poolborges.example.resources;

import com.poolborges.example.resources.model.Student;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/resource/student")
public class StudentResource {

	@GET
	@Path("/print/{name}")
	@Produces("application/json")
        //@Produces(MediaType.APPLICATION_JSON)
	public Student getStudentByJSON(@PathParam("name") String name) {

		Student st = new Student(name, "Marco", 19, 12);

		return st;

	}
/*
    @GET
    @Produces( { MediaType.APPLICATION_JSON })
    @Path("/get/{who}")
    public Response sayGreeting(@PathParam("who") String name) {
        ObjectNode result = JsonNodeFactory.instance.objectNode();
        result.put("name", name);
        return Response.ok().entity(result).build();
    }
*/
}
