package aron.backend.rest;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/hello")
@Produces(MediaType.APPLICATION_JSON)
public class Hello {
    @GET
    public String helloRoot() {
        return "Hello from /hello!";
    }

    @GET
    @Path("/{name}")
    public Response helloPathParam( @PathParam("name") final String name ) {
        final Message message = new Message("Hello " + name + "!");
        return Response.status(200).entity(message).build();
    }

    @GET
    @Path("/query")
    public Response helloQueryParam( @QueryParam("from") final String from,
                                     @QueryParam("to") final String to ) {

        return Response.status(200)
                       .entity(new Message("from= " + from + ", to= " + to))
                       .build();
    }

    @GET
    @Path("/queries")
    public Response helloQueryList( @QueryParam("list") List <String> list) {
        StringBuilder stringBuilder = new StringBuilder();
        for ( int i = 0; i < list.size(); i++ ) {
            stringBuilder.append(list.get(i));
            if ( i < list.size() -1 ) {
                stringBuilder.append(" ");
            }
        }

        return Response.status(200)
                       .entity(new Message("list= " + stringBuilder))
                       .build();
    }
}
