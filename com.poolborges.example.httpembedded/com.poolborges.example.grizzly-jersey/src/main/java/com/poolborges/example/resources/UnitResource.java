package com.poolborges.example.resources;


// UnitResource Resource
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
 
@Path("/unit")
public class UnitResource {
 
    @GET
    @Produces("application/json")
    @Path("get/{zipcode}")
    public String getUnit(@PathParam("zipcode") String zipCode) 
    {
        String name = "Unit 3";

       // Do calculations
       // Get object, convert to JSON string.
       return name;
    }
}
