package org.kainos.ea.resources;

<<<<<<< HEAD
import org.kainos.ea.api.ClientService;
import org.kainos.ea.api.FailedToAssignClientException;
=======
import io.swagger.annotations.Api;
import org.kainos.ea.api.ClientService;
import org.kainos.ea.api.FailedToAssignClientException;
import org.kainos.ea.cli.ClientProjectRequest;
>>>>>>> rebase
import org.kainos.ea.client.InvalidClientException;
import org.kainos.ea.client.InvalidProjectException;
import org.kainos.ea.core.ClientValidator;
import org.kainos.ea.core.ProjectValidator;
import org.kainos.ea.db.ClientDAO;
import org.kainos.ea.db.ProjectDAO;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Api("Client")
@Path("/api")
public class ClientController {
    ClientDAO clientDAO = new ClientDAO();
    ClientValidator clientValidator = new ClientValidator(clientDAO);
    ProjectDAO projectDAO = new ProjectDAO();
    ProjectValidator projectValidator = new ProjectValidator(projectDAO);
    ClientService clientService = new ClientService(clientDAO, clientValidator, projectValidator);
    @POST
    @Path("/client")
    @Produces(MediaType.APPLICATION_JSON)
<<<<<<< HEAD
    public Response assignClientToProject(int clientId, int projectId){
        try{
            clientService.assignClientToProject(clientId, projectId);
            return Response.ok().build();
=======
    public Response assignClientToProject(ClientProjectRequest clientProjectRequest){
        try{
            return Response.ok(clientService.assignClientToProject(clientProjectRequest.getClientId(), clientProjectRequest.getProjectId())).build();
>>>>>>> rebase
        } catch (FailedToAssignClientException e) {
            System.err.println(e.getMessage());
            return Response.serverError().build();
        } catch (InvalidClientException | InvalidProjectException e){
            System.err.println(e.getMessage());

            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
    }
}
