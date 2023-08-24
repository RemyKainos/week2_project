package org.kainos.ea.core;

import org.kainos.ea.cli.Project;
import org.kainos.ea.db.ProjectDAO;

import java.sql.SQLException;

public class ProjectValidator {
    private final ProjectDAO projectDAO;

    public ProjectValidator(ProjectDAO projectDAO) {
        this.projectDAO = projectDAO;
    }

    public String isValidProjectId(int projectId) throws SQLException {
        // Check project exists
        Project project = projectDAO.getProjectById(projectId);

        if(project == null){
            return "Project does not exist";
        }

        return null;
    }
}
