package org.kainos.ea.cli;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ClientProjectRequest {
    private int clientId;
    private int projectId;

    @JsonCreator
    public ClientProjectRequest(@JsonProperty("clientId") int clientId, @JsonProperty("projectId") int projectId) {
        this.clientId = clientId;
        this.projectId = projectId;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }
}
