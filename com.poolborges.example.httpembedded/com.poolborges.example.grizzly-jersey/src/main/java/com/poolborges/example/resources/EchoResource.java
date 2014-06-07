package com.poolborges.example.resources;

//These are Jersey jars
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.UriInfo;

import java.net.URLEncoder;
import java.util.Iterator;
import javax.ws.rs.PathParam;
 
@Path("/resource/echo") 
public class EchoResource{

    @GET 
    @Produces(MediaType.TEXT_HTML)
    public String get(@Context UriInfo ui) {
    MultivaluedMap queryParams=ui.getQueryParameters();
        return showQueryParams(queryParams);      
    }
    
    @POST
    @Consumes("application/x-www-form-urlencoded")
    @Produces("text/html") 
    public String post(MultivaluedMap queryParams) {
        return showQueryParams(queryParams);    
    }
    
    @GET
    @Produces("text/plain")
    public String getUser(@PathParam("username") String userName) {
        return "Hello " + userName + "!";
    }
   
    //Extract the parameters.    
    protected String showQueryParams(MultivaluedMap queryParams) {
        Iterator it=queryParams.keySet().iterator();
        String theKey=null;
        String returnString="";   
        try {
            while(it.hasNext()) {
                theKey=(String)it.next();
                returnString += URLEncoder.encode(theKey,"UTF8")
                +"  "
                +URLEncoder.encode((String)queryParams.getFirst(theKey),"UTF-8");
            }
        }
        catch (Exception ex) { 
            //This will probably be an UnsupportedEncodingException.
            //Handle more apropriate.
            ex.printStackTrace();
            returnString=ex.getMessage();
        }
        return returnString;
    }


}
