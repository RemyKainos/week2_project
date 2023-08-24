package org.kainos.ea.resources;

import org.kainos.ea.api.DeliveryEmployeeService;
import org.kainos.ea.cli.DeliveryEmployee;
import org.kainos.ea.cli.DeliveryEmployeeRequest;
import org.kainos.ea.client.FailedToCreateDeliveryEmployee;
import org.kainos.ea.db.DeliveryDao;

import javax.print.attribute.standard.Media;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import io.swagger.annotations.Api;

@Api("Delivery Employee")
@Path("/api")
public class DeliveryEmployeeController {
    DeliveryDao deliveryDao = new DeliveryDao();
    DeliveryEmployeeService deliveryService = new DeliveryEmployeeService(deliveryDao);
    @POST
    @Path("/deliveryEmployee")
    @Produces(MediaType.APPLICATION_JSON)
    public Response createDeliveryEmployee(DeliveryEmployeeRequest employeeToCreate){
        try{
            return Response.ok(deliveryService.createDeliveryEmployee(employeeToCreate)).build();
        } catch (FailedToCreateDeliveryEmployee e) {
            System.err.println(e.getMessage());
            return Response.serverError().build();
        }
    }
    @DELETE
    @Path("/delivery/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteDeliveryEmployee(@PathParam("id") int id)
    {
        try
        {
            deliveryService.deleteOrder(id);
            return Response.ok().build();
        } catch (OrderDoesNotExistException e) {
            System.err.println(e.getMessage());
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        } catch (FailedToDeleteOrderException e) {
            System.err.println(e.getMessage());
            return Response.serverError().build();
        }
    }
}
