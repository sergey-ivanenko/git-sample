package service;

import businesslogic.Util;
import dao.EmplProjectDAO;
import entity.EmplProject;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmplProjectService extends Util implements EmplProjectDAO {

    //private Connection connection = getConnection();

    @Override
    public void addEmplProject(EmplProject emplProject) throws SQLException {
        String sql = "INSERT INTO empl_project (empl_id, proj_id) VALUES (?, ?)";

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, emplProject.getEmployeeID());
            preparedStatement.setInt(2, emplProject.getProjectID());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<EmplProject> getAllEmplProjects() throws SQLException {
        List<EmplProject> emplProjectList = new ArrayList<>();

        String sql = "SELECT * FROM empl_project";

        try (Connection connection = getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);

            EmplProject emplProject = new EmplProject();

            while (resultSet.next()) {
                emplProject.setEmployeeID(resultSet.getInt("employee_id"));
                emplProject.setProjectID(resultSet.getInt("project_id"));

                emplProjectList.add(emplProject);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return emplProjectList;
    }

    @Override
    public EmplProject getEmployeeAndProjectById(int employeeID, int projectID) throws SQLException {
        String sql = "SELECT * FROM empl_project WHERE empl_id=? AND proj_id=?";

        EmplProject emplProject = new EmplProject();

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, employeeID);
            preparedStatement.setInt(2, projectID);

            ResultSet resultSet = preparedStatement.executeQuery();

            emplProject.setEmployeeID(resultSet.getInt("employee_id"));
            emplProject.setEmployeeID(resultSet.getInt("project_id"));

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return emplProject;
    }

    @Override
    public void updateEmplProject(EmplProject emplProject) throws SQLException {
        String sql = "UPDATE empl_project SET empl_id=?, proj_id=?";

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, emplProject.getEmployeeID());
            preparedStatement.setInt(2, emplProject.getProjectID());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void removeEmplProject(EmplProject emplProject) throws SQLException {
        String sql = "DELETE FROM empl_project WHERE empl_id=? AND proj_id=?";

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, emplProject.getEmployeeID());
            preparedStatement.setInt(2, emplProject.getProjectID());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
