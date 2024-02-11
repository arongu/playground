package aron.backend.rest;

import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/shifts")
@Produces(MediaType.APPLICATION_JSON)
public class Shift {
    @POST
    public Response post( final List <ShiftRecord> shifts ) {
        for ( ShiftRecord shift : shifts ) {
            System.out.println(shift);
        }
        return Response.status(200).entity(shifts).build();
    }
}
