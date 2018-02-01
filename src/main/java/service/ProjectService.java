package service;

import businesslogic.Util;
import dao.ProjectDAO;
import entity.Project;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProjectService extends Util implements ProjectDAO {

    //private Connection connection = getConnection();

    @Override
    public void addProject(Project project) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        String sql = "INSERT INTO project (project_id, title) VALUES (?, ?)";

        try {
            connection = getConnection();
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, project.getProjectID());
            preparedStatement.setString(2, project.getTitle());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }

    }

    @Override
    public List<Project> getAllProjects() throws SQLException {
        List<Project> projectList = new ArrayList<>();

        //Statement statement = null;

        String sql = "SELECT * FROM project";

        try (Connection connection = getConnection();
             Statement statement =connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)){
            //statement = connection.createStatement();

            //ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Project project = new Project();

                project.setProjectID(resultSet.getInt("project_id"));
                project.setTitle(resultSet.getString("title"));

                projectList.add(project);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return projectList;
    }

    @Override
    public Project getProjectById(int projectID) throws SQLException {
        // PreparedStatement preparedStatement = null;

        String sql = "SELECT * FROM project WHERE project_id=?";

        Project project = new Project();

        // try with resource
        try(Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, projectID);

            ResultSet resultSet = preparedStatement.executeQuery();

            project.setProjectID(resultSet.getInt("project_id"));
            project.setTitle(resultSet.getString("title"));

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return project;
    }

    @Override
    public void updateProject(Project project) throws SQLException {
        String sql = "UPDATE project SET title=? WHERE project_id=?";

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, project.getProjectID());
            preparedStatement.setString(2, project.getTitle());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void removeProject(Project project) throws SQLException {
        String sql = "DELETE FROM project WHERE project_id=?";

        try (Connection connection = null;
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, project.getProjectID());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
