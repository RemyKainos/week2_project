package org.kainos.ea.api;

import org.kainos.ea.client.InvalidClientException;
import org.kainos.ea.client.InvalidProjectException;
import org.kainos.ea.core.ClientValidator;
import org.kainos.ea.core.ProjectValidator;
import org.kainos.ea.db.ClientDAO;

import java.sql.SQLException;

public class ClientService {
    ClientDAO clientDAO;
    ClientValidator clientValidator;
    ProjectValidator projectValidator;

    public ClientService(ClientDAO clientDAO, ClientValidator clientValidator, ProjectValidator projectValidator) {
        this.clientDAO = clientDAO;
        this.clientValidator = clientValidator;
        this.projectValidator = projectValidator;
    }

    public int assignClientToProject(int clientId, int projectId) throws FailedToAssignClientException, InvalidClientException, InvalidProjectException {
        try{
            // Check if client is valid
            String validClient = clientValidator.isValidClientId(clientId);

            if(validClient != null){
                throw new InvalidClientException(validClient);
            }

            // Check if project exists
            String validProject = projectValidator.isValidProjectId(projectId);

            if(validProject != null){
                throw new InvalidProjectException(validProject);
            }

            // Assign client
            return clientDAO.assignClientToProject(clientId, projectId);
        } catch (SQLException e){
            throw new FailedTo
            AssignClientException();
        }
    }

}
