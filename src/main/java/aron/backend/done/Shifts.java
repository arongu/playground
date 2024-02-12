package aron.backend.done;

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
public class Shifts {
    private static final String NO_SHIFT_RECOMMENDATION = "No shift recommendation.";

    public static Set <String> planShift( final List <ShiftRecord> shiftRecords ) {
        final Set <String> planned = new HashSet <>();
        if ( shiftRecords == null || shiftRecords.isEmpty() ) {
            planned.add(NO_SHIFT_RECOMMENDATION);

        } else {
            for ( ShiftRecord shift : shiftRecords ) {
                if ( shift.to() > 8 && shift.from() <= 10 ) {
                    planned.add("Bakery");
                }

                if ( shift.to() > 10 && shift.from() <= 12 ) {
                    planned.add("Checkout");
                }

                if ( shift.to() > 14 && shift.from() <= 19 ) {
                    planned.add("Dairy");
                }
            }

            if ( planned.isEmpty() ) {
                planned.add(NO_SHIFT_RECOMMENDATION);
            }
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
