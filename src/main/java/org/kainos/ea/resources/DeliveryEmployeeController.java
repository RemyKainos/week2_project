package org.kainos.ea.resources;

import org.kainos.ea.api.DeliveryEmployeeService;
import org.kainos.ea.cli.DeliveryEmployee;
import org.kainos.ea.cli.DeliveryEmployeeRequest;
import org.kainos.ea.client.FailedToCreateDeliveryEmployee;
import org.kainos.ea.db.DeliveryDao;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import io.swagger.annotations.Api;

@Api("Delivery Employee")
@Path("/api")
public class DeliveryEmployeeController {
    DeliveryEmployeeService deliveryService = new DeliveryEmployeeService();
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
}
