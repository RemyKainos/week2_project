package org.kainos.ea.resources;

import org.kainos.ea.api.SalesService;
import org.kainos.ea.cli.SalesEmployeeRequest;
import org.kainos.ea.client.FailedToCreateSalesEmployeeException;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import io.swagger.annotations.Api;
import org.kainos.ea.client.InvalidSalesEmployeeException;
import org.kainos.ea.db.SalesDAO;

@Api("Sales Employee API")
@Path("/api")
public class SalesEmployeeController {
    private SalesDAO salesDao = new SalesDAO();
    private SalesService salesService = new SalesService(salesDao);

    @POST
    @Path("/sales_employees")
    @Produces(MediaType.APPLICATION_JSON)
    public Response createSalesEmployee(SalesEmployeeRequest salesEmployee) {
        try {
            return Response.status(Response.Status.CREATED).entity(salesService.createSalesEmployee(salesEmployee)).build();

        } catch (FailedToCreateSalesEmployeeException e) {
            System.err.println(e.getMessage());
            return Response.serverError().build();
        } catch (InvalidSalesEmployeeException e) {
            System.err.println(e.getMessage());
            return Response.serverError().build();
        }
    }
}
