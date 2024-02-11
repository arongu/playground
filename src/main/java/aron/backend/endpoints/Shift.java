package aron.backend.endpoints;

import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Path("/shifts")
@Produces(MediaType.APPLICATION_JSON)
public class Shift {
    private static Set <String> planShift( final List <ShiftRecord> shiftRecords ) {
        final Set <String> planned = new HashSet <>();
        for ( ShiftRecord shift : shiftRecords ) {
            if ( shift.from() >= 8 && shift.to() <= 10 ) {
                planned.add("Checkout");
            } else if ( shift.from() >= 10 && shift.to() <= 12 ) {
                planned.add("Bakery");
            } else if ( shift.to() >= 14 && shift.to() <= 19 ) {
                planned.add("Diary");
            }
        }

        if ( shiftRecords.isEmpty() ) {
            planned.add("No shift recommendation.");
        }

        return planned;
    }

    @POST
    public Response post( final List <ShiftRecord> shifts ) {
        for ( ShiftRecord shift : shifts ) {
            System.out.println(shift);
        }

        return Response.status(200)
                       .entity(planShift(shifts))
                       .build();
    }
}
