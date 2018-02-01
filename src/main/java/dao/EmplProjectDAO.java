package dao;

import entity.EmplProject;

import java.sql.SQLException;
import java.util.List;

public interface EmplProjectDAO {

    // create
    void addEmplProject(EmplProject emplProject) throws SQLException;

    // read
    List<EmplProject> getAllEmplProjects() throws SQLException;
    EmplProject getEmployeeAndProjectById(int employeeID, int projectID) throws SQLException;

    // update
    void updateEmplProject(EmplProject emplProject) throws SQLException;

    // delete
    void removeEmplProject(EmplProject emplProject) throws SQLException;
}
