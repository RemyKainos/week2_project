package org.kainos.ea.core;

import org.kainos.ea.cli.Client;
import org.kainos.ea.db.ClientDAO;

import java.sql.SQLException;

public class ClientValidator {
    private final ClientDAO clientDAO;

    public ClientValidator(ClientDAO clientDAO) {
        this.clientDAO = clientDAO;
    }

    public String isValidClientId(int clientId) throws SQLException {
        // Check client exists
       Client client = clientDAO.getClientById(clientId);

       if(client == null){
           return "Client does not exist";
       }

       return null;
    }
}
