package org.kainos.ea.resources;

import org.kainos.ea.api.DeliveryEmployeeService;
import org.kainos.ea.cli.DeliveryEmployee;
import org.kainos.ea.cli.DeliveryEmployeeRequest;
import org.kainos.ea.cli.DeliveryEmployeeUpdateRequest;
import org.kainos.ea.client.DeliveryEmployeeDoesNotExist;
import org.kainos.ea.client.FailedToCreateDeliveryEmployee;
import org.kainos.ea.client.FailedToUpdateDeliveryEmployee;
import org.kainos.ea.client.FailedToValidateEmployee;
import org.kainos.ea.core.DeliveryEmployeeValidator;
import org.kainos.ea.db.DeliveryDao;

import javax.print.attribute.standard.Media;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import io.swagger.annotations.Api;

import java.sql.SQLException;

@Api("Delivery Employee")
@Path("/api")
public class DeliveryEmployeeController {
    DeliveryDao deliveryDao = new DeliveryDao();
    DeliveryEmployeeValidator deliveryEmployeeValidator = new DeliveryEmployeeValidator(deliveryDao);
    DeliveryEmployeeService deliveryService = new DeliveryEmployeeService(deliveryDao, deliveryEmployeeValidator);
    @POST
    @Path("/deliveryEmployee")
    @Produces(MediaType.APPLICATION_JSON)
    public Response createDeliveryEmployee(DeliveryEmployeeRequest employeeToCreate){
        try{
            deliveryService.createDeliveryEmployee(employeeToCreate);
            return Response.status(Response.Status.CREATED).build();
        } catch (FailedToCreateDeliveryEmployee e) {
            System.err.println(e.getMessage());
            return Response.serverError().build();
        } catch (FailedToValidateEmployee e) {
            System.err.println(e.getMessage());
            return Response.serverError().build();
        }
    }
    @PUT
    @Path("/deliveryEmployee/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateDeliveryEmployee(@PathParam("id") int id, DeliveryEmployeeUpdateRequest employeeToUpdate)
    {
        try{
            String validation = deliveryEmployeeValidator.isDeliveryUpdateValid(employeeToUpdate);
            if(validation != null)
            {
                System.err.println(validation);
                return Response.status(Response.Status.BAD_REQUEST).build();
            }
            deliveryService.updateDeliveryEmployee(id,employeeToUpdate);
            return Response.ok().build();
        } catch (FailedToUpdateDeliveryEmployee e) {
            System.err.println(e.getMessage());
            return  Response.serverError().build();
        } catch (DeliveryEmployeeDoesNotExist e) {
            System.err.println(e.getMessage());
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
