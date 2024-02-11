package aron.backend.rest;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;


@Path("/hello")
@Produces(MediaType.APPLICATION_JSON)
public class Hello {

    @GET
    public String helloRoot(){
        return "Hello from /hello!";
    }

    @GET
    @Path("/{name}")
    public Response sayHello( @PathParam("name") final String msg ) {
        final String output = "{ \"message\": \"Hello, " + msg + "!\" }";
        return Response.status(200).entity(output).build();
    }
}
