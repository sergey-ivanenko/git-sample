package dao;

import entity.Project;

import java.sql.SQLException;
import java.util.List;

public interface ProjectDAO {

    // create
    void addProject(Project project) throws SQLException;

    // read
    List<Project> getAllProjects() throws SQLException;
    Project getProjectById(int projectID) throws SQLException;

    // update
    void updateProject(Project project) throws SQLException;

    // delete
    void removeProject(Project project) throws SQLException;
}
